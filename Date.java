package Exercise;

import java.util.Scanner;
import java.io.*;

public class Date {
	public static String Ex_Pdate(int a, int b, int c) {
		String date_sentence = "��¥ : "+a+"."+b+"."+c;
		System.out.println(date_sentence); //��¥ ���
		return date_sentence;
	}
	
	public static void Ex_Date() {
		int year = 0;
		int month=0;
		int day=0;
		String time;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("����ϴ� ���� �Է����ּ���");
		year = sc.nextInt();
		System.out.println("���� �Է����ּ���");
		month= sc.nextInt();
		System.out.println("���� �Է����ּ���");
		day= sc.nextInt();
		System.out.println("����/���ĸ� �Է����ּ���");
		time= sc.next();
		
		String date_sentence = "��¥ : "+year+"."+month+"."+day+"   �ð� : "+time;
		System.out.println(date_sentence);
		
		if (year < 2020 || year > 2050) {
			System.out.println("�⵵�� �ٽ��Է����ּ��� 2020~2050�� ���̷� �Է����ּ���");
			
		}
		
		switch (month) {
		case 2: 
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
               if (day>=30) {
                  System.out.println("1�ش� ���� �ִ� ��¥���� Ů�ϴ� �ٽ� �Է��ϼ���");
                  System.out.flush();
                  Ex_Date();
               }
               
               Ex_Date();
            }
            break;
            
         case 1: case 3: case 5: case 7: case 8: case 10: case 12: 
            if (day>=32) {
               System.out.println("2�ش� ���� �ִ� ��¥���� Ů�ϴ� �ٽ� �Է��ϼ���");
               //12�� if�� ���� �ȵ�
               System.out.flush();
               Ex_Date();
            }
            break;
            
         case 4: case 6: case 9: case 11: 
            if (day>=31) {
               System.out.println("3�ش� ���� �ִ� ��¥���� Ů�ϴ� �ٽ� �Է��ϼ���");
               System.out.flush();
               Ex_Date();
            }
            break;
         default : 
			System.out.println("�Է¹���� Ʋ�Ƚ��ϴ�. ���� 1~12�� �Է� �����մϴ�.");
			Ex_Date();
			break;
		}	
		
		if (year <=0 || month<=0 || day <=0) {
			System.out.println("0�̰ų� ������ �Է��Ͻø�ȵ˴ϴ�.");
			System.out.flush();
			Ex_Date();
			
		}
		/*
		if(time !="����" || time != "����") { System.out.println(time);
			System.out.println("������ �����߿� ����ּ���"); 
			Ex_Date();
		}*/
		
		
		
		
	}
	public static void main(String[] args) {
		Ex_Date();
	}
}
