import java.util.Scanner;
public class menu {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		int num;
		boolean flag=false;
		
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("1. � ���	2. �ǰ� ���� ���\n3. üũ ����Ʈ	4. � �� �ǰ� ����\n"
					+ "5. ����������	6. ���α׷� ����");
			System.out.println("���ϴ� ����� ���ڷ� �Է��ϼ���!");
			num = sc.nextInt();
			
			switch(num)
			{
				case 1: 
					System.out.println("1. � ��� ���");
					break;
				case 2: 
					System.out.println("2. �ǰ� ���� ��� ���");
					break;
				case 3: 
					System.out.println("3. üũ ����Ʈ ���");
					break;
				case 4: 
					System.out.println("4. � �� �ǰ� ���� ���");
					break;
				case 5: 
					System.out.println("5. ���������� ���");
					break;
				case 6: 
					System.out.println("6. ���α׷� ���� ���");
					flag=true;
					break;
				default:
					System.out.println("�߸� �Է��߽��ϴ�. ���ڷ� �Է��ϼ���(1~6)!");
			}
			
			if(flag==true)
			{
				System.out.println("6. ���α׷� �����մϴ�.");
				break;
			}

		}
		sc.close();

	}

}
