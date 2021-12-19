package Health;


import java.sql.*;


public class health_update {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
	String user = "root";
	String pass = "Wjdqhgus929!";	
	public void update(int num, String date, int sleep, int water, int meal)
	{
		Connection con = null; //�����ͺ��̽��� ������ ���� ��ü
		PreparedStatement pstmt=null; //SQL���� �����ͺ��̽��� ���������� ��ü
		
		try
		{
			//JDBC ����̹� �ε�-MySQL JDBC ����̹��� Driver Class �ε�
	    	Class.forName(driver);
	    	con=DriverManager.getConnection(url, user, pass);
	    	String updatedb = "update health set num=?, sleep=?, water=?, meal=? where date=?";
	    	
	    	//PreParedStatement ��ü ����, ��ü ������ SQL ���� ����
	        pstmt=con.prepareStatement(updatedb);
	        
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
	
	public void select(String date)
	{
		Connection con = null; //�����ͺ��̽��� ������ ���� ��ü
		Statement stmt=null;
		ResultSet rs=null; //SQL ���ǿ� ���� ������ ���̺��� �����ϴ� ��ü
		
		
		try
		{
			Class.forName(driver);
	    	con=DriverManager.getConnection(url, user, pass);
	    	
			String selectdb = "SELECT * FROM health";
			
			stmt = con.createStatement();
			
			//SQL ������ �����ϰ� ����� ����
			rs=stmt.executeQuery(selectdb); //��ȸ�� ����� rs�� ����
			
			//ResultSet�� ����� ������ ���-����� 2�� �̻�
			while(rs.next())
			{
				int num=rs.getInt("num");
				int meal=rs.getInt("meal");
				int sleep=rs.getInt("sleep");
				int water=rs.getInt("water");
				String modifyDate=rs.getString("date");
        			            	
				if(date.equals(modifyDate))
				{
					System.out.println("��¥: "+modifyDate);
					System.out.println("1. ���� �ð�: "+sleep);
					System.out.println("2. �Ϸ� ���� ���뷮(��): "+water);
					System.out.println("3. �Ϸ� �Ļ� ����(��): "+meal);
				}
				else
				{
					System.out.println("������ �������� �ʽ��ϴ�.");
				}
			}
			
			stmt.close();
	        con.close();
	        rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

}
