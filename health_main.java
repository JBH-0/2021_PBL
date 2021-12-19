package Health;

import java.util.*;
import java.sql.*;
import java.text.*;
import java.io.*;

public class health_main {

	public static void main(String[] args) {
		health_first();
	}
	
	public static void health_first() {
		System.out.println("<건강관리 다이어리>");
		System.out.println("# 건강 기록");
		
		int function_menu=0;
	    Scanner sc = new Scanner(System.in);
	    
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    health_insert insert = new health_insert();
	    health_update update = new health_update();
	    health_update select = new health_update();
	    health_analysis analysis = new health_analysis();

	    while (true) 
	    {
			System.out.println("1.삽입  2.수정  3.분석하기  4.메인 메뉴 돌아가기");
	        System.out.println("원하는 기능을 숫자로 입력하세요!");
	        function_menu = sc.nextInt(); // choose menu
	        sc.nextLine();
	        
	        String date;
	        int num=1, sleep, water, meal;
	        
	        switch (function_menu) 
	        {
	        	case 1:	                
	                System.out.println("건강 정보를 삽입할 날짜를 입력하세요.(ex.2020-01-01)");
	        		date = sc.nextLine();
	        		
	        		if(CheckDate(date)==false)
	        		{
	        			System.out.println("존재하지 않는 날짜를 입력하였습니다. 올바른 날짜를 입력하세요!(ex.2020-01-01)");
	        		}
	        		else
	        		{
	        			System.out.println("수면시간을 입력해주세요");
	            	    sleep = sc.nextInt();
	            	    System.out.println("하루 수분 섭취량(잔)을 입력해주세요");
	            	    water = sc.nextInt();
	            	    System.out.println("하루 식사 여부(끼니)를 입력해주세요");
	            	    meal = sc.nextInt();
	            	    num++;
	            	    
	            	    insert.insert(num, date, sleep, water, meal);
	            	    System.out.println("저장 완료했습니다!");
	        		}
	        		break;

		         case 2: 	 
		        	System.out.println("건강 정보를 수정할 날짜를 입력하세요.(ex.2020-01-01)");
		            date = sc.nextLine();
		            
		            if(CheckDate(date)==false)
	        		{
	        			System.out.println("존재하지 않는 날짜를 입력하였습니다. 올바른 날짜를 입력하세요!(ex.2020-01-01)");
	        		}
		            else
	        		{
		            	select.select(date);
		            	System.out.println("--------------------");
		            	
		            	System.out.println("수정할 수면시간을 입력해주세요");
	            	    sleep = sc.nextInt();
	            	    System.out.println("수정할 하루 수분 섭취량(잔)을 입력해주세요");
	            	    water = sc.nextInt();
	            	    System.out.println("수정할 하루 식사 여부(끼니)를 입력해주세요");
	            	    meal = sc.nextInt();
	            	    num++;
	            	    
	            	    update.update(num, date, sleep, water, meal);
	            	    System.out.println("수정 완료했습니다!");
	        		}
		            
		            
		            break;
	
		         case 3:     
		            System.out.println("분석");
		            
		            String todayDate = sdf.format(Calendar.getInstance().getTime());
	            	System.out.println(todayDate);
	            	analysis.analysis(todayDate);
		            break;

		            
		         case 4:            
		            System.out.println("메인 메뉴로 돌아갑니다.");
		            Menu.Menu.menu();
		            break;
		               
		         default:
		            System.out.println("잘 못 입력하셨습니다. 다시 선택해주세요.");
		            
	        }
	        
	    }
	}
	
	public static boolean CheckDate(String checkDate){
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        dateFormat.setLenient(false);
        try
        {
        	dateFormat.parse(checkDate);
	        return  true;
        } 
        catch (Exception ex)
        {
        	return false;
        }
	}
	
	public static void printdb()
	{
		for (int i = 0; i < 50; ++i) System.out.println();
	}

}
