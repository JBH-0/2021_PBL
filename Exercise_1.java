package Exercise;

import Exercise.*;
import java.sql.*;
import Menu.Menu;

import java.util.*;
public class Exercise_1 {
	public static void main(String[] args) {
		Date.Ex_Date();
		exercise_first();
	}
	
	
	public static void exercise_first() {
		System.out.println("<�ǰ����� ���̾>");
		System.out.println("# ����");
		//Ex_Pdate �߰� �ϰų� listmap
		int function_menu=0;
		System.out.println("� ��� �ϼ̽��ϱ�? ");
		System.out.println("1. �ٷ� �� ��������   2. ����������   3.������   4.���߾��");
		Scanner sc = new Scanner(System.in);
		function_menu = sc.nextInt();
		switch (function_menu) {
			case 1: //����
				exercise_muscluar();
				break;
			
			case 2:
				exercise_cardio();
				break;
			case 3:
				exercise_flex();
				break;
			case 4:
				DoNotExercise();
				break;
				
			
		}
	}
	
	
	
	public static void exercise_muscluar()  { //�ٷ� �� �������� 
		System.out.println("<�ǰ����� ���̾>");
		System.out.println("# ����");
		//Ex_Pdate �߰� �ϰų� listmap
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�ٷ� �� ��������");
		System.out.println("������ ������ �̰� ���� ���� �ִ����� ������� �����ϴ� �ɷ��Դϴ�.");
		System.out.println("�ٷ� �� ���������� �� 3ȸ, 30���� �����մϴ� ��Ʈ��Ī�� �ʼ��Դϴ�!");
		System.out.println("ex) �ȱ������,��������Ű��,����Ʈ,�ΰ��� ��");
		System.out.println("-> ��е��� ��ϼ̳���?");
		
		int mus_time=0;
		mus_time = sc.nextInt();
		InsertDone();
		
		
	}
	public static void exercise_cardio() { //����������
		System.out.println("<�ǰ����� ���̾>");
		System.out.println("# ����");
		//p_date �߰�
		Scanner sc = new Scanner(System.in);
		
		int car_num=0;
		System.out.println("����������");
		System.out.println("������������ �������� �ݺ����� ��� ���ϸ� ū ������ �̿��Ͽ� ������ �������� ����Ű�� �");
		System.out.println("�� 2~3ȸ, 30��~1�ð��� �ϴ� ���� �����մϴ�.");
		System.out.println("ex) �ȱ�, ��� ������, �ٳѱ�, ������ ��");
		System.out.println("-> ��е��� ��ϼ̳���?");
		
		int car_time=0;
		car_time = sc.nextInt();
		InsertDone();
	}
	
	public static void exercise_flex() { //������
		System.out.println("<�ǰ����� ���̾>");
		System.out.println("# ����");
		//p_date �߰�
		Scanner sc = new Scanner(System.in);
		int flex_time=0;
		System.out.println("������");
		System.out.println("�������� ���� ����, �ؾ� �㸮���̱�, �䰡, �ʶ��׽��� �ֽ��ϴ�.");
		System.out.println("������ ��� 10�� ���� 2~3��Ʈ�� �ݺ��ϴ� ���� �����ϴ�. ������ �������� �����ּ���");
		System.out.println("->��������� ��� ���� �߳���?");
		System.out.println("\t(�д���, 10�� �ڸ����� �Է����ּ���");
		flex_time = sc.nextInt();
		InsertDone();
		
	}
	

	public static void InsertDone() {
		int insertdone = 0;
		System.out.println("1.�߰��ϱ�\n2.�Ϸ�");
		Scanner sc = new Scanner(System.in);
		insertdone=sc.nextInt();
		switch (insertdone) {		
		case 1:
			exercise_first();
		case 2:
			Menu.menu();
			break;
			//��� �޴��� ���ư���
		default:
			System.out.println("1�� 2�߿� �Է����ּ���.");
			InsertDone();
		}	
	}

	public static void DoNotExercise() {
		System.out.println("����� �ʾҾ��");
		System.out.println("�Ϸ翡 ���ݾ� ��ϴ� ���� �߿��ؿ�");
		System.out.println("���θ޴��� ���ư��ϴ�");
		
		Menu.menu();
	}
}



