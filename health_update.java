package Health;


import java.sql.*;


public class health_update {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
	String user = "root";
	String pass = "Wjdqhgus929!";	
	public void update(int num, String date, int sleep, int water, int meal)
	{
		Connection con = null; //데이터베이스와 연결을 위한 객체
		PreparedStatement pstmt=null; //SQL문을 데이터베이스에 보내기위한 객체
		
		try
		{
			//JDBC 드라이버 로딩-MySQL JDBC 드라이버의 Driver Class 로딩
	    	Class.forName(driver);
	    	con=DriverManager.getConnection(url, user, pass);
	    	String updatedb = "update health set num=?, sleep=?, water=?, meal=? where date=?";
	    	
	    	//PreParedStatement 객체 생성, 객체 생성시 SQL 문장 저장
	        pstmt=con.prepareStatement(updatedb);
	        
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
	
	public void select(String date)
	{
		Connection con = null; //데이터베이스와 연결을 위한 객체
		Statement stmt=null;
		ResultSet rs=null; //SQL 질의에 의해 생성된 테이블을 저장하는 객체
		
		
		try
		{
			Class.forName(driver);
	    	con=DriverManager.getConnection(url, user, pass);
	    	
			String selectdb = "SELECT * FROM health";
			
			stmt = con.createStatement();
			
			//SQL 문장을 실행하고 결과를 리턴
			rs=stmt.executeQuery(selectdb); //조회한 결과를 rs에 저장
			
			//ResultSet에 저장된 데이터 얻기-결과가 2개 이상
			while(rs.next())
			{
				int num=rs.getInt("num");
				int meal=rs.getInt("meal");
				int sleep=rs.getInt("sleep");
				int water=rs.getInt("water");
				String modifyDate=rs.getString("date");
        			            	
				if(date.equals(modifyDate))
				{
					System.out.println("날짜: "+modifyDate);
					System.out.println("1. 수면 시간: "+sleep);
					System.out.println("2. 하루 수분 섭취량(잔): "+water);
					System.out.println("3. 하루 식사 여부(끼): "+meal);
				}
				else
				{
					System.out.println("내용이 존재하지 않습니다.");
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
