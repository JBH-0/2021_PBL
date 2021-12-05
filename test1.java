/*
import java.sql.*;
 
public class test1{
    public static void main(String args[]){
        Connection con = null; //데이터베이스와 연결을 위한 객체
        PreparedStatement pstmt=null; //SQL문을 데이터베이스에 보내기위한 객체
        
        String SQL = "insert into advice(number, advice) values(?, ?)";

        try{
            //JDBC 드라이버 로딩-MySQL JDBC 드라이버의 Driver Class 로딩
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	//Connection 생성 - getConnection(연결문자열, DB-ID, DB-PW)
            con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test?serverTimezone=UTC", // DB URL
                    "root", "Wjdqhgus929!");  // USER_NAME과 PASSWORD
            System.out.println("Success");
            
            //PreParedStatement 객체 생성, 객체 생성시 SQL 문장 저장
            pstmt=con.prepareStatement(SQL);
            //pstmt.set<데이터타입>(? 순서, 값) ex) .setString(), .setInt
            pstmt.setInt(1, 1);
            pstmt.setString(2, "나만의 루틴을 가져라");
            pstmt.setInt(1, 2);
            pstmt.setString(2, "잠을 자라");
            pstmt.executeUpdate();
            pstmt.close();
            
        }
        catch(SQLException ex){ 
            System.out.println("SQLException" + ex);
            ex.printStackTrace();
        }
        catch(Exception ex){ 
            System.out.println("Exception:" + ex);
            ex.printStackTrace();
        }
        finally {
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
*/