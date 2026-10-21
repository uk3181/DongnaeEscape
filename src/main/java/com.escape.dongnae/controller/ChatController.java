package com.escape.dongnae.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import java.util.Vector;
import java.sql.*;

import com.escape.dongnae.model.PlayerInfo;
import com.escape.dongnae.model.Message;
import com.escape.dongnae.model.Chat;

interface ChatControllerInterface {
	// 각 사용자별 채팅 정보를 설정하는 메소드
	public abstract void setChatMessages(HttpServletRequest request, HttpSession session, Vector<Message> messages, short chatIndex);
	// request의 속성과 값들을 설정하는 메소드
	public abstract void setRequestAttributes(HttpServletRequest request, HttpSession session);
	// 채팅 페이지로 넘어가는 메소드
	public abstract void sendRedirectToChat(HttpServletResponse response, HttpSession session,
			byte roomNumber, byte objectNumber,
			Vector<String> attributeStrings, Vector<Object> attributeObjects,
			String nextUrl, Chat chat, boolean executeTimer)
			throws IOException;
}

// 진행요원(서연)과 주인공(플레이어) 간의 대화 내용을 설정하는 컨트롤러
@WebServlet("/chat")
public class ChatController extends HttpServlet implements ChatControllerInterface {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();

		PlayerInfo playerInfo = (PlayerInfo)session.getAttribute("player_info");
		Chat chat = (Chat)session.getAttribute("chat");
		short chatIndex = (short)session.getAttribute("chat_index"); // 어디까지 채팅 정보를 읽어왔는지 확인

		// 상태창 설정
		PlayerInfoController.printPlayerInfo(request, response, playerInfo, "problem_result.jsp");
		
		// 타이머 실행 여부 설정
		boolean executeTimer = Boolean.parseBoolean(request.getParameter("execute_timer"));
		if (executeTimer)
			request.setAttribute("timer_script_src", "js/timer.js");
		else
			request.setAttribute("timer_script_src", "");
		
		Vector<Message> messages = chat.getMessages();
		
		String url; // 이동할 url 설정
		if (chatIndex == messages.size()) { // 채팅 정보를 모두 읽어옴.
			// 각 사용자별 채팅 정보를 설정함.
			this.setRequestAttributes(request, session);

			url = (String)session.getAttribute("next_url");
		}
		else { // 안 읽어온 채팅 정보가 존재함.
			// 각 사용자별 채팅 정보를 설정함.
			this.setChatMessages(request, session, messages, chatIndex);

			chatIndex++;
			session.setAttribute("chat_index", chatIndex);
			
			request.setAttribute("execute_timer", executeTimer);
			
			url = "chat.jsp";
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
		requestDispatcher.forward(request, response);
	}
	
	// 각 사용자별 채팅 정보를 설정하는 메소드
	@Override
	public void setChatMessages(HttpServletRequest request,
			HttpSession session, Vector<Message> messages, short chatIndex) {
		Message message = messages.get(chatIndex);
		if (message.getUser() == Message.SYSTEM) {
			request.setAttribute("system_message", message.getMessage());
			request.setAttribute("staff_message", "");
			request.setAttribute("player_message", "");
		}
		else if (message.getUser() == Message.STAFF) {
			request.setAttribute("system_message", "");
			request.setAttribute("staff_message", message.getMessage());
			request.setAttribute("player_message", "");
		}
		else { // Message.PLAYER
			request.setAttribute("system_message", "");
			request.setAttribute("staff_message", "");
			request.setAttribute("player_message", message.getMessage());
		}
	}
	
	// request의 속성과 값들을 설정하는 메소드
	@Override
	public void setRequestAttributes(HttpServletRequest request, HttpSession session) {
		Vector<String> attributeStrings = (Vector<String>)session.getAttribute("attribute_strings");
		Vector<Object> attributeObjects = (Vector<Object>)session.getAttribute("attribute_objects");
		if (attributeStrings != null && attributeObjects != null) {
			for (short i = 0; i < attributeStrings.size(); i++) {
				String attributeString = attributeStrings.get(i);
				Object attributeObject = attributeObjects.get(i);
				request.setAttribute(attributeString, attributeObject);
			}
		}
	}

	// 채팅 페이지로 넘어가는 메소드
	@Override
	public void sendRedirectToChat(HttpServletResponse response, HttpSession session,
			byte roomNumber, byte objectNumber,
			Vector<String> attributeStrings, Vector<Object> attributeObjects,
			String nextUrl, Chat chat, boolean executeTimer)
			throws IOException {
		session.setAttribute("chat", chat);
		session.setAttribute("chat_index", (short)0);
		
		session.setAttribute("attribute_strings", attributeStrings);
		session.setAttribute("attribute_objects", attributeObjects);

		// 채팅 내용을 확인한 후, 다음 url로 넘어가는 것을 설정함.
		session.setAttribute("next_url", nextUrl);

		response.sendRedirect("chat?execute_timer=" + executeTimer);
	}
}