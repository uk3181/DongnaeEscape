package com.escape.dongnae.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import java.sql.SQLException;
import java.util.Vector;

import com.escape.dongnae.dao.PlayerInfoDAO;
import com.escape.dongnae.model.PlayerInfo;

// 대시보드 구성 컨트롤러
@WebServlet("/dashboard")
public class DashboardController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// 전체 사용자 수
		int totalUserCount;
		// 게임 성공 사용자 수
		int successfulCount;
		// 게임 실패 사용자 수
		int failedCount;
		try {
			totalUserCount = new PlayerInfoDAO().getRecentPlayerInfos().size();
			successfulCount = new PlayerInfoDAO().getRecentPlayerInfos(true).size();
			failedCount = totalUserCount - successfulCount;
		}
		catch (Exception e) {
			e.printStackTrace();
			totalUserCount = 0;
			successfulCount = 0;
			failedCount = 0;
		}
		request.setAttribute("total_user_count", totalUserCount);
		request.setAttribute("successful_count", successfulCount);
		request.setAttribute("failed_count", failedCount);

		// 최근 접속 사용자 목록
		Vector<PlayerInfo> recentUsers;
		try {
			recentUsers = new PlayerInfoDAO().getRecentPlayerInfos(10);
		}
		catch (Exception e) {
			e.printStackTrace();
			recentUsers = null;
		}
		request.setAttribute("recent_users", recentUsers);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("dashboard.jsp");
		requestDispatcher.forward(request, response);
	}
}