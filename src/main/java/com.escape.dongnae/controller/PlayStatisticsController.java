package com.escape.dongnae.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import java.sql.SQLException;
import java.util.Vector;
import java.util.HashMap;

import com.escape.dongnae.dao.PlayerInfoDAO;
import com.escape.dongnae.model.PlayerInfo;

interface PlayStatisticsControllerInterface {
	// 플레이 통계의 각 데이터를 반환하는 메소드
	public abstract HashMap<String, Object> getStatistics(Vector<PlayerInfo> totalPlayers);
}

// 플레이 통게 페이지를 구성하는 컨트롤러
@WebServlet("/play-statistics")
public class PlayStatisticsController extends HttpServlet implements PlayStatisticsControllerInterface {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// 전체 플레이어
		Vector<PlayerInfo> totalPlayers;
		try {
			totalPlayers = new PlayerInfoDAO().getRecentPlayerInfos();
		}
		catch (Exception e) {
			e.printStackTrace();
			totalPlayers = null;
		}
		
		// 플레이 통계의 각 데이터
		HashMap<String, Object> statistics = this.getStatistics(totalPlayers);
		
		// 전체 플레이어 수
		request.setAttribute("total_player_count", statistics.get("totalPlayerCount"));
		// 게임 성공 수
		request.setAttribute("successful_count", statistics.get("successfulCount"));
		// 게임 실패 수
		request.setAttribute("failed_count", statistics.get("failedCount"));
		// 성공률
		request.setAttribute("successful_rate", String.format("%.1f", statistics.get("successfulRate")));
		// 평균 이해도
		request.setAttribute("average_comprehension", String.format("%.1f", statistics.get("averageComprehension")));
		// 방별 해결 현황
		request.setAttribute("solved_room_counts", statistics.get("solvedRoomCounts"));
		// 오브젝트별 해결 현황
		request.setAttribute("solved_object_counts", statistics.get("solvedObjectCounts"));
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("play_statistics.jsp");
		requestDispatcher.forward(request, response);
	}
	
	// 플레이 통계의 각 데이터를 반환하는 메소드
	@Override
	public HashMap<String, Object> getStatistics(Vector<PlayerInfo> totalPlayers) {
		// 플레이 통계의 각 데이터
		HashMap<String, Object> statistics = new HashMap<>();
		// 전체 플레이어 수
		int totalPlayerCount = totalPlayers.size();
		// 게임 성공 수
		int successfulCount = 0;
		// 게임 실패 수
		int failedCount = 0;
		// 평균 이해도
		float averageComprehension = 0;
		// 방별 해결 현황
		int[] solvedRoomCounts = new int[4];
		for (byte i = 0; i < solvedRoomCounts.length; i++)
			solvedRoomCounts[i] = 0;
		// 오브젝트별 해결 현황
		int[][] solvedObjectCounts = new int[4][5];
		for (byte i = 0; i < solvedObjectCounts.length; i++) {
			for (byte j = 0; j < solvedObjectCounts[i].length; j++)
				solvedObjectCounts[i][j] = 0;
		}
		
		for (int i = 0; i < totalPlayers.size(); i++) {
			PlayerInfo playerInfo = totalPlayers.get(i);
			// 게임 성공 여부
			if (playerInfo.getSuccessful())
				successfulCount++;
			else
				failedCount++;
			// 이해도
			averageComprehension += playerInfo.getComprehension();
			// 방별 해결 현황
			boolean[] solvedRooms = playerInfo.getSolvedRooms();
			for (byte roomIndex = 0; roomIndex < solvedRooms.length; roomIndex++) {
				if (solvedRooms[roomIndex])
					solvedRoomCounts[roomIndex]++;
			}
			// 오브젝트별 해결 현황
			boolean[][] solvedObjects = playerInfo.getSolvedObjests();
			for (byte roomIndex = 0; roomIndex < solvedObjects.length; roomIndex++) {
				for (byte objectIndex = 0; objectIndex < solvedObjects[roomIndex].length; objectIndex++) {
					if (solvedObjects[roomIndex][objectIndex])
						solvedObjectCounts[roomIndex][objectIndex]++;
				}
			}
		}
		averageComprehension /= totalPlayers.size();
		// 성공률
		float successfulRate = ((float)successfulCount / totalPlayerCount) * 100;
		
		statistics.put("totalPlayerCount", totalPlayerCount);
		statistics.put("successfulCount", successfulCount);
		statistics.put("failedCount", failedCount);
		statistics.put("successfulRate", successfulRate);
		statistics.put("averageComprehension", averageComprehension);
		statistics.put("solvedRoomCounts", solvedRoomCounts);
		statistics.put("solvedObjectCounts", solvedObjectCounts);
		
		return statistics;
	}
}