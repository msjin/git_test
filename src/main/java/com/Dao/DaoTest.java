package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DaoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			testMysqlConn();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void testMysqlConn() throws Exception{
		String sql = "select name ,GROUP_CONCAT(inv,cus,money,id) as property FROM test GROUP BY name";
		Connection conn = MysqlConn.connection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.execute();
		ResultSet rs = ps.getResultSet();
		if(rs.next()){
			Object obj = rs.getObject("property");
			System.out.println(obj);
		}
	}

}
