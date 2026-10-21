// 상태창을 설정해주는 컨트롤러
// 1. 이름
// 2. 이해도
// 3. 남은 시간 (분, 초)
// 4. 키워드
// 5. 아이템
// 6. 코드

package com.escape.dongnae.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

import com.escape.dongnae.model.PlayerInfo;

public class PlayerInfoController {
	// 상태창(플레이어의 정보)을 설정하는 메소드
	public static void printPlayerInfo(HttpServletRequest request,
			HttpServletResponse response, PlayerInfo playerInfo, String path)
			throws ServletException {
		request.setAttribute("name", playerInfo.getName());
		request.setAttribute("comprehension", playerInfo.getComprehension());
		request.setAttribute("leftMinutes", getStringLeftMinutes(playerInfo.getLeftSeconds()));
		request.setAttribute("leftSeconds", getStringLeftSeconds(playerInfo.getLeftSeconds()));
		request.setAttribute("item", playerInfo.getItem());
		request.setAttribute("code", playerInfo.getCode());
	}
	
	// 남은 시간의 분을 문자열로 반환해주는 메소드
	public static String getStringLeftMinutes(short leftSeconds) {
		String stringLeftMinutes = Short.toString((short)(leftSeconds / 60));
		if (stringLeftMinutes.length() == 1) // 길이가 1이면 앞에 0을 붙임.
			stringLeftMinutes = "0" + stringLeftMinutes;
		return stringLeftMinutes;
	}
	
	// 남은 시간의 초를 문자열로 반환해주는 메소드
	public static String getStringLeftSeconds(short leftSeconds) {
		String stringLeftSeconds = Short.toString((short)(leftSeconds % 60));
		if (stringLeftSeconds.length() == 1) // 길이가 1이면 앞에 0을 붙임.
			stringLeftSeconds = "0" + stringLeftSeconds;
		return stringLeftSeconds;
	}
}