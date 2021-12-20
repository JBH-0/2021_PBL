package Health;

import java.util.*;
import java.sql.*;
import java.text.*;
import java.io.*;

public class health_analysis {
   String driver = "com.mysql.cj.jdbc.Driver";
   String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
   String user = "root";
   String pass = "Wjdqhgus929!";   
   
   public void analysis(String date)
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
         
         List<Integer[]> list = new ArrayList<Integer[]>();
         
         int sleepsum=0;
         int watersum=0;
         int mealsum=0;
         
         int sleepavg=0;
         int wateravg=0;
         int mealavg=0;
        		 
         
         //ResultSet�� ����� ������ ���-����� 2�� �̻�
         while(rs.next())
         {
            
        	int num=rs.getInt("num");
            int sleep=rs.getInt("sleep");
            int water=rs.getInt("water");
            int meal=rs.getInt("meal");
            String modifyDate=rs.getString("date");
            
            Integer[] map = {sleep, water, meal};
            list.add(map);
         }
         
         if(list.size()>8)
         {
        	 for(int i = 0; i < 7; i++)
             {
        		 //System.out.println(list.get(i)[0]);
         	     sleepsum = sleepsum+list.get(i)[0];
         	     watersum = watersum+list.get(i)[1];
         	     mealsum = mealsum+list.get(i)[2];

             }
        	 sleepavg=sleepsum/7;
        	 wateravg=watersum/7;
        	 mealavg=mealsum/7;
        	 System.out.print(sleepavg);
         }
         else
         {
        	 for(int i = 0; i < list.size(); i++)
             {
        		 //System.out.println(list.get(i)[0]);
        		 sleepsum = sleepsum+list.get(i)[0];
        		 watersum = watersum+list.get(i)[1];
        		 mealsum = mealsum+list.get(i)[2];
             }
        	 sleepavg=sleepsum/list.size();
        	 wateravg=watersum/list.size();
        	 mealavg=mealsum/list.size();
         }
         
         System.out.println("������ ���� ���� �ð� ����� "+sleepavg+", ���� ���뷮 ����� "+wateravg+", �Ļ� ����� "+mealavg+"�Դϴ�");
         if(sleepavg<7) System.out.println("���� ���� �ð��� 7~8�ð��Դϴ�. �������� ���� ���� �ð��� ä��������!");
         if(wateravg<8) System.out.println("���� ���� ���뷮�� �ּ� 8���Դϴ�. �������� ���� ���� ���뷮�� ä��������!");
         if(mealavg<3) System.out.println("�������� 3���� ä��������!");
         System.out.println();

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