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
		Connection con = null; //�����ͺ��̽��� ������ ���� ��ü
		PreparedStatement pstmt=null; //SQL���� �����ͺ��̽��� ���������� ��ü
		
		try
		{
			//JDBC ����̹� �ε�-MySQL JDBC ����̹��� Driver Class �ε�
	    	Class.forName(driver);
	    	con=DriverManager.getConnection(url, user, pass);
	    	String SQL = "insert into health(num, sleep, water, meal, date) values(?, ?, ?, ?, ?)";
	    	
	    	//PreParedStatement ��ü ����, ��ü ������ SQL ���� ����
	        pstmt=con.prepareStatement(SQL);
	        
	        //pstmt.set<������Ÿ��>(? ����, ��) ex) .setString(), .setInt()
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
