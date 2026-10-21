package com.escape.dongnae.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import java.util.Vector;

import com.escape.dongnae.dao.ChatDAO;
import com.escape.dongnae.model.PlayerInfo;
import com.escape.dongnae.model.Chat;

interface RoomControllerInterface {
	// 플레이어가 풀어야 할 오브젝트 번호를 반환하는 메소드
	public abstract byte getSolveObjectNumber(PlayerInfo playerInfo, byte roomNumber);
	// 각 사용자별 대화 내용을 반환하는 메소드
	public abstract Chat getChat(byte roomNumber) throws Exception;

	// info 버튼을 클릭하라는 레이블을 구성하는 메소드
	public abstract String getShowInfoMessage(HttpSession session, PlayerInfo playerInfo);
}

// 방의 구성을 설정하는 컨트롤러
// 입장한 방 번호에 따라 5개의 오브젝트를 설정함.
@WebServlet("/enter-room")
public class RoomController extends HttpServlet implements RoomControllerInterface {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();

		PlayerInfo playerInfo = (PlayerInfo)session.getAttribute("player_info");

		// 방 번호
		byte roomNumber = Byte.parseByte(request.getParameter("room")); // 입장할 방 번호
		// 플레이어가 풀어야 할 오브젝트 번호
		byte solveObjectNumber = this.getSolveObjectNumber(playerInfo, roomNumber);
		// 채팅으로 넘어갈 것인지 확인하기 위해 사용됨.
		boolean showChat = Boolean.parseBoolean(request.getParameter("show-chat"));
		// info 버튼을 클릭하라는 레이블의 메시지
		String showInfoMessage = this.getShowInfoMessage(session, playerInfo);
		
		if (showChat) { // 채팅으로 넘어감.
			try {
				// 채팅 정보를 불러옴.
				Chat chat = this.getChat(roomNumber);
				
				// 넘어갈 다음 url
				String nextUrl = "room.jsp";
				
				Vector<String> attributeStrings = new Vector<>();
				Vector<Object> attributeObjects = new Vector<>();
				attributeStrings.add("room_number"); attributeObjects.add(roomNumber);
				attributeStrings.add("solve_object_number"); attributeObjects.add(solveObjectNumber);
				attributeStrings.add("show_info_message"); attributeObjects.add(showInfoMessage);
				
				new ChatController().sendRedirectToChat(response, session,
						roomNumber, solveObjectNumber,
						attributeStrings, attributeObjects,
						nextUrl, chat, true);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		else { // 채팅으로 넘어가지 않음.
			// 상태창 설정
			PlayerInfoController.printPlayerInfo(request, response, playerInfo, "problem_result.jsp");

			request.setAttribute("room_number", roomNumber);
			request.setAttribute("solve_object_number", solveObjectNumber);
			request.setAttribute("show_info_message", showInfoMessage);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("room.jsp");
			requestDispatcher.forward(request, response);
		}
	}
	
	// 플레이어가 풀어야 할 오브젝트 번호를 반환하는 메소드
	@Override
	public byte getSolveObjectNumber(PlayerInfo playerInfo, byte roomNumber) {
		// 플레이어가 해결한 오브젝트 목록
		boolean[][] solvedObjects = playerInfo.getSolvedObjests();
		for (byte i = 0; i < solvedObjects[roomNumber - 1].length; i++) {
			if (!solvedObjects[roomNumber - 1][i])
				return (byte)(i + 1);
		}
		return -1;
	}

	// 각 사용자별 대화 내용을 반환하는 메소드
	@Override
	public Chat getChat(byte roomNumber) throws Exception {
		Chat chat = new ChatDAO().getChat((byte)2, roomNumber);
		return chat;
	}
	
	// info 버튼을 클릭하라는 레이블을 구성하는 메소드
	@Override
	public String getShowInfoMessage(HttpSession session, PlayerInfo playerInfo) {
		// 각 오브젝트의 해결 여부
		boolean[][] solvedObjects = playerInfo.getSolvedObjests();
		// 각 오브젝트의 설명 조회 여부
		boolean[][] checkedObjectInfos = (boolean[][])session.getAttribute("checkedObjectInfos");
		
		for (byte i = 0; i < solvedObjects.length; i++) {
			for (byte j = 0; j < solvedObjects[i].length; j++) {
				if (!solvedObjects[i][j]) {
					if (checkedObjectInfos[i][j])
						return "";
					else
						return "← 게임 진행에 필요한 정보를 수집하세요.";
				}
			}
		}
		return "";
	}
}