package CheckList;

import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class checklist_main {

   public static void main(String[] args) {
	   Checklist_first(); 
   }
   
   public static void Checklist_first() {
		System.out.println("<�ǰ����� ���̾>");
		System.out.println("# üũ����Ʈ");
		
		int function_menu=0;
	    Scanner sc = new Scanner(System.in);
	    HashMap<String, ArrayList<String>> listMap = new HashMap<String, ArrayList<String>>();
	    
		while (true) 
		{
	         System.out.println("1.����  2.����  3.����  4.üũ  5.üũ ����  6.���  7.���� �޴� ���ư���");
	         System.out.println("���ϴ� ����� ���ڷ� �Է��ϼ���!");
	         function_menu = sc.nextInt(); // choose menu
	         sc.nextLine();
	         
	         switch (function_menu) {
	         	case 1: //����
	 	 			System.out.println("������ ������ ��¥�� �Է��ϼ���.(ex.2020-01-01)");
	 	            String insertDate = sc.nextLine();
	 	            
	 	           if(CheckDate(insertDate)==false)
	 	           {
	        			System.out.println("�������� �ʴ� ��¥�� �Է��Ͽ����ϴ�. �ùٸ� ��¥�� �Է��ϼ���!(ex.2020-01-01)");
	        			
	 	           }
	 	           else
	 	           {
	 	        	  if (!listMap.containsKey(insertDate)) 
		 	            {
		 	               // ������ ������ ���ٸ�, �� Arraylist�� �߰��Ѵ�.
		 	               ArrayList<String> emptyList = new ArrayList<String>();
		 	               listMap.put(insertDate, emptyList);
		 	            }

		 	            System.out.println("������ ������ �Է��ϼ���.");
		 	            String list = sc.nextLine();

		 	            ArrayList<String> existList = listMap.get(insertDate);

		 	            existList.add(list);
		 	            listMap.put(insertDate, existList);
	 	           }
	 	           
	 	 			break;
			
	 	         case 2:
	 	            System.out.println("������ ������ ��¥�� �Է��ϼ���.(ex.2020-01-01)");
	 	            String modifyDate = sc.nextLine();
	 	
	 	            if (listMap.containsKey(modifyDate)) 
	 	            {
	 	               //�ش� ��¥�� ������ �ִٸ�
	 	               ArrayList<String> schedule = listMap.get(modifyDate);
   
	 	               System.out.println("����" +  modifyDate+ "�� ��ϵǾ� �ִ� �����Դϴ�.");
	 	               for (int i = 0; i < schedule.size(); i++) 
	 	               {
	 	                  //���� ��ü ���
	 	                  System.out.printf("%d.%s\n", i + 1, schedule.get(i));
	 	               }

	 	               System.out.println("������ ������ ��ȣ�� �Է��ϼ���.");
	 	               int modifyNum = sc.nextInt();
	 	               sc.nextLine();

	 	               if (modifyNum - 1 >= schedule.size()) 
	 	               {
	 	                  //������ �������� �ʴ�.
	 	                  System.out.println("�� �� �Է��ϼ̽��ϴ�. �����ϴ� ������ �����ϼ���.");
	 	               } 
	 	               else 
	 	               {
	 	                  //������ �����Ѵ�.
	 	                  System.out.print("������ ������ �Է��ϼ���.\n> ");
	 	                  String changeList = sc.nextLine();

	 	                  schedule.set(modifyNum - 1, changeList);
	 	                  System.out.println("���������� ������ �����Ǿ����ϴ�.");
	 	               }
	 	            }
	 	            else 
	 	            {
	 	               //�ش� ��¥�� ������ ���ٸ�
	 	               System.out.println("�ش� ��¥�� ������ �������� �ʽ��ϴ�.");
	 	            }
	 	            
	 	            
	 	            break;

	 	         case 3:            
	 	            System.out.println("������ ������ ��¥�� �Է��ϼ���.(ex.2020-01-01)");
	 	            String deleteDate = sc.nextLine();

	 	            if (listMap.containsKey(deleteDate)) 
	 	            {
	 	               //�ش� ��¥�� ������ �ִٸ�
	 	               ArrayList<String> schedule = listMap.get(deleteDate);

	 	               System.out.println("����" +  deleteDate+ "�� ��ϵǾ� �ִ� �����Դϴ�.");
	 	               for (int i = 0; i < schedule.size(); i++) 
	 	               {
	 	                  //���� ��ü ���
	 	                  System.out.printf("%d.%s\n", i + 1, schedule.get(i));
	 	               }

	 	               System.out.println("������ ������ ��ȣ�� �Է��ϼ���.");
	 	               int deleteNum = sc.nextInt();
	 	               sc.nextLine();

	 	               if (deleteNum - 1 >= schedule.size()) 
	 	               {
	 	                  //������ �������� �ʴ�.
	 	                  System.out.println("�� �� �Է��ϼ̽��ϴ�. �����ϴ� ������ �����ϼ���.");
	 	               }
	 	               else
	 	               {
	 	                  //������ �����Ѵ�.
	 	                  schedule.remove(schedule.get(deleteNum-1));
	 	                  System.out.println("���������� ������ �����Ǿ����ϴ�.");
	 	               }
	 	            } 
	 	            else
	 	            {
	 	               // �ش� ��¥�� ������ ���ٸ�
	 	               System.out.println("�ش� ��¥�� ������ �������� �ʽ��ϴ�.");
	 	            }
	 	            break;
	 	            
	 	         case 4:            
	 	            System.out.println("üũ�� ��¥�� �Է��ϼ���.(ex.2020-01-01)");
	 	            String checkDate = sc.nextLine();

	 	            if (listMap.containsKey(checkDate)) 
	 	            {
	 	               //�ش� ��¥�� ������ �ִٸ�
	 	               ArrayList<String> schedule = listMap.get(checkDate);

	 	               System.out.println("���� " +  checkDate+ "�� ��ϵǾ� �ִ� �����Դϴ�.");
	 	               for (int i = 0; i < schedule.size(); i++) 
	 	               {
	 	                  //���� ��ü ���
	 	                  System.out.printf("%d.%s\n", i + 1, schedule.get(i));
	 	               }

	 	               System.out.println("üũ�� ������ ��ȣ�� �Է��ϼ���.");
	 	               int checkNum = sc.nextInt();
	 	               sc.nextLine();

	 	               if (checkNum - 1 >= schedule.size()) 
	 	               {
	 	                  //������ �������� �ʴ�.
	 	                  System.out.println("�� �� �Է��ϼ̽��ϴ�. �����ϴ� ������ �����ϼ���.");
	 	               }
	 	               else
	 	               {
	 	                  //������ �����Ѵ�.
	 	                  schedule.set(checkNum - 1, schedule.get(checkNum-1)+"\t---o");
	 	                  System.out.println("���������� ������ üũ�Ǿ����ϴ�.");
	 	               }
	 	            } 
	 	            else
	 	            {
	 	               // �ش� ��¥�� ������ ���ٸ�
	 	               System.out.println("�ش� ��¥�� ������ �������� �ʽ��ϴ�.");
	 	            }
	 	            break;
	 	            
	 	         case 5:            
	 	            System.out.println("üũ ������ ��¥�� �Է��ϼ���.(ex.2020-01-01)");
	 	            String checkDelDate = sc.nextLine();

	 	            if (listMap.containsKey(checkDelDate)) 
	 	            {
	 	               //�ش� ��¥�� ������ �ִٸ�
	 	               ArrayList<String> schedule = listMap.get(checkDelDate);

	 	               System.out.println("���� " +  checkDelDate + "�� ��ϵǾ� �ִ� �����Դϴ�.");
	 	               for (int i = 0; i < schedule.size(); i++) 
	 	               {
	 	                  //���� ��ü ���
	 	                  System.out.printf("%d.%s\n", i + 1, schedule.get(i));
	 	               }

	 	               System.out.println("üũ ������ ������ ��ȣ�� �Է��ϼ���.");
	 	               int checkDelNum = sc.nextInt();
	 	               sc.nextLine();

	 	               if (checkDelNum - 1 >= schedule.size()) 
	 	               {
	 	                  //������ �������� �ʴ�.
	 	                  System.out.println("�� �� �Է��ϼ̽��ϴ�. �����ϴ� ������ �����ϼ���.");
	 	               }
	 	               else
	 	               {
	 	                  //������ �����Ѵ�.
	 	                  String checkDelList = schedule.get(checkDelNum-1).replace("\t---o","");

	 	                  schedule.set(checkDelNum - 1, checkDelList);
	 	                  System.out.println("���������� ������ üũ �����Ǿ����ϴ�.");
	 	               }
	 	            } 
	 	            else
	 	            {
	 	               // �ش� ��¥�� ������ ���ٸ�
	 	               System.out.println("�ش� ��¥�� ������ �������� �ʽ��ϴ�.");
	 	            }
	 	            break;

	 	         case 6:
	 	            System.out.println("������ ����� ��¥�� �Է��ϼ���.(ex.2020-01-01)");
	 	            String printDate = sc.nextLine();
	 	            
	 	            if (listMap.containsKey(printDate)) 
	 	            {
	 	               //�ش� ��¥�� ������ �ִٸ�
	 	               ArrayList<String> schedule = listMap.get(printDate);

	 	               System.out.println("����" +  printDate+ "�� ��ϵǾ� �ִ� �����Դϴ�.");
	 	               for (int i = 0; i < schedule.size(); i++) 
	 	               {
	 	                  //���� ��ü ���
	 	                  System.out.printf("%d.%s\n", i + 1, schedule.get(i));
	 	               }
	 	            }
	 	            else
	 	            {
	 	               // �ش� ��¥�� ������ ���ٸ�
	 	               System.out.println("�ش� ��¥�� ������ �������� �ʽ��ϴ�.");
	 	            }
	 	            break;
	 	            
	 	         case 7:
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

}