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
		System.out.println("<건강관리 다이어리>");
		System.out.println("# 운동기록");
		//Ex_Pdate 추가 하거나 listmap
		int function_menu=0;
		System.out.println("어떤 운동을 하셨습니까? ");
		System.out.println("1. 근력 및 근지구력   2. 심폐지구력   3.유연성   4.안했어요");
		Scanner sc = new Scanner(System.in);
		function_menu = sc.nextInt();
		switch (function_menu) {
			case 1: //운동기록
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
	
	
	
	public static void exercise_muscluar()  { //근력 및 근지구력 
		System.out.println("<건강관리 다이어리>");
		System.out.println("# 운동기록");
		//Ex_Pdate 추가 하거나 listmap
		Scanner sc = new Scanner(System.in);
		
		System.out.println("근력 및 근지구력");
		System.out.println("근육이 저항을 이겨 내기 위해 최대한의 수축력을 발휘하는 능력입니다.");
		System.out.println("근력 및 근지구력은 주 3회, 30분이 적당합니다 스트레칭은 필수입니다!");
		System.out.println("ex) 팔굽혀펴기,윗몸일으키기,스쿼트,턱걸이 등");
		System.out.println("-> 몇분동안 운동하셨나요?");
		
		int mus_time=0;
		mus_time = sc.nextInt();
		InsertDone();
		
		
	}
	public static void exercise_cardio() { //심폐지구력
		System.out.println("<건강관리 다이어리>");
		System.out.println("# 운동기록");
		//p_date 추가
		Scanner sc = new Scanner(System.in);
		
		int car_num=0;
		System.out.println("심폐지구력");
		System.out.println("심폐지구력은 저강도의 반복적인 운동을 말하며 큰 근육을 이용하여 심폐의 적응도를 향상시키는 운동");
		System.out.println("주 2~3회, 30분~1시간을 하는 것이 적당합니다.");
		System.out.println("ex) 걷기, 계단 오르기, 줄넘기, 스포츠 등");
		System.out.println("-> 몇분동안 운동하셨나요?");
		
		int car_time=0;
		car_time = sc.nextInt();
		InsertDone();
	}
	
	public static void exercise_flex() { //유연성
		System.out.println("<건강관리 다이어리>");
		System.out.println("# 운동기록");
		//p_date 추가
		Scanner sc = new Scanner(System.in);
		int flex_time=0;
		System.out.println("유연성");
		System.out.println("유연성은 전신 뻗기, 앚아 허리숙이기, 요가, 필라테스가 있습니다.");
		System.out.println("유연성 운동은 10초 유지 2~3세트를 반복하는 것이 좋습니다. 하지만 무리하지 말아주세요");
		System.out.println("->유연성운동은 몇분 동안 했나요?");
		System.out.println("\t(분단위, 10의 자리수로 입력해주세요");
		flex_time = sc.nextInt();
		InsertDone();
		
	}
	

	public static void InsertDone() {
		int insertdone = 0;
		System.out.println("1.추가하기\n2.완료");
		Scanner sc = new Scanner(System.in);
		insertdone=sc.nextInt();
		switch (insertdone) {		
		case 1:
			exercise_first();
		case 2:
			Menu.menu();
			break;
			//기능 메뉴로 돌아가기
		default:
			System.out.println("1과 2중에 입력해주세요.");
			InsertDone();
		}	
	}

	public static void DoNotExercise() {
		System.out.println("운동하지 않았어요");
		System.out.println("하루에 조금씩 운동하는 것이 중요해요");
		System.out.println("메인메뉴로 돌아갑니다");
		
		Menu.menu();
	}
}



