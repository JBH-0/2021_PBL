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
		System.out.println("<�ǰ����� ���̾>");
		System.out.println("# �ǰ� ���");
		
		int function_menu=0;
	    Scanner sc = new Scanner(System.in);
	    
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    health_insert insert = new health_insert();
	    health_update update = new health_update();
	    health_update select = new health_update();
	    health_analysis analysis = new health_analysis();

	    while (true) 
	    {
			System.out.println("1.����  2.����  3.�м��ϱ�  4.���� �޴� ���ư���");
	        System.out.println("���ϴ� ����� ���ڷ� �Է��ϼ���!");
	        function_menu = sc.nextInt(); // choose menu
	        sc.nextLine();
	        
	        String date;
	        int num=1, sleep, water, meal;
	        
	        switch (function_menu) 
	        {
	        	case 1:	                
	                System.out.println("�ǰ� ������ ������ ��¥�� �Է��ϼ���.(ex.2020-01-01)");
	        		date = sc.nextLine();
	        		
	        		if(CheckDate(date)==false)
	        		{
	        			System.out.println("�������� �ʴ� ��¥�� �Է��Ͽ����ϴ�. �ùٸ� ��¥�� �Է��ϼ���!(ex.2020-01-01)");
	        		}
	        		else
	        		{
	        			System.out.println("����ð��� �Է����ּ���");
	            	    sleep = sc.nextInt();
	            	    System.out.println("�Ϸ� ���� ���뷮(��)�� �Է����ּ���");
	            	    water = sc.nextInt();
	            	    System.out.println("�Ϸ� �Ļ� ����(����)�� �Է����ּ���");
	            	    meal = sc.nextInt();
	            	    num++;
	            	    
	            	    insert.insert(num, date, sleep, water, meal);
	            	    System.out.println("���� �Ϸ��߽��ϴ�!");
	        		}
	        		break;

		         case 2: 	 
		        	System.out.println("�ǰ� ������ ������ ��¥�� �Է��ϼ���.(ex.2020-01-01)");
		            date = sc.nextLine();
		            
		            if(CheckDate(date)==false)
	        		{
	        			System.out.println("�������� �ʴ� ��¥�� �Է��Ͽ����ϴ�. �ùٸ� ��¥�� �Է��ϼ���!(ex.2020-01-01)");
	        		}
		            else
	        		{
		            	select.select(date);
		            	System.out.println("--------------------");
		            	
		            	System.out.println("������ ����ð��� �Է����ּ���");
	            	    sleep = sc.nextInt();
	            	    System.out.println("������ �Ϸ� ���� ���뷮(��)�� �Է����ּ���");
	            	    water = sc.nextInt();
	            	    System.out.println("������ �Ϸ� �Ļ� ����(����)�� �Է����ּ���");
	            	    meal = sc.nextInt();
	            	    num++;
	            	    
	            	    update.update(num, date, sleep, water, meal);
	            	    System.out.println("���� �Ϸ��߽��ϴ�!");
	        		}
		            
		            
		            break;
	
		         case 3:     
		            System.out.println("�м�");
		            
		            String todayDate = sdf.format(Calendar.getInstance().getTime());
	            	System.out.println(todayDate);
	            	analysis.analysis(todayDate);
		            break;

		            
		         case 4:            
		            System.out.println("���� �޴��� ���ư��ϴ�.");
		            Menu.Menu.menu();
		            break;
		               
		         default:
		            System.out.println("�� �� �Է��ϼ̽��ϴ�. �ٽ� �������ּ���.");
		            
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
