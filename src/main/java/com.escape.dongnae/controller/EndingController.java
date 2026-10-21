package com.escape.dongnae.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import java.sql.*;

import com.escape.dongnae.dao.ChatDAO;
import com.escape.dongnae.model.Chat;

// 엔딩 페이지를 설정하는 컨트롤러
@WebServlet("/ending")
public class EndingController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// 게임 성공 여부
		boolean successful = Boolean.parseBoolean(request.getParameter("successful"));
		
		// 엔딩 배경화면 설정
		String endingBackground;
		if (successful)
			endingBackground = "assets/images/backgrounds/successful_background.jpg";
		else
			endingBackground = "assets/images/backgrounds/failed_background.jpg";
		request.setAttribute("ending_background", endingBackground);
		
		// 엔딩 BGM 설정
		String endingBgmSource;
		if (successful)
			endingBgmSource = "assets/sounds/bgms/successful_bgm.mp3";
		else
			endingBgmSource = "assets/sounds/bgms/failed_bgm.mp3";
		request.setAttribute("ending_bgm_source", endingBgmSource);
			
		// 엔딩 메시지 설정
		String endingMessage;
		if (successful)
			endingMessage = "축하합니다!<br>미래 붕괴 도시 방탈출에 성공하였습니다!";
		else
			endingMessage = "미래 붕괴 도시 방탈출에 실패하였습니다.";
		request.setAttribute("ending_message", endingMessage);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("ending.jsp");
		requestDispatcher.forward(request, response);
	}
}