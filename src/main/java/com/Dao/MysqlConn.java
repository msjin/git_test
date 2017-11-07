package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlConn {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			connection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection connection() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String user = "root";
		String password = "123";
		String url = "jdbc:mysql://localhost:3306/test";
		Connection conn = DriverManager.getConnection(url,user,password);
		return conn;
	}

}
