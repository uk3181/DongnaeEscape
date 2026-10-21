<!-- 관리자 전용 페이지 - 플레이 통계 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="css/play_statistics.css">
	</head>
	<body>
		<!-- 제목 -->
		<h1 class="title">플레이 통계</h1>
		<h2 class="sub-title">전체 게임 이용 통계</h2>

		<!-- 전체 플레이어 프레임 -->
		<div class="total-players-frame">
			<label>전체 플레이어</label><br>
			<label>${total_player_count}</label>
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
		
		<!-- 성공률 프레임 -->
		<div class="successful-rate-frame">
			<label>성공률</label>
			<label>${successful_rate}%</label>
		</div>
		<!-- 평균 이해도 프레임 -->
		<div class="average-comprehension-frame">
			<label>평균 이해도</label>
			<label>${average_comprehension}%</label>
		</div>
		
		<!-- 게임 진행 통계 -->
		<h3>게임 진행 통계</h3>
		<!-- 방별 해결 현황 프레임 -->
		<div class="room-statistics-frame">
			<label>방별 해결 현황</label>
			<table>
				<tr>
					<td>동래읍성</td>
					<td>${solved_room_counts[0]}명</td>
				</tr>
				<tr>
					<td>동래시장</td>
					<td>${solved_room_counts[1]}명</td>
				</tr>
				<tr>
					<td>온천천</td>
					<td>${solved_room_counts[2]}명</td>
				</tr>
				<tr>
					<td>자원봉사센터</td>
					<td>${solved_room_counts[3]}명</td>
				</tr>
			</table>
		</div>
		<!-- 오브젝트별 해결 현황 -->
		<div class="object-statistics-frame">
			<label>오브젝트별 해결 현황</label>
			<table>
				<tr>
					<td></td>
					<td>오브젝트 1</td>
					<td>오브젝트 2</td>
					<td>오브젝트 3</td>
					<td>오브젝트 4</td>
					<td>오브젝트 5</td>
				</tr>
				<tr>
					<td>동래읍성</td>
					<td>${solved_object_counts[0][0]}</td>
					<td>${solved_object_counts[0][1]}</td>
					<td>${solved_object_counts[0][2]}</td>
					<td>${solved_object_counts[0][3]}</td>
					<td>${solved_object_counts[0][4]}</td>
				</tr>
				<tr>
					<td>동래시장</td>
					<td>${solved_object_counts[1][0]}</td>
					<td>${solved_object_counts[1][1]}</td>
					<td>${solved_object_counts[1][2]}</td>
					<td>${solved_object_counts[1][3]}</td>
					<td>${solved_object_counts[1][4]}</td>
				</tr>
				<tr>
					<td>온천천</td>
					<td>${solved_object_counts[2][0]}</td>
					<td>${solved_object_counts[2][1]}</td>
					<td>${solved_object_counts[2][2]}</td>
					<td>${solved_object_counts[2][3]}</td>
					<td>${solved_object_counts[2][4]}</td>
				</tr>
				<tr>
					<td>자원봉사센터</td>
					<td>${solved_object_counts[3][0]}</td>
					<td>${solved_object_counts[3][1]}</td>
					<td>${solved_object_counts[3][2]}</td>
					<td>${solved_object_counts[3][3]}</td>
					<td>${solved_object_counts[3][4]}</td>
				</tr>
			</table>
		</div>
	</body>
</html>