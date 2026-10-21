package com.escape.dongnae.dao;

import java.sql.*;
import com.escape.dongnae.model.Chat;

interface ChatDAOInterface {
	// 지정된 채팅 종류에 해당하는 채팅 데이터를 반환함.
	public abstract Chat getChat(byte chatType) throws Exception;
	// 지정된 채팅 종류, 방 번호에 해당하는 채팅 데이터를 반환함.
	public abstract Chat getChat(byte chatType, byte roomNumber) throws Exception;
	// 지정된 채팅 종류, 방 번호, 오브젝트 번호에 해당하는 채팅 데이터를 반환함.
	public abstract Chat getChat(byte chatType, byte roomNumber, byte objectNumber) throws Exception;
}

// 채팅 데이터를 처리하는 DAO
public class ChatDAO implements ChatDAOInterface {
	// 지정된 채팅 종류에 해당하는 채팅 데이터를 반환함.
	@Override
	public Chat getChat(byte chatType)
			throws Exception {
		return this.getChat(chatType, (byte)0);
	}
	
	// 지정된 채팅 종류, 방 번호에 해당하는 채팅 데이터를 반환함.
	@Override
	public Chat getChat(byte chatType, byte roomNumber)
			throws Exception {
		return this.getChat(chatType, roomNumber, (byte)0);
	}
	
	// 지정된 채팅 종류, 방 번호, 오브젝트 번호에 해당하는 채팅 데이터를 반환함.
	@Override
	public Chat getChat(byte chatType, byte roomNumber, byte objectNumber)
			throws Exception {
		// Oracle JDBC 드라이버를 명시적으로 로딩함.
		Class.forName("oracle.jdbc.OracleDriver");

		String url = "jdbc:oracle:thin:@localhost:1521/FREEPDB1";
		// 지정된 채팅 종류에 따른 채팅 데이터를 불러옴.
		String sql = "SELECT * FROM CHAT "
				+ "WHERE CHAT_TYPE = " + chatType
				+ " AND ROOM_NUMBER = " + roomNumber
				+ " AND OBJECT_NUMBER = " + objectNumber
				+ " ORDER BY CHAT_ORDER";
		
		Connection connection = DriverManager.getConnection(url, "system", "288744");
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
			
		Chat chat = new Chat();
			
		while (resultSet.next()) {
			byte userType = resultSet.getByte("USER_TYPE"); // 사용자 종류
			String message = resultSet.getString("MESSAGE"); // 메시지
				
			chat.addMessage(userType, message);
		}
			
		resultSet.close();
		statement.close();
		connection.close();
			
		return chat;
	}
}