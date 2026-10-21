<!-- 주인공과 진행요원 간의 대화 내용을 보여주는 페이지 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="css/chat.css">
	</head>
	<body>
		<!-- 배경화면 -->
		<img class="background-image"
				src="assets/images/backgrounds/chat_background.jpg">

		<!-- 상태창 -->
		<div class="player-info-box">
			<label>플레이어 정보</label>
			<ul>
				<li>이름: ${name}</li>
				<li>이해도: ${comprehension}%</li>
				<li class="left-time">남은 시간: ${leftMinutes}:${leftSeconds}</li>
				<li>아이템: ${item}</li>
				<li>코드: ${code}</li>
			</ul>
		</div>

		<!-- 시스템 프레임 -->
		<div class="system-frame">
			<label class="system-label">시스템</label><br>

			<!-- 시스템 이미지 -->
			<img class="system-image"
					src="assets/images/backgrounds/system_background.jpg">
					
			<!-- 시스템 메시지 -->
			<label class="system-message" data-message="${system_message}"></label>
		</div>

		<!-- 진행요원 프레임 -->
		<div class="staff-frame">
			<label class="staff-label">서연</label><br>

			<!-- 진행요원 이미지 -->
			<img class="staff-image"
					src="assets/images/backgrounds/staff_background.jpg">
					
			<!-- 진행요원 메시지 -->
			<label class="staff-message" data-message="${staff_message}"></label>
		</div>
		
		<!-- 주인공(플레이어) 프레임 -->
		<div class="player-frame">
			<label class="player-label">${name}</label><br>

			<!-- 주인공(플레이어) 이미지 -->
			<img class="player-image"
					src="assets/images/backgrounds/player_background.jpg">
					
			<!-- 주인공(플레이어) 메시지 -->
			<label class="player-message" data-message="${player_message}"></label>
		</div>
		
		<!-- 다음으로 넘어가는 버튼 -->
		<form action="chat?execute_timer=${execute_timer}" method="post">
			<input id="button" type="submit" value="다음">
		</form>

		<!-- 음원 재생 버튼 -->
		<input class="sound-button" id="assets/sounds/bgms/chat_theme_bgm.mp3" type="image">
		
		<!-- 타이머 실행 (상황에 따라 실행 여부가 결정됨.) -->
		<script src="${timer_script_src}"></script>

		<!-- Sound 버튼 연결 -->
		<script src="js/sound_button.js"></script>
		<!-- BGM Audio 연결 -->
		<script src="js/bgm_audio.js"></script>

		<!-- SFX Manager 연결 -->
		<script src="js/sfx_manager.js"></script>
		
		<!-- Chat 페이지 관리자 연결 -->
		<script src="js/chat.js"></script>
	</body>
</html>