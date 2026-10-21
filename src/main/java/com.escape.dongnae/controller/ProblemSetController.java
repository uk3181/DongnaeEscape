package com.escape.dongnae.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import java.sql.*;
import java.util.Vector;

import com.escape.dongnae.dao.ChatDAO;
import com.escape.dongnae.dao.ProblemSetDAO;
import com.escape.dongnae.model.ProblemSet;
import com.escape.dongnae.model.PlayerInfo;
import com.escape.dongnae.model.Chat;

interface ProblemSetControllerInterface {
	// 오브젝트의 문제가 풀 수 있는 문제인지 확인하는 메소드
	public abstract boolean solvableObject(boolean[][] solvedObjects, byte roomNumber, byte objectNumber);
	// 문제, 보기 목록, 보기의 개수, 정답, 아이템을 설정하는 메소드
	public abstract void setProblemSetInformations(HttpServletRequest request, HttpSession session, byte roomNumber, byte objectNumber) throws Exception;
}

// 문제 구성을 설정하는 컨트롤러
@WebServlet("/solve-problem")
public class ProblemSetController extends HttpServlet implements ProblemSetControllerInterface {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		
		PlayerInfo playerInfo = (PlayerInfo)session.getAttribute("player_info");

		// 상태창 설정
		PlayerInfoController.printPlayerInfo(request, response, playerInfo, "problem_set.jsp");

		byte roomNumber = Byte.parseByte(request.getParameter("room")); // 방 번호
		byte objectNumber = Byte.parseByte(request.getParameter("object")); // 오브젝트 번호

		// 각 오브젝트의 문제 해결 여부를 확인할 수 있는 데이터
		boolean[][] solvedObjects = playerInfo.getSolvedObjests();
		// 각 오브젝트의 설명의 조회 여부를 확인할 수 있는 데이터
		boolean[][] checkedObjectInfos = (boolean[][])session.getAttribute("checkedObjectInfos");
		
		// 현재 풀어야 할 문제임.
		if (this.solvableObject(solvedObjects, roomNumber, objectNumber)) {
			if (solvedObjects[roomNumber - 1][objectNumber - 1]) // 문제 풀이에 성공함.
				response.sendRedirect("enter-room?room=" + roomNumber);
			else { // 문제 풀이에 성공한 적이 없음.
				// 오브젝트의 설명을 조회함.
				if (checkedObjectInfos[roomNumber - 1][objectNumber - 1]) {
					// 문제 데이터를 가져옴.
					ProblemSet problemSet;
					try {
						problemSet = new ProblemSetDAO().getProblemSet(roomNumber, objectNumber);
						this.setProblemSetInformations(request, session, roomNumber, objectNumber);
					}
					catch (Exception e) {
						e.printStackTrace();
						problemSet = null;
					}
						
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("problem_set.jsp");
					requestDispatcher.forward(request, response);
				}
				else // 오브젝트의 설명을 조회하지 않음.
					response.sendRedirect("enter-room?room=" + roomNumber);
			}
		}
		else // 현재 풀어야 할 문제가 아님.
			response.sendRedirect("enter-room?room=" + roomNumber);
	}
	
	// 오브젝트의 문제가 풀 수 있는 문제인지 확인하는 메소드
	@Override
	public boolean solvableObject(boolean[][] solvedObjects, byte roomNumber, byte objectNumber) {
		for (byte i = 0; i < solvedObjects.length; i++) {
			for (byte j = 0; j < solvedObjects[i].length; j++) {
				if (!solvedObjects[i][j])
					return i == (roomNumber - 1) && j == (objectNumber - 1);
			}
		}
		return false;
	}

	// 문제, 보기 목록, 보기의 개수, 정답, 아이템을 설정하는 메소드
	@Override
	public void setProblemSetInformations(HttpServletRequest request, HttpSession session, byte roomNumber, byte objectNumber)
			throws Exception {
			// 방 번호
			request.setAttribute("room_number", roomNumber);
			// 오브젝트 번호
			request.setAttribute("object_number", objectNumber);
			// 문제 데이터를 가져옴.
			ProblemSet problemSet = new ProblemSetDAO().getProblemSet(roomNumber, objectNumber);
			// 문제
			request.setAttribute("question", problemSet.getQuestion());
			// 보기 목록
			request.setAttribute("choices", problemSet.getChoices());
			// 보기의 개수
			request.setAttribute("choice_count", problemSet.getChoices().size());
			// 정답
			session.setAttribute("answer", problemSet.getAnswer());
			// 아이템
			session.setAttribute("item", problemSet.getItem());
	}
}