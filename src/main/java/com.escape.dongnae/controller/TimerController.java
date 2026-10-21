package com.escape.dongnae.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;

import com.escape.dongnae.model.PlayerInfo;

// 타이머의 남은 시간을 세션의 플레이어의 정보에 저장하는 컨트롤러
@WebServlet("/save-timer")
public class TimerController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		
		PlayerInfo playerInfo = (PlayerInfo)session.getAttribute("player_info");
		short leftSeconds = Short.parseShort(request.getParameter("left_seconds"));
		
		// 플레이어의 남은 시간 재설정
		playerInfo.setLeftSeconds(leftSeconds);
		session.setAttribute("player_info", playerInfo);
	}
}