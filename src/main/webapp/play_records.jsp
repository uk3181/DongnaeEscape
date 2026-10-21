<!-- 관리자 전용 페이지 - 플레이 기록 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.Vector"%>

<%@ page import="com.escape.dongnae.model.PlayerInfo"%>
<%@ page import="com.escape.dongnae.dao.PlayerInfoDAO"%>

<%
// 최근 플레이 기록 목록
Vector<PlayerInfo> recentPlayRecords = (Vector<PlayerInfo>)request.getAttribute("recent_play_records");
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="css/play_records.css">
	</head>
	<body>
		<!-- 제목 -->
		<h1 class="title">플레이 기록</h1>
		<h2 class="sub-title">전체 사용자의 플레이 기록</h2>
		
		<!-- 검색/필터 프레임 -->
		<form action="search-play-records" method="post">
			<label>1365 ID</label>
			<input name="id">
			<label>상태</label>
			<select name="state">
				<option value="전체"${state == "전체" ? "selected" : null}>전체</option>
				<option value="성공"${state == "성공" ? "selected" : null}>성공</option>
				<option value="실패"${state == "실패" ? "selected" : null}>실패</option>
			</select>
		<input type="submit" value="조회">
		</form>
		
		<!-- 플레이 기록 -->
		<h3>플레이 기록</h3>
		<h4>최근 50명 플레이 기록</h4>
		<!-- 플레이 기록 프레임 -->
		<div class="play-records-frame">
			<!-- 최대 50명까지 보여줌. -->
			<table>
				<tr>
					<td>ID</td>
					<td>접속 시간</td>
					<td>마지막 해결 방</td>
					<td>마지막 해결 오브젝트</td>
					<td>상태</td>
					<td>이해도</td>
				</tr>
				<%if (recentPlayRecords != null) {%>
					<%for (int i = 0; i < recentPlayRecords.size(); i++) {%>
						<tr>
							<!-- ID -->
							<td><%=recentPlayRecords.get(i).getId()%></td>
							<!-- 접속 시간 -->
							<td><%=recentPlayRecords.get(i).getStartTime()%></td>
							<!-- 마지막 해결 방 -->
							<td><%=new PlayerInfoDAO().getLastSolvedRoomAndObjectNumber(recentPlayRecords.get(i)).get(0)%></td>
							<!-- 마지막 해결 오브젝트 -->
							<td><%=new PlayerInfoDAO().getLastSolvedRoomAndObjectNumber(recentPlayRecords.get(i)).get(1)%></td>
							<!-- 상태 -->
							<td><%=recentPlayRecords.get(i).getSuccessful() ? "성공" : "실패"%></td>
							<!-- 이해도 -->
							<td><%=recentPlayRecords.get(i).getComprehension()%>%</td>
						</tr>
					<%}%>
				<%} %>
			</table>
		</div>
	</body>
</html>