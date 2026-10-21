package com.escape.dongnae.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import java.util.Vector;
import java.sql.*;

import com.escape.dongnae.dao.ChatDAO;
import com.escape.dongnae.model.PlayerInfo;
import com.escape.dongnae.model.Chat;

interface HintControllerInterface {
	// 각 사용자별 대화 내용을 반환하는 메소드
	public abstract Chat getChat(byte roomNumber, byte objectNumber) throws Exception;
	// 플레이어의 남은 시간을 1분 감소하는 메소드
	public abstract void decrease1LeftMinutes(PlayerInfo playerInfo);
}

// 힌트를 보여주기 위한 컨트롤러
@WebServlet("/hint")
public class HintController extends HttpServlet implements HintControllerInterface {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		
		PlayerInfo playerInfo = (PlayerInfo)session.getAttribute("player_info");
		
		// 힌트 제공 시 플레이어의 남은 시간을 1분 감소시킴.
		this.decrease1LeftMinutes(playerInfo);
		session.setAttribute("player_info", playerInfo);

		// 상태창 설정
		PlayerInfoController.printPlayerInfo(request, response, playerInfo, "problem_set.jsp");

		// request의 속성과 값을 설정하기 위한 벡터
		Vector<String> attributeStrings = new Vector<>();
		Vector<Object> attributeObjects = new Vector<>();

		byte roomNumber = Byte.parseByte(request.getParameter("room"));
		byte objectNumber = Byte.parseByte(request.getParameter("object"));
		attributeStrings.add("room_number"); attributeObjects.add(roomNumber);
		attributeStrings.add("object_number"); attributeObjects.add(objectNumber);
		
		// 채팅 정보를 불러옴.
		try {
			Chat chat = this.getChat(roomNumber, objectNumber);

			// 넘어갈 다음 url
			String nextUrl = "solve-problem?room=" + roomNumber + "&object=" + objectNumber;

			// 채팅 페이지로 넘어감.
			new ChatController().sendRedirectToChat(response, session, roomNumber, objectNumber,
					attributeStrings, attributeObjects, nextUrl, chat, true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 각 사용자별 대화 내용을 반환하는 메소드
	@Override
	public Chat getChat(byte roomNumber, byte objectNumber)
			throws Exception {
		Chat chat = new ChatDAO().getChat((byte)4, roomNumber, objectNumber);
		return chat;
	}
	
	// 플레이어의 남은 시간을 1분 감소하는 메소드
	@Override
	public void decrease1LeftMinutes(PlayerInfo playerInfo) {
		short leftSeconds = playerInfo.getLeftSeconds();
		leftSeconds -= 1 * 60;
		if (leftSeconds <= 0) // 남은 시간이 0초 미만일 수는 없음.
			leftSeconds = 1;
		playerInfo.setLeftSeconds(leftSeconds);
	}
}