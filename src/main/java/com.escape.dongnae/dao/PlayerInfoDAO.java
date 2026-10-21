package com.escape.dongnae.dao;

import java.sql.*;
import java.util.Vector;

import com.escape.dongnae.model.PlayerInfo;

interface PlayerInfoDAOInterface {
	// 플레이어의 정보를 생성하는 메소드
	public abstract void createPlayerInfo(PlayerInfo playerInfo) throws Exception;
	// 플레이어의 정보를 업데이트하는 메소드 - 게임 진행 중 시점
	public abstract void updatePlayerInfo(PlayerInfo playerInfo) throws Exception;
	// 플레이어의 정보를 업데이트하는 메소드 - 게임 종료 시점
	public abstract void updatePlayerInfo(PlayerInfo playerInfo, boolean endedGame) throws Exception;
	// ID 기준으로 사용자 정보 목록을 검색하는 메소드
	public abstract Vector<PlayerInfo> searchPlayerInfoById(String id) throws Exception;
	// 마지막으로 푼 문제에 해당하는 방과 오브젝트 번호를 반환하는 메소드
	public abstract Vector<Byte> getLastSolvedRoomAndObjectNumber(PlayerInfo playerInfo);
	// 전체 접속 사용자 목록을 반환하는 메소드
	public abstract Vector<PlayerInfo> getRecentPlayerInfos() throws Exception;
	// 전체 접속 사용자 중 검색하려는 ID에 해당하는 사용자 목록을 반환하는 메소드
	public abstract Vector<PlayerInfo> getRecentPlayerInfos(String targetId) throws Exception;
	// 전체 접속 사용자 목록을 게임 성공 여부에 따라 반환하는 메소드
	public abstract Vector<PlayerInfo> getRecentPlayerInfos(boolean targetSuccessful) throws Exception;
	// 전체 접속 사용자 중 검색하려는 ID에 해당하는 사용자 목록을 게임 성공 여부에 따라 반환하는 메소드
	public abstract Vector<PlayerInfo> getRecentPlayerInfos(boolean targetSuccessful, String targetId) throws Exception;
	// 최근 접속 사용자 목록을 게임 성공 여부 관계 없이 반환하는 메소드
	public abstract Vector<PlayerInfo> getRecentPlayerInfos(int count) throws Exception;
	// 최근 접속 사용자 중 검색하려는 ID에 해당하는 사용자 목록을 게임 성공 여부에 관계 없이 반환하는 메소드
	public abstract Vector<PlayerInfo> getRecentPlayerInfos(int count, String targetId) throws Exception;
	// 최근 접속 사용자 목록을 반환하는 메소드
	public abstract Vector<PlayerInfo> getRecentPlayerInfos(Integer count, Boolean targetSuccessful) throws Exception;
	// 최근 접속 사용자 중 검색하려는 ID에 해당하는 사용자 목록을 반환하는 메소드
	public abstract Vector<PlayerInfo> getRecentPlayerInfos(Integer count, Boolean targetSuccessful, String targetId) throws Exception;
	// 각 방의 성공 여부를 반환하는 메소드
	public abstract boolean[] getSolvedRooms(byte lastSolvedRoomNumber, byte lastSolvedObjectNumber);
	// 각 오브젝트의 성공 여부를 반환하는 메소드
	public abstract boolean[][] getSolvedObjects(byte lastSolvedRoomNumber, byte lastSolvedObjectNumber);
	// 각 오브젝트의 성공 여부를 기반으로 이해도를 반환하는 메소드
	public abstract byte solvedObjectsToComprehension(boolean[][] solvedObjects);
	// DB의 저장공간 관리를 위해 저장하는 플레이어의 최대 수를 제한하는 메소드
	public abstract void manageDBStorage(Statement statement) throws SQLException;
}

