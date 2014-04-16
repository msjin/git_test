package com;

import java.awt.List;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class ProcTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProcTest p=new ProcTest();
//		p.a();
		p.t();
//		System.out.println(Types.ARRAY);
	}
	
	public void t(){
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			String url="jdbc:jtds:sqlserver://127.0.0.1:1433/BUSINESS";
			Connection conn=DriverManager.getConnection(url, "sa","sa");
			CallableStatement call=conn.prepareCall("{call dbo.proc1(?)}");
			call.registerOutParameter(1, Types.OTHER);
			call.execute();
			ResultSet rs=(ResultSet)call.getObject(1);
			if(rs.next()) System.out.println("yes");
//			call.getString("dept_name");
			System.out.println(call.getObject(1));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void a(){
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			String url="jdbc:jtds:sqlserver://127.0.0.1:1433/BUSINESS";
			Connection conn=DriverManager.getConnection(url, "sa","sa");
			PreparedStatement ps=conn.prepareStatement("select * from dept");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getObject("dept_name"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
