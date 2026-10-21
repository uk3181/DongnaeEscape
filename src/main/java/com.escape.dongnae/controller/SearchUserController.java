package com.escape.dongnae.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import java.util.Vector;
import java.sql.SQLException;

import com.escape.dongnae.dao.PlayerInfoDAO;
import com.escape.dongnae.model.PlayerInfo;

// 사용자 조회 페이지 구성 컨트롤러
@WebServlet("/search-user")
public class SearchUserController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// 검색된 사용자 목록
		Vector<PlayerInfo> searchedPlayers;

		// 검색하려는 id
		String id = request.getParameter("id");
		if (id == null) { // 검색된 id로 등록된 사용자 부재
			searchedPlayers = null;
			
			request.setAttribute("id", "-");
			request.setAttribute("start_time", "-");
			request.setAttribute("end_time", "-");
			request.setAttribute("successful", false);
			request.setAttribute("last_solved_room_number", 0);
			request.setAttribute("last_solved_object_number", 0);
			request.setAttribute("comprehension", 0);
			request.setAttribute("code", "-");
		}
		else { // 검색된 id로 등록된 사용 사용자 존재
			try {
				searchedPlayers = new PlayerInfoDAO().searchPlayerInfoById(id);
			}
			catch (Exception e) {
				e.printStackTrace();
				searchedPlayers = null;
			}
				
			// 동일 사용자의 가장 최근 접속 시간 기준 게임 진행 관련 각 데이터
			request.setAttribute("id",
					searchedPlayers.isEmpty() ? "-" : searchedPlayers.get(0).getId());
			request.setAttribute("start_time",
					searchedPlayers.isEmpty() ? "-" : searchedPlayers.get(0).getStartTime());
			request.setAttribute("end_time",
					searchedPlayers.isEmpty() ? "-" : searchedPlayers.get(0).getEndTime());
			request.setAttribute("successful",
					searchedPlayers.isEmpty() ? "-" : searchedPlayers.get(0).getSuccessful());
			request.setAttribute("comprehension",
					searchedPlayers.isEmpty() ? 0 : searchedPlayers.get(0).getComprehension());
			Vector<Byte> lastSolvedRoomAndObjectNumber;
			if (!searchedPlayers.isEmpty()) {
				lastSolvedRoomAndObjectNumber
						= new PlayerInfoDAO().getLastSolvedRoomAndObjectNumber(searchedPlayers.get(0));
			}
			else
				lastSolvedRoomAndObjectNumber = null;
			request.setAttribute("last_solved_room_number",
					searchedPlayers.isEmpty() ? 0 : lastSolvedRoomAndObjectNumber.get(0));
			request.setAttribute("last_solved_object_number",
					searchedPlayers.isEmpty() ? 0 : lastSolvedRoomAndObjectNumber.get(1));
			request.setAttribute("code",
					searchedPlayers.isEmpty() ? "-" : searchedPlayers.get(0).getCode());
		}
		request.setAttribute("searched_players", searchedPlayers);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("user.jsp");
		requestDispatcher.forward(request, response);
	}
}