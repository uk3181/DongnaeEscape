package com.escape.dongnae.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;

import com.escape.dongnae.model.PlayerInfo;

interface SelectRoomControllerInterface {
	// 플레이어가 3번째 방까지 클리어를 완료했는지 확인하는 메소드
	public abstract boolean cleared3Rooms(PlayerInfo playerInfo);
}

// 플레이어로부터 각 방을 해결했는지 여부를 알아내어, 문의 상태를 정하는 컨트롤러
@WebServlet("/select-room")
public class SelectRoomController extends HttpServlet implements SelectRoomControllerInterface {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		
		PlayerInfo playerInfo = (PlayerInfo)session.getAttribute("player_info");
		
		// 상태창 설정
		PlayerInfoController.printPlayerInfo(request, response, playerInfo, "select_room.jsp");

		String[] doorImageSources = new String[4]; // 각 방들의 문의 이미지를 지정함.
		boolean[] solvedRooms = playerInfo.getSolvedRooms();
		for (byte i = 0; i < solvedRooms.length; i++) {
			String doorImageSource;
			if (solvedRooms[i]) // 방탈출에 성공한 방
				doorImageSource = "assets/images/backgrounds/cleared_door_background.jpg";
			else { // 방탈출에 성공하지 않은 방
				if (i == 0 || i >= 1 && solvedRooms[i - 1]) // 입장해야 하는 방
					doorImageSource = "assets/images/backgrounds/enter_door_background.jpg";
				else // 입장할 수 없는 방
					doorImageSource = "assets/images/backgrounds/closed_door_background.jpg";
			}
			
			doorImageSources[i] = doorImageSource;
		}
		request.setAttribute("door_image_sources", doorImageSources);
		
		// 4번째 방의 경우, 3번째 방을 클리어할 때까지는 "자원봉사센터"라는 사실을 숨김.
		if (this.cleared3Rooms(playerInfo))
			request.setAttribute("room4_name", "자원봉사센터");
		else
			request.setAttribute("room4_name", "UNKNOWN");
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("select_room.jsp");
		requestDispatcher.forward(request, response);
	}
	
	// 플레이어가 3번째 방까지 클리어를 완료했는지 확인하는 메소드
	@Override
	public boolean cleared3Rooms(PlayerInfo playerInfo) {
		// 각 방의 클리어 여부
		boolean[] solvedRooms = playerInfo.getSolvedRooms();
		for (byte i = 0; i < 3; i++) {
			if (!solvedRooms[i])
				return false;
		}
		return true;
	}
}
