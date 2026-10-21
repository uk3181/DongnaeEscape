package com.escape.dongnae.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;

import com.escape.dongnae.dao.ChatDAO;
import com.escape.dongnae.model.Chat;

interface ShowInfoControllerInterface {
	// 각 사용자별 대화 내용을 반환하는 메소드
	public abstract Chat getChat(byte roomNumber, byte solveObjectNumber) throws Exception;
}

// 어떤 오브젝트를 클릭해야 하는지 알려주는 컨트롤러
@WebServlet("/show-info")
public class ShowInfoController extends HttpServlet implements ShowInfoControllerInterface {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();

		byte roomNumber = Byte.parseByte(request.getParameter("room"));
		byte solveObjectNumber = Byte.parseByte(request.getParameter("object"));
		
		// 각 오브젝트의 설명의 조회 여부를 확인할 수 있는 데이터
		boolean[][] checkedObjectInfos = (boolean[][])session.getAttribute("checkedObjectInfos");
		checkedObjectInfos[roomNumber - 1][solveObjectNumber - 1] = true;
		session.setAttribute("checkedObjectInfos", checkedObjectInfos);
		
		try {
			// 채팅 정보를 불러옴.
			Chat chat = this.getChat(roomNumber, solveObjectNumber);
		
			// 넘어갈 다음 url
			String nextUrl = "enter-room?room=" + roomNumber;

			// 채팅 페이지로 넘어감.
			new ChatController().sendRedirectToChat(response, session, roomNumber, solveObjectNumber,
					null, null, nextUrl, chat, true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 각 사용자별 대화 내용을 반환하는 메소드
	@Override
	public Chat getChat(byte roomNumber, byte solveObjectNumber)
			throws Exception {
		Chat chat = new ChatDAO().getChat((byte)3, roomNumber, solveObjectNumber);
		return chat;
	}
}