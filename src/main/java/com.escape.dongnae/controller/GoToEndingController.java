package com.escape.dongnae.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import java.sql.*;

import com.escape.dongnae.dao.PlayerInfoDAO;
import com.escape.dongnae.dao.ChatDAO;
import com.escape.dongnae.model.PlayerInfo;
import com.escape.dongnae.model.Chat;

interface GoToEndingControllerInterface {
	// 각 사용자별 대화 내용을 반환하는 메소드
	public abstract Chat getChat(byte chatType) throws Exception;
}

// 채팅 페이지, 엔딩 페이지로 순차적으로 이동하는 컨트롤러
@WebServlet("/goto-ending")
public class GoToEndingController extends HttpServlet implements GoToEndingControllerInterface {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();

		// 게임의 성공 여부
		boolean successful = Boolean.parseBoolean(request.getParameter("successful"));

		// 채팅 정보를 불러옴.
		Chat chat;
		String nextUrl;
		try {
			PlayerInfo playerInfo = (PlayerInfo)session.getAttribute("player_info");
			if (successful) {
				playerInfo.setSuccessful(successful);
	
				chat = this.getChat((byte)6);
				nextUrl = "ending?successful=true";
			}
			else {
				chat = this.getChat((byte)7);
				nextUrl = "ending?successful=false";
			}

			// DB에서 플레이어 데이터 업데이트
			new PlayerInfoDAO().updatePlayerInfo(playerInfo, true);
			session.setAttribute("player_info", playerInfo);

			// 채팅 페이지로 넘어감.
			new ChatController().sendRedirectToChat(response, session, (byte)0, (byte)0,
					null, null, nextUrl, chat, false);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 각 사용자별 대화 내용을 반환하는 메소드
	@Override
	public Chat getChat(byte chatType)
			throws Exception {
		Chat chat = new ChatDAO().getChat(chatType);
		return chat;
	}
}