// 플레이어의 정보를 관리하는 DAO
public class PlayerInfoDAO implements PlayerInfoDAOInterface {
	// 플레이어의 정보를 생성하는 메소드
	@Override
	public void createPlayerInfo(PlayerInfo playerInfo)
			throws Exception {
		// ID
		String id = playerInfo.getId().replace("\'", "\'\'");

		// Oracle JDBC 드라이버를 명시적으로 로딩함.
		Class.forName("oracle.jdbc.OracleDriver");

		String url = "jdbc:oracle:thin:@localhost:1521/FREEPDB1";
		// 사용자 데이터 저장
		String sql1 = "INSERT INTO PLAYER_INFO VALUES("
				+ "\'" + id + "\', " // id
				+ "CAST(SYSTIMESTAMP AT TIME ZONE 'Asia/Seoul' AS DATE), " // 접속 시간
				+ "null, " // 종료 시간
				+ "\'-\', " // 획득 코드
				+ 0 + ", " // 마지막으로 푼 문제에 해당하는 방 번호
				+ 0 + ", " // 마지막으로 푼 문제에 해당하는 오브젝트 번호
				+ 0 // 최종 게임 성공 여부
				+ ")";
		// 접속 시간 정보
		String sql2 = "SELECT CAST(SYSTIMESTAMP AT TIME ZONE 'Asia/Seoul' AS DATE) START_TIME FROM DUAL";
			
		Connection connection = DriverManager.getConnection(url, "system", "288744");
		Statement statement = connection.createStatement();
		statement.executeUpdate(sql1);
		ResultSet resultSet = statement.executeQuery(sql2);
			
		resultSet.next();
		playerInfo.setStartTime(resultSet.getString("START_TIME"));
		
		// DB 저장공간 관리
		this.manageDBStorage(statement);
			
		resultSet.close();
		statement.close();
		connection.close();
	}
	
	@Override
	// 플레이어의 정보를 업데이트하는 메소드 - 게임 진행 중 시점
	public void updatePlayerInfo(PlayerInfo playerInfo) throws Exception {
		this.updatePlayerInfo(playerInfo, false);
	}

