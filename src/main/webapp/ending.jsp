<!-- 엔딩 페이지 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="css/ending.css">
	</head>
	<body>
		<!-- 배경화면 -->
		<img class="background-image"
				src="${ending_background}">
				
		<!-- 엔딩 메시지 -->
		<label class="ending-message">${ending_message}</label>
		
		<!-- 게임 다시 시작 버튼 -->
		<form action="main_theme.html" method="post">
			<input id="button" type="submit" value="게임 다시 시작">
		</form>
		
		<!-- 크레딧 영역 -->
		<div class="credits">
			<label class="title-label">Credits</label><br>
			<label class="game-design-label">Game Design: 정재욱, AI Agent</label><br>
			<label class="programming-label">Programming: 정재욱</label><br>
			<label class="art-label">Art: Pixabay, AI Agent</label><br>
			<label class="audio-label">Audio: JUK(정재욱), nojisuma, MondayHopes, Tomas_Herudek, AI Agent</label><br>
			<label class="writing-label">Writing: 동래구자원봉사센터</label>
		</div>
		
		<!-- BGM 영역 -->
		<div class="BGM">
			<label class="title-label">BGM</label>
			<label class="main-theme-label">Main Theme: JUK - Into the Magic World!</label><br>
			<label class="chat-theme-label">Chat Theme: nojisuma - ひとかけら Piece</label><br>
			<label class="select-room-theme-label">Select Room Theme: [AI Generated] LiteSaturation - Calm Guitar No Copyright</label><br>
			<label class="room1-label">Room1: JUK - Reverie</label><br>
			<label class="room2-label">Room2: JUK - Dance of the Little Princess</label><br>
			<label class="room3-label">Room3: JUK - Longing in My Memory</label><br>
			<label class="room4-label">Room4: JUK - In The Pouring Stars</label><br>
			<label class="ending1-label">Ending1: MondayHopes - Who Are You</label><br>
			<label class="ending2-label">Ending2: Tomas_Herudek - So So Sad (Sad Meme Music)</label>
		</div>

		<!-- 음원 재생 버튼 -->
		<input class="sound-button" id="${ending_bgm_source}" type="image">

		<!-- Sound 버튼 연결 -->
		<script src="js/sound_button.js"></script>
		<!-- BGM Audio 연결 -->
		<script src="js/bgm_audio.js"></script>

		<!-- SFX Manager 연결 -->
		<script src="js/sfx_manager.js"></script>
	</body>
</html>