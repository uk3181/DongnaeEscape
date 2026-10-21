package com.escape.dongnae.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;

import com.escape.dongnae.model.PlayerInfo;

// 최종 정답을 입력할 수 있도록 구성하는 컨트롤러
@WebServlet("/input-answer")
public class InputAnswerController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();

		PlayerInfo playerInfo = (PlayerInfo)session.getAttribute("player_info");

		// 상태창 설정
		PlayerInfoController.printPlayerInfo(request, response, playerInfo, "input_answer.jsp");
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("input_answer.jsp");
		requestDispatcher.forward(request, response);
	}
}