package Exercise;

import java.util.Scanner;
import java.io.*;

public class Date {
	public static String Ex_Pdate(int a, int b, int c) {
		String date_sentence = "날짜 : "+a+"."+b+"."+c;
		System.out.println(date_sentence); //날짜 출력
		return date_sentence;
	}
	
	public static void Ex_Date() {
		int year = 0;
		int month=0;
		int day=0;
		String time;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("기록하는 년을 입력해주세요");
		year = sc.nextInt();
		System.out.println("달을 입력해주세요");
		month= sc.nextInt();
		System.out.println("일을 입력해주세요");
		day= sc.nextInt();
		System.out.println("오전/오후를 입력해주세요");
		time= sc.next();
		
		String date_sentence = "날짜 : "+year+"."+month+"."+day+"   시간 : "+time;
		System.out.println(date_sentence);
		
		if (year < 2020 || year > 2050) {
			System.out.println("년도를 다시입력해주세요 2020~2050년 사이로 입력해주세요");
			
		}
		
		switch (month) {
		case 2: 
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
               if (day>=30) {
                  System.out.println("1해당 달의 최대 날짜보다 큽니다 다시 입력하세요");
                  System.out.flush();
                  Ex_Date();
               }
               
               Ex_Date();
            }
            break;
            
         case 1: case 3: case 5: case 7: case 8: case 10: case 12: 
            if (day>=32) {
               System.out.println("2해당 달의 최대 날짜보다 큽니다 다시 입력하세요");
               //12월 if절 실행 안됨
               System.out.flush();
               Ex_Date();
            }
            break;
            
         case 4: case 6: case 9: case 11: 
            if (day>=31) {
               System.out.println("3해당 달의 최대 날짜보다 큽니다 다시 입력하세요");
               System.out.flush();
               Ex_Date();
            }
            break;
         default : 
			System.out.println("입력방식이 틀렸습니다. 달은 1~12만 입력 가능합니다.");
			Ex_Date();
			break;
		}	
		
		if (year <=0 || month<=0 || day <=0) {
			System.out.println("0이거나 음수는 입력하시면안됩니다.");
			System.out.flush();
			Ex_Date();
			
		}
		/*
		if(time !="오전" || time != "오후") { System.out.println(time);
			System.out.println("오전과 오후중에 골라주세요"); 
			Ex_Date();
		}*/
		
		
		
		
	}
	public static void main(String[] args) {
		Ex_Date();
	}
}
