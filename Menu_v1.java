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
		System.out.println("프로그램의 주요 기능입니다");
		System.out.println("1. 운동기록\n2. 건강정보 기록 \n3. 체크리스트 \n4. 운동 및 건강조언\n5. 마이페이지 \n6. 프로그램 종료");
		Scanner sc = new Scanner(System.in);
		function_menu=sc.nextInt();
		
		switch (function_menu) {
			case 1://운동기록
				Exercise.Exercise_1.exercise_first();
			case 2://건강정보
				Health.health_main.health_first();
				
			case 3://체크리스트
				CheckList.checklist_main.Checklist_first();
				//체크리스트파일의 체크리스트 ㅎ함수 부르기
				
			case 4://운동 및 건강 조언
				
			case 5://마이페이지
				
			case 6://프로그램 종료
				System.exit(0);
			}
	}
}