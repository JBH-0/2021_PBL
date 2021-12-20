package CheckList;

import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class checklist_main {

   public static void main(String[] args) {
	   Checklist_first(); 
   }
   
   public static void Checklist_first() {
		System.out.println("<건강관리 다이어리>");
		System.out.println("# 체크리스트");
		
		int function_menu=0;
	    Scanner sc = new Scanner(System.in);
	    HashMap<String, ArrayList<String>> listMap = new HashMap<String, ArrayList<String>>();
	    
		while (true) 
		{
	         System.out.println("1.삽입  2.수정  3.삭제  4.체크  5.체크 해제  6.출력  7.메인 메뉴 돌아가기");
	         System.out.println("원하는 기능을 숫자로 입력하세요!");
	         function_menu = sc.nextInt(); // choose menu
	         sc.nextLine();
	         
	         switch (function_menu) {
	         	case 1: //운동기록
	 	 			System.out.println("일정을 삽입할 날짜를 입력하세요.(ex.2020-01-01)");
	 	            String insertDate = sc.nextLine();
	 	            
	 	           if(CheckDate(insertDate)==false)
	 	           {
	        			System.out.println("존재하지 않는 날짜를 입력하였습니다. 올바른 날짜를 입력하세요!(ex.2020-01-01)");
	        			
	 	           }
	 	           else
	 	           {
	 	        	  if (!listMap.containsKey(insertDate)) 
		 	            {
		 	               // 기존의 일정이 없다면, 빈 Arraylist를 추가한다.
		 	               ArrayList<String> emptyList = new ArrayList<String>();
		 	               listMap.put(insertDate, emptyList);
		 	            }

		 	            System.out.println("삽입할 내용을 입력하세요.");
		 	            String list = sc.nextLine();

		 	            ArrayList<String> existList = listMap.get(insertDate);

		 	            existList.add(list);
		 	            listMap.put(insertDate, existList);
	 	           }
	 	           
	 	 			break;
			
	 	         case 2:
	 	            System.out.println("일정을 수정할 날짜를 입력하세요.(ex.2020-01-01)");
	 	            String modifyDate = sc.nextLine();
	 	
	 	            if (listMap.containsKey(modifyDate)) 
	 	            {
	 	               //해당 날짜에 일정이 있다면
	 	               ArrayList<String> schedule = listMap.get(modifyDate);
   
	 	               System.out.println("현재" +  modifyDate+ "에 등록되어 있는 일정입니다.");
	 	               for (int i = 0; i < schedule.size(); i++) 
	 	               {
	 	                  //일정 전체 출력
	 	                  System.out.printf("%d.%s\n", i + 1, schedule.get(i));
	 	               }

	 	               System.out.println("수정할 일정의 번호를 입력하세요.");
	 	               int modifyNum = sc.nextInt();
	 	               sc.nextLine();

	 	               if (modifyNum - 1 >= schedule.size()) 
	 	               {
	 	                  //일정이 존재하지 않다.
	 	                  System.out.println("잘 못 입력하셨습니다. 존재하는 일정을 선택하세요.");
	 	               } 
	 	               else 
	 	               {
	 	                  //일정이 존재한다.
	 	                  System.out.print("수정할 내용을 입력하세요.\n> ");
	 	                  String changeList = sc.nextLine();

	 	                  schedule.set(modifyNum - 1, changeList);
	 	                  System.out.println("정상적으로 일정이 수정되었습니다.");
	 	               }
	 	            }
	 	            else 
	 	            {
	 	               //해당 날짜에 일정이 없다면
	 	               System.out.println("해당 날짜에 일정이 존재하지 않습니다.");
	 	            }
	 	            
	 	            
	 	            break;

	 	         case 3:            
	 	            System.out.println("일정을 삭제할 날짜를 입력하세요.(ex.2020-01-01)");
	 	            String deleteDate = sc.nextLine();

	 	            if (listMap.containsKey(deleteDate)) 
	 	            {
	 	               //해당 날짜에 일정이 있다면
	 	               ArrayList<String> schedule = listMap.get(deleteDate);

	 	               System.out.println("현재" +  deleteDate+ "에 등록되어 있는 일정입니다.");
	 	               for (int i = 0; i < schedule.size(); i++) 
	 	               {
	 	                  //일정 전체 출력
	 	                  System.out.printf("%d.%s\n", i + 1, schedule.get(i));
	 	               }

	 	               System.out.println("삭제할 일정의 번호를 입력하세요.");
	 	               int deleteNum = sc.nextInt();
	 	               sc.nextLine();

	 	               if (deleteNum - 1 >= schedule.size()) 
	 	               {
	 	                  //일정이 존재하지 않다.
	 	                  System.out.println("잘 못 입력하셨습니다. 존재하는 일정을 선택하세요.");
	 	               }
	 	               else
	 	               {
	 	                  //일정이 존재한다.
	 	                  schedule.remove(schedule.get(deleteNum-1));
	 	                  System.out.println("정상적으로 일정이 삭제되었습니다.");
	 	               }
	 	            } 
	 	            else
	 	            {
	 	               // 해당 날짜에 일정이 없다면
	 	               System.out.println("해당 날짜에 일정이 존재하지 않습니다.");
	 	            }
	 	            break;
	 	            
	 	         case 4:            
	 	            System.out.println("체크할 날짜를 입력하세요.(ex.2020-01-01)");
	 	            String checkDate = sc.nextLine();

	 	            if (listMap.containsKey(checkDate)) 
	 	            {
	 	               //해당 날짜에 일정이 있다면
	 	               ArrayList<String> schedule = listMap.get(checkDate);

	 	               System.out.println("현재 " +  checkDate+ "에 등록되어 있는 일정입니다.");
	 	               for (int i = 0; i < schedule.size(); i++) 
	 	               {
	 	                  //일정 전체 출력
	 	                  System.out.printf("%d.%s\n", i + 1, schedule.get(i));
	 	               }

	 	               System.out.println("체크할 일정의 번호를 입력하세요.");
	 	               int checkNum = sc.nextInt();
	 	               sc.nextLine();

	 	               if (checkNum - 1 >= schedule.size()) 
	 	               {
	 	                  //일정이 존재하지 않다.
	 	                  System.out.println("잘 못 입력하셨습니다. 존재하는 일정을 선택하세요.");
	 	               }
	 	               else
	 	               {
	 	                  //일정이 존재한다.
	 	                  schedule.set(checkNum - 1, schedule.get(checkNum-1)+"\t---o");
	 	                  System.out.println("정상적으로 일정이 체크되었습니다.");
	 	               }
	 	            } 
	 	            else
	 	            {
	 	               // 해당 날짜에 일정이 없다면
	 	               System.out.println("해당 날짜에 일정이 존재하지 않습니다.");
	 	            }
	 	            break;
	 	            
	 	         case 5:            
	 	            System.out.println("체크 해제할 날짜를 입력하세요.(ex.2020-01-01)");
	 	            String checkDelDate = sc.nextLine();

	 	            if (listMap.containsKey(checkDelDate)) 
	 	            {
	 	               //해당 날짜에 일정이 있다면
	 	               ArrayList<String> schedule = listMap.get(checkDelDate);

	 	               System.out.println("현재 " +  checkDelDate + "에 등록되어 있는 일정입니다.");
	 	               for (int i = 0; i < schedule.size(); i++) 
	 	               {
	 	                  //일정 전체 출력
	 	                  System.out.printf("%d.%s\n", i + 1, schedule.get(i));
	 	               }

	 	               System.out.println("체크 해제할 일정의 번호를 입력하세요.");
	 	               int checkDelNum = sc.nextInt();
	 	               sc.nextLine();

	 	               if (checkDelNum - 1 >= schedule.size()) 
	 	               {
	 	                  //일정이 존재하지 않다.
	 	                  System.out.println("잘 못 입력하셨습니다. 존재하는 일정을 선택하세요.");
	 	               }
	 	               else
	 	               {
	 	                  //일정이 존재한다.
	 	                  String checkDelList = schedule.get(checkDelNum-1).replace("\t---o","");

	 	                  schedule.set(checkDelNum - 1, checkDelList);
	 	                  System.out.println("정상적으로 일정이 체크 해제되었습니다.");
	 	               }
	 	            } 
	 	            else
	 	            {
	 	               // 해당 날짜에 일정이 없다면
	 	               System.out.println("해당 날짜에 일정이 존재하지 않습니다.");
	 	            }
	 	            break;

	 	         case 6:
	 	            System.out.println("일정을 출력할 날짜를 입력하세요.(ex.2020-01-01)");
	 	            String printDate = sc.nextLine();
	 	            
	 	            if (listMap.containsKey(printDate)) 
	 	            {
	 	               //해당 날짜에 일정이 있다면
	 	               ArrayList<String> schedule = listMap.get(printDate);

	 	               System.out.println("현재" +  printDate+ "에 등록되어 있는 일정입니다.");
	 	               for (int i = 0; i < schedule.size(); i++) 
	 	               {
	 	                  //일정 전체 출력
	 	                  System.out.printf("%d.%s\n", i + 1, schedule.get(i));
	 	               }
	 	            }
	 	            else
	 	            {
	 	               // 해당 날짜에 일정이 없다면
	 	               System.out.println("해당 날짜에 일정이 존재하지 않습니다.");
	 	            }
	 	            break;
	 	            
	 	         case 7:
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

}