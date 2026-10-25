package com.escape.dongnae.model;

interface MessageInterface {
	/* -------------------- Setter/Getter -------------------- */
	public abstract byte getUser();
	public abstract String getMessage();
	/* ------------------------------------------------------- */
}

// 메시지 데이터를 관리하는 모델
public class Message implements MessageInterface {
	// 사용자 구분 - 시스템, 진행요원, 주인공
	public static byte SYSTEM = 0, STAFF = 1, PLAYER = 2;
	
	private byte user; // 사용자
	private String message; // 메시지
	
	public Message(byte user, String message) {
		this.user = user;
		this.message = message;
	}

	/* -------------------- Setter/Getter -------------------- */
	public byte getUser() {
		return this.user;
	}
	
	public String getMessage() {
		return this.message;
	}
	/* ------------------------------------------------------- */
}
