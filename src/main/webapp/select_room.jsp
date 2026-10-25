<!-- 4개의 각 방으로 들어갈 수 있도록 해주는 페이지 -->
<!-- 플레이어가 클리어해야 하는 방의 문만 활성화됨. -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="css/select_room.css">
	</head>
	<body>
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

		<!-- 배경화면 -->
		<img class="background-image"
				src="assets/images/backgrounds/rooms_background.jpg">

		<!-- 4개의 방 -->
		<label class="select-room-title">입장할 방을 선택하세요.</label><br>
		
		<label class="room1-label">동래읍성</label>
		<label class="room2-label">동래시장</label>
		<label class="room3-label">온천천</label>
		<label class="room4-label">${room4_name}</label>

		<a id="door-link" href="enter-room?room=1&show-chat=true">
			<img class="room1-image" id="door" src="${door_image_sources[0]}">
		</a>
		<a id="door-link" href="enter-room?room=2&show-chat=true">
			<img class="room2-image" id="door" src="${door_image_sources[1]}">
		</a>
		<a id="door-link" href="enter-room?room=3&show-chat=true">
			<img class="room3-image" id="door" src="${door_image_sources[2]}">
		</a>
		<a id="door-link" href="enter-room?room=4&show-chat=true">
			<img class="room4-image" id="door" src="${door_image_sources[3]}">
		</a>

		<!-- 음원 재생 버튼 -->
		<input class="sound-button" id="assets/sounds/bgms/select_room_theme_bgm.mp3" type="image">
		
		<!-- 화면 페이드아웃 개체 -->
		<div id="fade-screen"></div>

		<!-- 타이머 실행 -->
		<script src="js/timer.js"></script>

		<!-- Sound 버튼 연결 -->
		<script src="js/sound_button.js"></script>
		<!-- BGM Audio 연결 -->
		<script src="js/bgm_audio.js"></script>

		<!-- SFX Manager 연결 -->
		<script src="js/sfx_manager.js"></script>
		
		<!-- 화면 전환 관리자 연결 -->
		<script src="js/screen_manager.js"></script>
	</body>
</html>
