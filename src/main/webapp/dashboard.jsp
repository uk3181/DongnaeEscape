<!-- 관리자 전용 페이지 - 대시보드 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ page import="java.util.Vector"%>

<%@ page import="com.escape.dongnae.model.PlayerInfo"%>
<%@ page import="com.escape.dongnae.dao.PlayerInfoDAO"%>

<%
// 최근 접속 사용자 목록
Vector<PlayerInfo> recentUsers = (Vector<PlayerInfo>)request.getAttribute("recent_users");
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="css/dashboard.css">
	</head>
	<body>
		<!-- 제목 -->
		<h1 class="title">대시보드</h1>
		<h2 class="sub-title">게임 이용 현황</h2>
		
		<!-- 전체 사용자 프레임 -->
		<div class="total-users-frame">
			<label>전체 사용자</label><br>
			<label>${total_user_count}</label>
		</div>
		<!-- 게임 성공 프레임 -->
		<div class="successful-frame">
			<label>게임 성공</label><br>
			<label>${successful_count}</label>
		</div>
		<!-- 게임 실패 프레임 -->
		<div class="failed-frame">
			<label>게임 실패</label><br>
			<label>${failed_count}</label>
		</div>
		
		<!-- 최근 접속 사용자 프레임 -->
		<div class="recent-users-frame">
			<label>최근 접속 사용자 10명</label><br>
			<!-- 최대 10명까지 보여줌. -->
			<table>
				<tr>
					<td>ID</td>
					<td>상태</td>
				</tr>
				<%if (recentUsers != null) {%>
					<%for (int i = 0; i < recentUsers.size(); i++) {%>
						<tr>
							<!-- id -->
							<td><%=recentUsers.get(i).getId()%></td>
							<!-- 게임 성공 여부 -->
							<td><%=recentUsers.get(i).getSuccessful()
										? "성공" : "실패"%></td>
						</tr>
					<%}%>
				<%}%>
			</table>
		</div>
		
		<!-- 최근 게임 기록 프레임 -->
		<div class="recent-game-records">
			<label>최근 게임 기록</label><br>
			<!-- 최대 10명까지 보여줌. -->
			<table>
				<tr>
					<td>ID</td>
					<td>접속 시간</td>
					<td>마지막 해결 방</td>
					<td>마지막 해결 오브젝트</td>
					<td>상태</td>
					<td>이해도</td>
				</tr>
					<%if (recentUsers != null) {%>
						<%for (int i = 0; i < recentUsers.size(); i++) {%>
							<tr>
								<!-- ID -->
								<td><%=recentUsers.get(i).getId()%></td>
								<!-- 접속 시간 -->
								<td><%=recentUsers.get(i).getStartTime()%></td>
								<!-- 마지막 해결 방 -->
								<td><%=new PlayerInfoDAO().getLastSolvedRoomAndObjectNumber(recentUsers.get(i)).get(0)%></td>
								<!-- 마지막 해결 오브젝트 -->
								<td><%=new PlayerInfoDAO().getLastSolvedRoomAndObjectNumber(recentUsers.get(i)).get(1)%></td>
								<!-- 상태 -->
								<td><%=recentUsers.get(i).getSuccessful() ? "성공" : "실패"%></td>
								<!-- 이해도 -->
								<td><%=recentUsers.get(i).getComprehension()%>%</td>
							</tr>
						<%}%>
					<%}%>
			</table>
		</div>
	</body>
</html>