	// 플레이어의 정보를 업데이트하는 메소드 - 게임 종료 시점
	@Override
	public void updatePlayerInfo(PlayerInfo playerInfo, boolean endedGame)
			throws Exception {
		// ID
		String id = playerInfo.getId().replace("\'", "\'\'");
		Vector<Byte> solvedRoomAndObjectNumber
				= this.getLastSolvedRoomAndObjectNumber(playerInfo);
		// 접속 시간
		String startTime = playerInfo.getStartTime();
		// 획득 코드
		String code = playerInfo.getCode();
		// 마지막으로 푼 문제에 해당하는 방 번호
		byte lastSolvedRoomNumber = solvedRoomAndObjectNumber.get(0);
		// 마지막으로 푼 문제에 해당하는 오브젝트 번호
		byte lastSolvedObjectNumber = solvedRoomAndObjectNumber.get(1);
		// 최종 게임 성공 여부
		boolean successful = playerInfo.getSuccessful();
		byte byteSuccessful = successful ? (byte)1 : (byte)0;

		// Oracle JDBC 드라이버를 명시적으로 로딩함.
		Class.forName("oracle.jdbc.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521/FREEPDB1";
		// 사용자 데이터 업데이트
		String sql1 = "UPDATE PLAYER_INFO SET "
				// 종료 시간
				+ (endedGame ? "END_TIME = CAST(SYSTIMESTAMP AT TIME ZONE 'Asia/Seoul' AS DATE), " : "")
				+ "CODE = \'" + code + "\', " // 획득 코드
				+ "LAST_SOLVED_ROOM_NUMBER = " + lastSolvedRoomNumber + ", " // 마지막으로 푼 문제에 해당하는 방 번호
				+ "LAST_SOLVED_OBJECT_NUMBER = " + lastSolvedObjectNumber + ", " // 마지막으로 푼 문제에 해당하는 오브젝트 번호
				+ "GAME_SUCCESSFUL = " + byteSuccessful // 최종 게임 성공 여부
				+ " WHERE ID = \'" + id + "\' "
						// 동일 사용자 여러 명 있을 수 있으므로 접속 시간에 해당하는 사용자 데이터를 업데이트함.
						+ "AND START_TIME = TO_DATE(\'" + startTime + "\', \'YYYY-MM-DD HH24:MI:SS\')";
		// 종료 시간 정보
		String sql2 = "SELECT CAST(SYSTIMESTAMP AT TIME ZONE 'Asia/Seoul' AS DATE) END_TIME FROM DUAL";
			
		Connection connection = DriverManager.getConnection(url, "system", "288744");
		Statement statement = connection.createStatement();
		statement.executeUpdate(sql1);
		ResultSet resultSet = statement.executeQuery(sql2);
			
		resultSet.next();
		if (endedGame)
			playerInfo.setEndTime(resultSet.getString("END_TIME"));
		
		// DB 저장공간 관리
		this.manageDBStorage(statement);
			
		resultSet.close();
		statement.close();
		connection.close();
	}
	
	// ID 기준으로 사용자 정보 목록을 검색하는 메소드
	@Override
	public Vector<PlayerInfo> searchPlayerInfoById(String targetId)
			throws Exception {
		// Oracle JDBC 드라이버를 명시적으로 로딩함.
		Class.forName("oracle.jdbc.OracleDriver");
		
		Vector<PlayerInfo> playerInfos = new Vector<>();
		String url = "jdbc:oracle:thin:@localhost:1521/FREEPDB1";
		String sql = "SELECT * FROM PLAYER_INFO "
				+ "WHERE ID = \'" + targetId.replace("\'", "\'\'") + "\' "
				+ "ORDER BY START_TIME DESC"; // 접속 시간 최신순 정렬
			
		Connection connection = DriverManager.getConnection(url, "system", "288744");
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
			
		while (resultSet.next()) {
			// id
			String id = resultSet.getString("ID");
			// 접속 시간
			String startTime = resultSet.getString("START_TIME");
			// 종료 시간
			String endTime = resultSet.getString("END_TIME") == null
					? "-" : resultSet.getString("END_TIME");
			// 획득 코드
			String code = resultSet.getString("CODE");
			// 각 방의 성공 여부
			boolean[] solvedRooms = this.getSolvedRooms(
				resultSet.getByte("LAST_SOLVED_ROOM_NUMBER"),
				resultSet.getByte("LAST_SOLVED_OBJECT_NUMBER")
			);
			// 각 오브젝트의 성공 여부
			boolean[][] solvedObjects = this.getSolvedObjects(
				resultSet.getByte("LAST_SOLVED_ROOM_NUMBER"),
				resultSet.getByte("LAST_SOLVED_OBJECT_NUMBER")
			);
			// 이해도
			byte comprehention = this.solvedObjectsToComprehension(solvedObjects);
			// 최종 게임 성공 여부
			boolean successful
					= resultSet.getByte("GAME_SUCCESSFUL") == 1 ? true : false;
				
			PlayerInfo playerInfo = new PlayerInfo(id, startTime, endTime, "플레이어");
			playerInfo.setComprehension(comprehention);
			playerInfo.setCode(code);
			playerInfo.setSolvedRooms(solvedRooms);
			playerInfo.setSolvedObjects(solvedObjects);
			playerInfo.setSuccessful(successful);
				
			playerInfos.add(playerInfo);
		}
			
		resultSet.close();
		statement.close();
		connection.close();

		return playerInfos;
	}
	
	// 마지막으로 푼 문제에 해당하는 방과 오브젝트 번호를 반환하는 메소드
	@Override
	public Vector<Byte> getLastSolvedRoomAndObjectNumber(PlayerInfo playerInfo) {
		boolean[][] solvedObjects = playerInfo.getSolvedObjests();
		byte lastSolvedRoomNumber = 0, lastSolvedObjectNumber = 0;
		for (byte i = 0; i < solvedObjects.length; i++) {
			for (byte j = 0; j < solvedObjects[i].length; j++) {
				// 문제 풀이에 성공한 오브젝트
				if (solvedObjects[i][j]) {
					lastSolvedRoomNumber = (byte)(i + 1);
					lastSolvedObjectNumber = (byte)(j + 1);
				}
				else { // 문제 풀이에 실패한 오브젝트
					Vector<Byte> solvedRoomAndObjectNumber = new Vector<>();
					solvedRoomAndObjectNumber.add(lastSolvedRoomNumber);
					solvedRoomAndObjectNumber.add(lastSolvedObjectNumber);
					return solvedRoomAndObjectNumber;
				}
			}
		}
		Vector<Byte> solvedRoomAndObjectNumber = new Vector<>();
		solvedRoomAndObjectNumber.add((byte)solvedObjects.length);
		solvedRoomAndObjectNumber.add((byte)solvedObjects[0].length);
		return solvedRoomAndObjectNumber;
	}

	// 전체 접속 사용자 목록을 반환하는 메소드
	@Override
	public Vector<PlayerInfo> getRecentPlayerInfos()
			throws Exception {
		return this.getRecentPlayerInfos(null, null, null);
	}
	
	// 전체 접속 사용자 중 검색하려는 ID에 해당하는 사용자 목록을 반환하는 메소드
	@Override
	public Vector<PlayerInfo> getRecentPlayerInfos(String targetId)
			throws Exception {
		return this.getRecentPlayerInfos(null, null, targetId);
	}
	
	// 전체 접속 사용자 목록을 게임 성공 여부에 따라 반환하는 메소드
	@Override
	public Vector<PlayerInfo> getRecentPlayerInfos(boolean targetSuccessful)
			throws Exception {
		return this.getRecentPlayerInfos(null, Boolean.valueOf(targetSuccessful), null);
	}

	// 전체 접속 사용자 중 검색하려는 ID에 해당하는 사용자 목록을 게임 성공 여부에 따라 반환하는 메소드
	@Override
	public Vector<PlayerInfo> getRecentPlayerInfos(boolean targetSuccessful, String targetId)
			throws Exception {
		return this.getRecentPlayerInfos(null, Boolean.valueOf(targetSuccessful), targetId);
	}
	
	// 최근 접속 사용자 목록을 게임 성공 여부에 관계 없이 반환하는 메소드
	@Override
	public Vector<PlayerInfo> getRecentPlayerInfos(int count)
			throws Exception {
		return this.getRecentPlayerInfos(Integer.valueOf(count), null, null);
	}
	
	// 최근 접속 사용자 중 검색하려는 ID에 해당하는 사용자 목록을 게임 성공 여부에 관계 없이 반환하는 메소드
	@Override
	public Vector<PlayerInfo> getRecentPlayerInfos(int count, String targetId)
			throws Exception {
		return this.getRecentPlayerInfos(Integer.valueOf(count), null, targetId);
	}

	// 최근 접속 사용자 목록을 반환하는 메소드
	@Override
	public Vector<PlayerInfo> getRecentPlayerInfos(Integer count, Boolean targetSuccessful)
			throws Exception {
		return this.getRecentPlayerInfos(count, targetSuccessful, null);
	}
	
	// 최근 접속 사용자 중 검색하려는 ID에 해당하는 사용자 목록을 반환하는 메소드
	@Override
	public Vector<PlayerInfo> getRecentPlayerInfos(Integer count, Boolean targetSuccessful, String targetId)
			throws Exception {
		// 최근 접속 사용자 목록
		Vector<PlayerInfo> recentPlayerInfos = new Vector<>();

		// Oracle JDBC 드라이버를 명시적으로 로딩함.
		Class.forName("oracle.jdbc.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521/FREEPDB1";
		String sql = "SELECT * FROM ("
				+ "SELECT "
				+ "PLAYER_INFO.*, "
				+ "ROW_NUMBER() OVER (ORDER BY START_TIME DESC) START_TIME_NUMBER "
				+ "FROM PLAYER_INFO"
				+ ")";
		if (count != null || targetSuccessful != null || targetId != null)
			sql += " WHERE ";
		boolean checkedCondition = false; // 조건 검사 여부
		if (count != null) {
			sql += "START_TIME_NUMBER <= " + count.intValue();
			checkedCondition = true;
		}
		if (targetSuccessful != null) {
			if (checkedCondition)
				sql += "AND ";
			else
				checkedCondition = true;
			sql += "GAME_SUCCESSFUL = " + (targetSuccessful.booleanValue() ? 1 : 0);
		}
		if (targetId != null) {
			if (checkedCondition)
				sql += "AND ";
			else
				checkedCondition = true;
			sql += "ID = \'" + targetId + "\'";
		}
		sql += " ORDER BY START_TIME_NUMBER";
			
		Connection connection = DriverManager.getConnection(url, "system", "288744");
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
			
		while (resultSet.next()) {
			String id = resultSet.getString("ID"); // 1365 ID
			String startTime = resultSet.getString("START_TIME"); // 접속 시간
			// 종료 시간
			String endTime = resultSet.getString("END_TIME") == null
					? "-" : resultSet.getString("END_TIME");
			// 각 방의 성공 여부
			boolean[] solvedRooms
					= this.getSolvedRooms(
						resultSet.getByte("LAST_SOLVED_ROOM_NUMBER"),
						resultSet.getByte("LAST_SOLVED_OBJECT_NUMBER")
					);
			// 각 오브젝트의 성공 여부
			boolean[][] solvedObjects
					= this.getSolvedObjects(
						resultSet.getByte("LAST_SOLVED_ROOM_NUMBER"),
						resultSet.getByte("LAST_SOLVED_OBJECT_NUMBER")
					);
			// 이해도
			byte comprehension = this.solvedObjectsToComprehension(solvedObjects);
			// 획득 코드
			String code = resultSet.getString("CODE");
			// 최종 게임 성공 여부
			boolean successful = resultSet.getByte("GAME_SUCCESSFUL") == 1 ? true : false;

			PlayerInfo playerInfo = new PlayerInfo(id, startTime, endTime, "플레이어");
			playerInfo.setComprehension(comprehension);
			playerInfo.setCode(code);
			playerInfo.setSolvedRooms(solvedRooms);
			playerInfo.setSolvedObjects(solvedObjects);
			playerInfo.setSuccessful(successful);
				
			recentPlayerInfos.add(playerInfo);
		}
			
		resultSet.close();
		statement.close();
		connection.close();
		
		return recentPlayerInfos;
	}
	
	// 각 방의 성공 여부를 반환하는 메소드
	@Override
	public boolean[] getSolvedRooms(byte lastSolvedRoomNumber,
			byte lastSolvedObjectNumber) {
		boolean[] solvedRooms = new boolean[4];
		for (byte i = 0; i < solvedRooms.length; i++) {
			if ((i + 1) < lastSolvedRoomNumber)
				solvedRooms[i] = true;
			else if ((i + 1) == lastSolvedRoomNumber) {
				if (lastSolvedObjectNumber == 5)
					solvedRooms[i] = true;
				else
					solvedRooms[i] = false;
			}
			else
				solvedRooms[i] = false;
		}
		return solvedRooms;
	}
	
	// 각 오브젝트의 성공 여부를 반환하는 메소드
	@Override
	public boolean[][] getSolvedObjects(byte lastSolvedRoomNumber,
			byte lastSolvedObjectNumber) {
		boolean[][] solvedObjects = new boolean[4][5];
		for (byte i = 0; i < solvedObjects.length; i++) {
			for (byte j = 0; j < solvedObjects[i].length; j++) {
				if (i * 5 + (j + 1)
						<= (lastSolvedRoomNumber - 1) * 5 + lastSolvedObjectNumber)
					solvedObjects[i][j] = true;
				else
					solvedObjects[i][j] = false;
			}
		}
		
		return solvedObjects;
	}

	// 각 오브젝트의 성공 여부를 기반으로 이해도를 반환하는 메소드
	@Override
	public byte solvedObjectsToComprehension(boolean[][] solvedObjects) {
		// 해결 완료한 오브젝트의 개수
		byte solvedObjectCount = 0;
		for (byte i = 0; i < solvedObjects.length; i++) {
			for (byte j = 0; j < solvedObjects[i].length; j++) {
				if (solvedObjects[i][j])
					solvedObjectCount++;
				else
					break;
			}
		}
		return (byte)(((float)solvedObjectCount / (solvedObjects.length * solvedObjects[0].length)) * 100);
	}
	
	@Override
	// DB의 저장공간 관리를 위해 저장하는 플레이어의 최대 수를 제한하는 메소드
	public void manageDBStorage(Statement statement)
			throws SQLException {
		// 저장된 플레이어의 수를 알아냄.
		String sql1 = "SELECT COUNT(*) PLAYER_COUNT FROM PLAYER_INFO";
		// 오래된 플레이어의 데이터들을 삭제함.
		String sql2 = "DELETE PLAYER_INFO WHERE START_TIME IN ("
					+ "SELECT START_TIME FROM ("
						+ "SELECT "
							+ "PLAYER_INFO.*, "
							+ "ROW_NUMBER() OVER (ORDER BY START_TIME DESC) START_TIME_NUMBER "
							+ "FROM PLAYER_INFO"
					+ ") WHERE START_TIME_NUMBER > 900"
				+ ")";
		ResultSet resultSet = statement.executeQuery(sql1);
		resultSet.next();

		int playerCount = resultSet.getInt("PLAYER_COUNT");
		// 저장할 수 있는 플레이어의 최대 수를 1000으로 제한함.
		if (playerCount > 1000)
			statement.executeUpdate(sql2);

		resultSet.close();
	}
}