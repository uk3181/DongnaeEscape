<!-- 문제 풀이의 결과(정답/오답)를 보여주는 페이지 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="css/problem_result.css">
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
		
		<!-- 문제 풀이 결과를 보여줌. -->
		<label class="problem-result">${problem_result_message}</label>
		
		<!-- 확인 버튼 -->
		<form action="${action}" method="post">
			<input id="button" type="submit" value="확인">
		</form>
		
		<!-- 음원 재생 버튼 -->
		<input class="sound-button"
				id="assets/sounds/bgms/room${room_number}_bgm.mp3" type="image">
		
		<!-- 타이머 실행 -->
		<script src="js/timer.js"></script>

		<!-- Sound 버튼 연결 -->
		<script src="js/sound_button.js"></script>
		<!-- BGM Audio 연결 -->
		<script src="js/bgm_audio.js"></script>

		<!-- SFX Manager 연결 -->
		<script src="js/sfx_manager.js"></script>
	</body>
</html>