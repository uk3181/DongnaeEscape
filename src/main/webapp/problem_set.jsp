<!-- 문제를 푸는 페이지 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="css/problem_set.css">
	</head>
	<body>
		<!-- 배경화면 -->
		<img class="background-image"
				src="assets/images/backgrounds/problem_set_background.jpg">

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
		
		<!-- 문제 -->
		<label class="question">Q) ${question}</label><br>
		
		<!-- 보기 -->
		<form action="check-answer?room=${room_number}&object=${object_number}" method="post">
			<input id="answer-button" type="submit" name="choice" value="1. ${choices[0]}">
			<input id="answer-button" type="submit" name="choice" value="2. ${choices[1]}">
			<%if ((int)request.getAttribute("choice_count") == 4) {%>
				<input id="answer-button" type="submit" name="choice" value="3. ${choices[2]}">
				<input id="answer-button" type="submit" name="choice" value="4. ${choices[3]}">
			<%}%>
		</form>
		
		<!-- 힌트 버튼 -->
		<form action="hint?room=${room_number}&object=${object_number}" method="post">
			<input class="hint-button" id="button" type="submit" value="힌트">
		</form>
		
		<!-- 뒤로가기 버튼 -->
		<form action="enter-room?room=${room_number}&show-chat=false" method="post">
			<input id="button" type="submit" value="뒤로가기">
		</form>

		<!-- 음원 재생 버튼 -->
		<input class="sound-button" id="assets/sounds/bgms/room${room_number}_bgm.mp3" type="image">
		
		<!-- 타이머 실행 -->
		<script src="js/timer.js"></script>

		<!-- Sound 버튼 연결 -->
		<script src="js/sound_button.js"></script>
		<!-- BGM Audio 연결 -->
		<script src="js/bgm_audio.js"></script>

		<!-- SFX Manager 연결 -->
		<script src="js/sfx_manager.js"></script>
		
		<!-- 현재 페이지 관련 js 코드 연결 -->
		<script src = "js/problem_set.js"></script>
	</body>
</html>