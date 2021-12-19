package Health;

import java.util.*;
import java.sql.*;
import java.text.*;
import java.io.*;

public class health_insert {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
	String user = "root";
	String pass = "Wjdqhgus929!";	
	public void insert(int num, String date, int sleep, int water, int meal)
	{
		Connection con = null; //데이터베이스와 연결을 위한 객체
		PreparedStatement pstmt=null; //SQL문을 데이터베이스에 보내기위한 객체
		
		try
		{
			//JDBC 드라이버 로딩-MySQL JDBC 드라이버의 Driver Class 로딩
	    	Class.forName(driver);
	    	con=DriverManager.getConnection(url, user, pass);
	    	String SQL = "insert into health(num, sleep, water, meal, date) values(?, ?, ?, ?, ?)";
	    	
	    	//PreParedStatement 객체 생성, 객체 생성시 SQL 문장 저장
	        pstmt=con.prepareStatement(SQL);
	        
	        //pstmt.set<데이터타입>(? 순서, 값) ex) .setString(), .setInt()
	        pstmt.setInt(1, num);
	        pstmt.setInt(2, meal);
	        pstmt.setInt(3, sleep);
	        pstmt.setInt(4, water);
	        pstmt.setString(5, date);
	        
	        num++;
	      
	        pstmt.executeUpdate();
	        pstmt.close();
	        con.close();
	    	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
