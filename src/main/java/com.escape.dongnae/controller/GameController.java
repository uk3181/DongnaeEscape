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

interface GameControllerInterface {
	// 각 사용자별 대화 내용을 반환하는 메소드
	public abstract Chat getChat() throws Exception;
	// 각 방의 각 오브젝트를 한 번이라도 클릭한 적이 있는지 확인하는 데이터를 반환함.
	public abstract boolean[][] getClickedObjects();
}

// 게임 시작과 동시에 4개의 방이 있는 공간으로 이동함.
@WebServlet("/start-game")
public class GameController extends HttpServlet implements GameControllerInterface {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession(); // 세션을 통해 플레이어의 정보를 저장함.
		session.setMaxInactiveInterval(60 * 60); // 최대 세션 유지 시간: 1시간
		
		String id = request.getParameter("id");
		PlayerInfo playerInfo = new PlayerInfo(id, "조사요원");
		try {
			new PlayerInfoDAO().createPlayerInfo(playerInfo);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		session.setAttribute("player_info", playerInfo);
		
		// 각 오브젝트의 설명의 조회 여부를 확인할 수 있는 데이터
		boolean[][] checkedObjectInfos = new boolean[4][5];
		for (byte i = 0; i < checkedObjectInfos.length; i++) {
			for (byte j = 0; j < checkedObjectInfos[i].length; j++)
				checkedObjectInfos[i][j] = false;
		}
		session.setAttribute("checkedObjectInfos", checkedObjectInfos);
		
		// 채팅 정보를 불러옴.
		Chat chat;
		try {
			chat = this.getChat();
		}
		catch (Exception e) {
			e.printStackTrace();
			chat = null;
		}
		
		// 넘어갈 다음 url
		String nextUrl = "select-room";
		
		// 채팅 페이지로 넘어감.
		try {
			new ChatController().sendRedirectToChat(response, session, (byte)0, (byte)0,
					null, null, nextUrl, chat, false);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 각 사용자별 대화 내용을 반환하는 메소드
	@Override
	public Chat getChat() throws Exception {
		Chat chat = new ChatDAO().getChat((byte)0);
		return chat;
	}
	
	// 각 방의 각 오브젝트를 한 번이라도 클릭한 적이 있는지 확인하는 데이터를 반환함.
	@Override
	public boolean[][] getClickedObjects() {
		boolean[][] clickedObjects = new boolean[4][5];
		for (byte i = 0; i < clickedObjects.length; i++) {
			for (byte j = 0; j < clickedObjects[i].length; j++)
				clickedObjects[i][j] = false;
		}
		return clickedObjects;
	}
}