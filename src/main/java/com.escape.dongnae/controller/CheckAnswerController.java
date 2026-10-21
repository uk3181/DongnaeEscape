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

interface CheckAnswerControllerInterface {
	// 특정 방의 모든 오브젝트에 해당하는 문제를 풀었는지 확인하는 메소드
	public abstract boolean allObjectSolved(boolean[][] solvedObjects, byte roomNumber);
	// 플레이어의 코드를 수정하는 메소드
	public abstract void changeCode(PlayerInfo playerInfo, byte roomNumber);
	// 플레이어의 이해도를 증가하는 메소드
	public abstract void increaseComprehension(PlayerInfo playerInfo, boolean[][] solvedObjects);
	// 플레이어의 남은 시간을 30초 감소하는 메소드
	public abstract void decrease30LeftSeconds(HttpServletResponse response, PlayerInfo playerInfo) throws IOException;
	// 각 사용자별 대화 내용을 반환하는 메소드
	public abstract Chat getChat(byte roomNumber) throws Exception;
}

// 플레이어가 선택한 보기가 정답인지 확인하는 컨트롤러
@WebServlet("/check-answer")
public class CheckAnswerController extends HttpServlet implements CheckAnswerControllerInterface {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();

		PlayerInfo playerInfo = (PlayerInfo)session.getAttribute("player_info");
		
		byte roomNumber = Byte.parseByte(request.getParameter("room"));
		byte objectNumber = Byte.parseByte(request.getParameter("object"));

		// 사용자가 선택한 보기
		byte choiceNumber = (byte)(request.getParameter("choice").charAt(0) - '0');
		
		// 정답 보기 번호
		byte answer = (byte)(session.getAttribute("answer"));
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String problemResultMessage; // 정답 여부에 따라 메시지 설정
		String action = ""; // 정답 여부를 확인한 후, 다른 오브젝트의 문제를 풀 것인지, 아니면 다른 방으로 이동할 것인지 결정
		if (choiceNumber == answer) { // 정답
			problemResultMessage = "정답입니다.";

			boolean[][] solvedObjects = playerInfo.getSolvedObjests();

			// 각 방과 오브젝트에 해당하는 문제 풀이를 정답으로 처리함.
			solvedObjects[roomNumber - 1][objectNumber - 1] = true;
			playerInfo.setSolvedObjects(solvedObjects);
			
			// 이해도 증가
			this.increaseComprehension(playerInfo, solvedObjects);
			// 아이템 수정
			String item = (String)session.getAttribute("item");
			playerInfo.setItem(item);
			
			if (this.allObjectSolved(solvedObjects, roomNumber)) { // 모든 오브젝트 해결 완료
				// 플레이어의 코드 수정
				this.changeCode(playerInfo, roomNumber);
				
				// DB에서 플레이어 데이터 업데이트
				try {
					new PlayerInfoDAO().updatePlayerInfo(playerInfo);
				}
				catch (Exception e) {
					e.printStackTrace();
				}

				// 넘어갈 다음 url
				String nextUrl;
				if (roomNumber == 4) { // 게임의 모든 문제를 해결하였음.
					// 최종 정답 입력 페이지로 넘어가야 함.
					nextUrl = "input-answer";
				}
				else { // 다음 방으로 넘어감.
					boolean[] solvedRooms = playerInfo.getSolvedRooms();
					solvedRooms[roomNumber - 1] = true;
					playerInfo.setSolvedRooms(solvedRooms);
					nextUrl = "select-room";
				}
				
				// 채팅 정보를 불러옴.
				Chat chat;
				try {
					chat = this.getChat(roomNumber);
				}
				catch (Exception e) {
					e.printStackTrace();
					chat = null;
				}
				
				// 채팅 페이지로 넘어감.
				new ChatController().sendRedirectToChat(response, session, roomNumber, (byte)0,
						null, null, nextUrl, chat, true);
				return;
			}
			else { // 아직 모든 오브젝트를 해결하지 못함.
				// DB에서 플레이어 데이터 업데이트
				try {
					new PlayerInfoDAO().updatePlayerInfo(playerInfo);
				}
				catch (Exception e) {
					e.printStackTrace();
				}

				action = "enter-room?room=" + roomNumber + "&show-chat=false";
			}

			session.setAttribute("player_info", playerInfo);
		}
		else { // 오답
			problemResultMessage = "오답입니다.<br>[Error: 30초 감소]";
			
			// 플레이어가 오답을 선택하면 남은 시간을 30초 감소시킴.
			this.decrease30LeftSeconds(response, playerInfo);
			session.setAttribute("player_info", playerInfo);
			
			action = "enter-room?room=" + roomNumber + "&show-chat=false";
		}

		request.setAttribute("problem_result_message", problemResultMessage);
		
		request.setAttribute("room_number", roomNumber);
		request.setAttribute("action", action);

		// 상태창 설정
		PlayerInfoController.printPlayerInfo(request, response, playerInfo, "problem_result.jsp");
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("problem_result.jsp");
		requestDispatcher.forward(request, response);
	}
	
	// 특정 방의 모든 오브젝트에 해당하는 문제를 풀었는지 확인하는 메소드
	@Override
	public boolean allObjectSolved(boolean[][] solvedObjects, byte roomNumber) {
		boolean result = true;
		for (byte i = 0; i < solvedObjects[roomNumber - 1].length; i++) {
			if (!solvedObjects[roomNumber - 1][i])
				return false;
		}
		return result;
	}
	
	// 플레이어의 코드를 수정하는 메소드
	@Override
	public void changeCode(PlayerInfo playerInfo, byte roomNumber) {
		String code = playerInfo.getCode();
		switch (roomNumber) {
			case 1:
				code = "자";
				break;
			case 2:
				code += "원";
				break;
			case 3:
				code += "봉";
				break;
			case 4:
				code += "사";
				break;
		}
		playerInfo.setCode(code);
	}
	
	// 플레이어의 이해도를 증가하는 메소드
	@Override
	public void increaseComprehension(PlayerInfo playerInfo, boolean[][] solvedObjects) {
		byte comprehension = (byte)playerInfo.getComprehension();
		byte roomCount = (byte)solvedObjects.length;
		byte objectCount = (byte)solvedObjects[0].length;
		comprehension += (byte)(100 / (roomCount * objectCount));
		playerInfo.setComprehension(comprehension);
	}
	
	// 플레이어의 남은 시간을 30초 감소하는 메소드
	@Override
	public void decrease30LeftSeconds(HttpServletResponse response, PlayerInfo playerInfo)
			throws IOException {
		short leftSeconds = playerInfo.getLeftSeconds();
		leftSeconds -= 30;
		if (leftSeconds <= 0) // 남은 시간이 0초 미만일 수는 없음.
			leftSeconds = 1;
		playerInfo.setLeftSeconds(leftSeconds);
	}

	// 각 사용자별 대화 내용을 반환하는 메소드
	@Override
	public Chat getChat(byte roomNumber)
			throws Exception {
		Chat chat = new ChatDAO().getChat((byte)5, roomNumber);
		return chat;
	}
}