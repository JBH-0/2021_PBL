package Menu;
import java.util.*;
import Exercise.*;
import CheckList.*;

public class Menu {
	public static void main(String[] args) {
		menu();
	}
	public static void menu() {
		int function_menu=0;
		System.out.println("���α׷��� �ֿ� ����Դϴ�");
		System.out.println("1. ����\n2. �ǰ����� ��� \n3. üũ����Ʈ \n4. � �� �ǰ�����\n5. ���������� \n6. ���α׷� ����");
		Scanner sc = new Scanner(System.in);
		function_menu=sc.nextInt();
		
		switch (function_menu) {
			case 1://����
				Exercise.Exercise_1.exercise_first();
			case 2://�ǰ�����
				Health.health_main.health_first();
				
			case 3://üũ����Ʈ
				CheckList.checklist_main.Checklist_first();
				//üũ����Ʈ������ üũ����Ʈ ���Լ� �θ���
				
			case 4://� �� �ǰ� ����
				
			case 5://����������
				
			case 6://���α׷� ����
				System.exit(0);
			}
	}
}