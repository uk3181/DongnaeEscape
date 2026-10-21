package com.escape.dongnae.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import java.sql.*;
import java.util.Vector;

import com.escape.dongnae.dao.ChatDAO;
import com.escape.dongnae.model.PlayerInfo;
import com.escape.dongnae.model.Chat;

interface CheckInputAnswerControllerInterface {
	// 플레이어의 남은 시간을 30초 감소하는 메소드
	public abstract void decrease30LeftSeconds(HttpServletResponse resposne, PlayerInfo playerInfo)
			throws IOException;
}

// 입력된 최종 정답을 확인하는 컨트롤러
@WebServlet("/check-input-answer")
public class CheckInputAnswerController extends HttpServlet implements CheckInputAnswerControllerInterface {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();

		// 사용자가 입력한 정답
		String answer = request.getParameter("answer");

		if (answer.equals("자원봉사")) // 플레이어가 정답 입력
			response.sendRedirect("goto-ending?successful=true");
		else { // 플레이어가 오답 입력
			// 플레이어 정보를 가져옴.
			PlayerInfo playerInfo = (PlayerInfo)session.getAttribute("player_info");
			// 플레이어의 남은 시간을 30초 감소함.
			this.decrease30LeftSeconds(response, playerInfo);
			// 플레이어의 정보를 세션에 저장
			session.setAttribute("player_info", playerInfo);
			
			// 상태창 설정
			PlayerInfoController.printPlayerInfo(request, response, playerInfo, "problem_result.jsp");
			
			request.setAttribute("room_number", (byte)4);
			request.setAttribute("problem_result_message", "오답입니다.<br>[Error: 30초 감소]");
			request.setAttribute("action", "input-answer");
			request.setAttribute("bgm_id", session.getAttribute("bgm_id"));
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("problem_result.jsp");
			requestDispatcher.forward(request, response);
		}
	}

	// 플레이어의 남은 시간을 30초 감소하는 메소드
	@Override
	public void decrease30LeftSeconds(HttpServletResponse response, PlayerInfo playerInfo)
			throws IOException {
		short leftSeconds = playerInfo.getLeftSeconds();
		leftSeconds -= 30;
		if (leftSeconds < 0) // 남은 시간이 0초 미만일 수는 없음.
			leftSeconds = 1;
		playerInfo.setLeftSeconds(leftSeconds);
	}
}