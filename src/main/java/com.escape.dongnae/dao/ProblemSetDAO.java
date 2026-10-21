package com.escape.dongnae.dao;

import java.sql.*;
import java.util.Vector;

import com.escape.dongnae.model.ProblemSet;

interface ProblemSetDAOInterface {
	public abstract ProblemSet getProblemSet(byte roomNumber, byte questionNumber) throws Exception;
}

// 문제 데이터를 처리하는 DAO
public class ProblemSetDAO implements ProblemSetDAOInterface {
	@Override
	public ProblemSet getProblemSet(byte roomNumber, byte questionNumber)
			throws Exception {
		// Oracle JDBC 드라이버를 명시적으로 로딩함.
		Class.forName("oracle.jdbc.OracleDriver");

		String url = "jdbc:oracle:thin:@localhost:1521/FREEPDB1";
		// 지정된 방 번호와 문항에 해당하는 문제 데이터 목록을 가져옴.
		String sql = "SELECT * FROM PROBLEM_SET "
				+ "WHERE ROOM_NUMBER = " + roomNumber
				+ " AND QUESTION_NUMBER = " + questionNumber;
		
		Connection connection = DriverManager.getConnection(url, "system", "288744");
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
			
		resultSet.next();
			
		ProblemSet problemSet; // 문제 데이터에는 보기 목록이 한꺼번에 들어감.
		String question = resultSet.getString("QUESTION"); // 문제
		String item = resultSet.getString("item"); // 아이템
		Vector<String> choices = new Vector<>(); // 보기 목록
		choices.add(resultSet.getString("CHOICE"));
		byte answer = resultSet.getByte("ANSWER"); // 정답
		while (resultSet.next()) {
			String choice = resultSet.getString("CHOICE");
			choices.add(choice);
		}
			
		problemSet = new ProblemSet(question, choices, answer, item);
			
		resultSet.close();
		statement.close();
		connection.close();
			
		return problemSet;
	}
}