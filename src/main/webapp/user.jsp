<!-- 관리자 전용 페이지 - 사용자 조회 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.Vector"%>

<%@ page import="com.escape.dongnae.model.PlayerInfo"%>
<%@ page import="com.escape.dongnae.dao.PlayerInfoDAO"%>

<%
// 검색된 사용자 목록
Vector<PlayerInfo> searchedPlayers = (Vector<PlayerInfo>)request.getAttribute("searched_players");
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="css/user.css">
	</head>
	<body>
		<!-- 제목 -->
		<h1 class="title">사용자 조회</h1>
		<h2 class="sub-title">1365 ID로 사용자 검색</h2>
		
		<!-- 사용자 검색 프레임 -->
		<div class="search-user-frame">
			<label>1365 ID 입력</label><br>
			<form action="search-user" method="post">
				<input name="id" maxlength="20">
				<input type="submit" value="조회">
			</form>
		</div>
		
		<!-- 검색 결과 프레임 -->
		<h3>검색 결과</h3>
		<div class="search-result-frame">
			<table>
				<tr>
					<td>ID</td>
					<td>상태</td>
					<td>이해도</td>
					<td>접속 시간</td>
				</tr>
				<%if (searchedPlayers != null) {%>
					<%for (int i = 0; i < searchedPlayers.size(); i++) {%>
						<tr>
							<td><%=searchedPlayers.get(i).getId()%></td>
							<td><%=searchedPlayers.get(i).getSuccessful() ? "성공" : "실패"%></td>
							<td><%=searchedPlayers.get(i).getComprehension()%>%</td>
							<td><%=searchedPlayers.get(i).getStartTime()%></td>
						</tr>
					<%}%>
				<%}%>
			</table>
		</div>
		
		<!-- 가장 최근 플레이 정보 -->
		<h3>가장 최근 플레이 정보</h3>
		<!-- 1. 기본 정보 프레임 -->
		<div class="regular-info-frame">
			<table>
				<tr>
					<td>ID</td>
					<td>${id}</td>
				</tr>
				<tr>
					<td>접속 시간</td>
					<td>${start_time}</td>
				</tr>
				<tr>
					<td>종료 시간</td>
					<td>${end_time}</td>
				</tr>
				<tr>
					<td>상태</td>
					<td>${successful ? "성공" : "실패"}</td>
				</tr>
			</table>
		</div>
		<!-- 2. 게임 진행 정보 프레임 -->
		<div class="game-play-info-frame">
			<table>
				<tr>
					<td>최근 마지막 해결 방</td>
					<td>${last_solved_room_number}</td>
				</tr>
				<tr>
					<td>최근 마지막 해결 오브젝트</td>
					<td>${last_solved_object_number}</td>
				</tr>
				<tr>
					<td>최근 이해도</td>
					<td>${comprehension}%</td>
				</tr>
				<tr>
					<td>최근 획득 코드</td>
					<td>${code}</td>
				</tr>
			</table>
		</div>
	</body>
</html>