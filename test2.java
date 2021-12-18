
import java.sql.*;
 
public class test2{
    public static void main(String args[]){
        Connection con = null; //�����ͺ��̽��� ������ ���� ��ü
        Statement pstmt=null; //SQL���� �����ͺ��̽��� ���������� ��ü
        ResultSet rs=null; //SQL ���ǿ� ���� ������ ���̺��� �����ϴ� ��ü
        
        String SQL = "SELECT * FROM advice";

        try{
            //JDBC ����̹� �ε�-MySQL JDBC ����̹��� Driver Class �ε�
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	//Connection ���� - getConnection(���Ṯ�ڿ�, DB-ID, DB-PW), DB����
            con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test?serverTimezone=UTC", // DB URL
                    "root", "Wjdqhgus929!");  // USER_NAME�� PASSWORD
            System.out.println("Success");
            
            //PreParedStatement ��ü ����, ��ü ������ SQL ���� ����
            pstmt = con.createStatement();
            
            
            //SQL ������ �����ϰ� ����� ����
            rs=pstmt.executeQuery(SQL); //��ȸ�� ����� rs�� ����
            
            //ResultSet�� ����� ������ ���-����� 2�� �̻�
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
