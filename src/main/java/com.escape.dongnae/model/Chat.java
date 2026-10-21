package com.escape.dongnae.model;

import java.util.Vector;

interface ChatInterface {
	// 사용자별 대화 내용을 추가하는 메소드
	public abstract void addMessage(Byte user, String message);
}

// 각 사용자 간의 대화 내용을 관리하는 모델
public class Chat implements ChatInterface {
	private Vector<Message> messages; // 대화 내용 목록
	
	public Chat() {
		this.messages = new Vector<>();
	}
	
	/* -------------------- Setter/Getter -------------------- */
	public Vector<Message> getMessages() {
		return this.messages;
	}
	/* ------------------------------------------------------- */
	
	// 사용자별 대화 내용을 추가하는 메소드
	@Override
	public void addMessage(Byte user, String message) {
		Message addedMessage = new Message(user, message);
		this.messages.add(addedMessage);
	}
}