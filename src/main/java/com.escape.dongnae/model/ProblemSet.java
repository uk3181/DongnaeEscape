package com.escape.dongnae.model;

import java.util.Vector;

interface ProblemSetInterface {
	/* -------------------- Setter/Getter -------------------- */
	public abstract String getQuestion();
	public abstract Vector<String> getChoices();
	public abstract byte getAnswer();
	public abstract String getItem();
	/* ------------------------------------------------------- */
}

// 문제 데이터를 관리하는 모델
public class ProblemSet implements ProblemSetInterface {
	private String question; // 문제
	private Vector<String> choices; // 보기 목록
	private byte answer; // 정답
	private String item; // 아이템
	
	public ProblemSet(String question, Vector<String> choices, byte answer, String item) {
		this.question = question;
		this.choices = choices;
		this.answer = answer;
		this.item = item;
	}
	
	/* -------------------- Setter/Getter -------------------- */
	public String getQuestion() {
		return this.question;
	}
	
	public Vector<String> getChoices() {
		return this.choices;
	}
	
	public byte getAnswer() {
		return this.answer;
	}
	
	public String getItem() {
		return this.item;
	}
	/* ------------------------------------------------------- */
}
