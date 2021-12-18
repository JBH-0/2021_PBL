import java.util.Scanner;
public class menu {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		int num;
		boolean flag=false;
		
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("1. 운동 기록	2. 건강 정보 기록\n3. 체크 리스트	4. 운동 및 건강 조언\n"
					+ "5. 마이페이지	6. 프로그램 종료");
			System.out.println("원하는 기능을 숫자로 입력하세요!");
			num = sc.nextInt();
			
			switch(num)
			{
				case 1: 
					System.out.println("1. 운동 기록 기능");
					break;
				case 2: 
					System.out.println("2. 건강 정보 기록 기능");
					break;
				case 3: 
					System.out.println("3. 체크 리스트 기능");
					break;
				case 4: 
					System.out.println("4. 운동 및 건강 조언 기능");
					break;
				case 5: 
					System.out.println("5. 마이페이지 기능");
					break;
				case 6: 
					System.out.println("6. 프로그램 종료 기능");
					flag=true;
					break;
				default:
					System.out.println("잘못 입력했습니다. 숫자로 입력하세요(1~6)!");
			}
			
			if(flag==true)
			{
				System.out.println("6. 프로그램 종료합니다.");
				break;
			}

		}
		sc.close();

	}

}
