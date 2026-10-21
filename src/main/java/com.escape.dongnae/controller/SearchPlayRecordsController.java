package com.escape.dongnae.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import java.sql.SQLException;
import java.util.Vector;

import com.escape.dongnae.dao.PlayerInfoDAO;
import com.escape.dongnae.model.PlayerInfo;

// 플레이 기록을 검색하는 컨트롤러
@WebServlet("/search-play-records")
public class SearchPlayRecordsController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String id = request.getParameter("id");
		// 게임 성공 여부 상태
		String state = request.getParameter("state");
		if (state == null)
			state = "전체";
		request.setAttribute("state", state);
		
		// 최근 50명의 플레이 기록 목록
		Vector<PlayerInfo> recentPlayRecords = null;
		try {
			switch (state) {
				case "전체":
					if (id == null || id.equals(""))
						recentPlayRecords = new PlayerInfoDAO().getRecentPlayerInfos(50);
					else
						recentPlayRecords = new PlayerInfoDAO().getRecentPlayerInfos(50, id);
					break;
				case "성공":
					if (id == null || id.equals(""))
						recentPlayRecords
								= new PlayerInfoDAO().getRecentPlayerInfos(Integer.valueOf(50), Boolean.valueOf(true));
					else
						recentPlayRecords
								= new PlayerInfoDAO().getRecentPlayerInfos(Integer.valueOf(50), Boolean.valueOf(true), id);
					break;
				case "실패":
					if (id == null || id.equals(""))
						recentPlayRecords
								= new PlayerInfoDAO().getRecentPlayerInfos(Integer.valueOf(50), Boolean.valueOf(false));
					else
						recentPlayRecords
								= new PlayerInfoDAO().getRecentPlayerInfos(Integer.valueOf(50), Boolean.valueOf(false), id);
					break;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			recentPlayRecords = null;
		}
		
		request.setAttribute("recent_play_records", recentPlayRecords);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("play_records.jsp");
		requestDispatcher.forward(request, response);
	}
}