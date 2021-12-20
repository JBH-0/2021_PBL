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
         
         List<Integer[]> list = new ArrayList<Integer[]>();
         
         int sleepsum=0;
         int watersum=0;
         int mealsum=0;
         
         int sleepavg=0;
         int wateravg=0;
         int mealavg=0;
        		 
         
         //ResultSet에 저장된 데이터 얻기-결과가 2개 이상
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
         
         System.out.println("일주일 간의 수면 시간 평균은 "+sleepavg+", 수분 섭취량 평균은 "+wateravg+", 식사 평균은 "+mealavg+"입니다");
         if(sleepavg<7) System.out.println("권장 수면 시간은 7~8시간입니다. 다음에는 권장 수면 시간을 채워보세요!");
         if(wateravg<8) System.out.println("권장 수분 섭취량은 최소 8잔입니다. 다음에는 권장 수분 섭취량을 채워보세요!");
         if(mealavg<3) System.out.println("다음에는 3끼를 채워보세요!");
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