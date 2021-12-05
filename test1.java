/*
import java.sql.*;
 
public class test1{
    public static void main(String args[]){
        Connection con = null; //�����ͺ��̽��� ������ ���� ��ü
        PreparedStatement pstmt=null; //SQL���� �����ͺ��̽��� ���������� ��ü
        
        String SQL = "insert into advice(number, advice) values(?, ?)";

        try{
            //JDBC ����̹� �ε�-MySQL JDBC ����̹��� Driver Class �ε�
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	//Connection ���� - getConnection(���Ṯ�ڿ�, DB-ID, DB-PW)
            con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test?serverTimezone=UTC", // DB URL
                    "root", "Wjdqhgus929!");  // USER_NAME�� PASSWORD
            System.out.println("Success");
            
            //PreParedStatement ��ü ����, ��ü ������ SQL ���� ����
            pstmt=con.prepareStatement(SQL);
            //pstmt.set<������Ÿ��>(? ����, ��) ex) .setString(), .setInt
            pstmt.setInt(1, 1);
            pstmt.setString(2, "������ ��ƾ�� ������");
            pstmt.setInt(1, 2);
            pstmt.setString(2, "���� �ڶ�");
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