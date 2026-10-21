<!-- 각 방의 모습을 구현함. -->
<!-- 방 안에는 5개의 클릭 가능한 오브젝트가 존재함. -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="css/room${room_number}.css">
	</head>
	<body>
		<!-- 배경화면 -->
		<img class="background-image"
				src="assets/images/backgrounds/room${room_number}_background.jpg">

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
		
		<label>오브젝트를 찾아 클릭하시오.</label><br>

		<!-- 5개의 오브젝트 -->
		<!-- 각 오브젝트를 클릭하면 문제들을 풀 수 있음. -->
		<a href="solve-problem?room=${room_number}&object=1">
			<img class="object1-image" id="object"
					src="assets/images/backgrounds/room${room_number}_object1_background.png">
		</a>
		<a href="solve-problem?room=${room_number}&object=2">
			<img class="object2-image" id="object"
					src="assets/images/backgrounds/room${room_number}_object2_background.png">
		</a>
		<a href="solve-problem?room=${room_number}&object=3">
			<img class="object3-image" id="object"
					src="assets/images/backgrounds/room${room_number}_object3_background.png">
		</a>
		<a href="solve-problem?room=${room_number}&object=4">
			<img class="object4-image" id="object"
					src="assets/images/backgrounds/room${room_number}_object4_background.png">
		</a>
		<a href="solve-problem?room=${room_number}&object=5">
			<img class="object5-image" id="object"
					src="assets/images/backgrounds/room${room_number}_object5_background.png">
		</a>
		
		<!-- info 버튼 -->
		<form action="show-info?room=${room_number}&object=${solve_object_number}" method="post">
			<input class="info-button" id="button" type="image" src="assets/images/icons/info_icon.png">
		</form>
		<!-- info 버튼을 클릭하라는 레이블 -->
		<label class="show-info-label">${show_info_message}</label>

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
	</body>
</html>