
import java.sql.*;
 
public class test2{
    public static void main(String args[]){
        Connection con = null; //데이터베이스와 연결을 위한 객체
        Statement pstmt=null; //SQL문을 데이터베이스에 보내기위한 객체
        ResultSet rs=null; //SQL 질의에 의해 생성된 테이블을 저장하는 객체
        
        String SQL = "SELECT * FROM advice";

        try{
            //JDBC 드라이버 로딩-MySQL JDBC 드라이버의 Driver Class 로딩
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	//Connection 생성 - getConnection(연결문자열, DB-ID, DB-PW), DB연결
            con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test?serverTimezone=UTC", // DB URL
                    "root", "Wjdqhgus929!");  // USER_NAME과 PASSWORD
            System.out.println("Success");
            
            //PreParedStatement 객체 생성, 객체 생성시 SQL 문장 저장
            pstmt = con.createStatement();
            
            
            //SQL 문장을 실행하고 결과를 리턴
            rs=pstmt.executeQuery(SQL); //조회한 결과를 rs에 저장
            
            //ResultSet에 저장된 데이터 얻기-결과가 2개 이상
            while(rs.next())
            {
            	int number=rs.getInt("number");
            	String advice=rs.getString("advice");
            	
            	System.out.println(number+". "+advice);
            }
            

        }
        catch(SQLException ex){ 
            System.out.println("SQLException" + ex);

        }
        catch(Exception ex){ 
            System.out.println("Exception:" + ex);
  
        }
        finally {
        	if(rs!=null)
        	{
        		try
        		{
        			rs.close();
        		}
        		catch(SQLException e)
        		{
        			e.printStackTrace();
        		}
        	}
        	if(pstmt!=null)
        	{
        		try
        		{
        			pstmt.close();
        		}
        		catch(SQLException e)
        		{
        			e.printStackTrace();
        		}
        	}
        	if(con!=null)
        	{
        		try
        		{
        			con.close();
        		}
        		catch(SQLException e)
        		{
        			e.printStackTrace();
        		}
        	}
        }
    }
}
