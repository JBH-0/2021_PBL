package Exercise;

import Menu.Menu;
import Exercise.*;
import Exercise.Date;

import java.sql.*;
import java.util.*;
import java.io.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Exercise_1 {
	
	public static Scanner sc = new Scanner(System.in);

	public static void exercise_first() {
		System.out.println("<건강관리 다이어리>");
		System.out.println("# 운동기록");
		//date클래스에서 만든 날짜
		
		
		int function_menu=0;
		System.out.println("어떤 운동을 하셨습니까? ");
		System.out.println("1. 근력 및 근지구력   2. 심폐지구력   3.유연성   4.안했어요  5.기록출력  6.파일생성");
		function_menu = sc.nextInt();
		switch (function_menu) {
			case 1: //운동기록
				exercise_muscluar();//근력 및 근지구력
				break;
			
			case 2:
				exercise_cardio(); //심폐지구력
				break;
				
			case 3:
				exercise_flex(); //유연성
				break;
				
			case 4:
				DoNotExercise(); //안했어요
				break;
				
			case 5:
				RecordList(); //기록 출력
				break;
				
			case 6:
				createFile(); // 파일생성
				break;	
				
			case 7:
				Menu.menu();
				
			default:
				System.out.println("1~7번 중에 선택해주세요");
				exercise_first();
		}
	}
	
	
	
	public static void exercise_muscluar()  { //근력 및 근지구력 
		System.out.println("<건강관리 다이어리>");
		System.out.println("# 운동기록");
		
		int result=0;
		String mus = "근력 및 근지구력";
		Connection con = null;
		PreparedStatement ps = null;
		
		String url = "jdbc:mysql://localhost:3306/dbteam?useSSL=false&useUnicode=true&characterEncoding=euckr";
        String user = "root";
        String passwd = "root";
        
        
		System.out.println("근력 및 근지구력");
		System.out.println("근육이 저항을 이겨 내기 위해 최대한의 수축력을 발휘하는 능력입니다.");
		System.out.println("근력 및 근지구력은 주 3회, 30분이 적당합니다 스트레칭은 필수입니다!");
		System.out.println("ex) 팔굽혀펴기,윗몸일으키기,스쿼트,턱걸이 등");
		System.out.println("-> 몇분동안 운동하셨나요?");
		
		String mus_time;
		mus_time = sc.next();
		String musdate=Date.getDate();//날짜 값 가져오기 성공
		String mustime = Date.gettime();//시간값 가져오기 성공
		
		try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	con = DriverManager.getConnection(url,user,passwd);

        	String sql = "insert into exercise values(?,?,?,?)";
        	
        	ps = con.prepareStatement(sql);
    
        	ps.setString(1,musdate);//날짜 ex)2020.12.5
        	ps.setString(2,mustime);//오전/오후
        	ps.setString(3,mus);
        	ps.setString(4, mus_time);
        	
        	result = ps.executeUpdate();
        	
        	ps.close();    
        	
        } catch (Exception ex) {
        	ex.printStackTrace();
        } finally{
        	if(ps!=null) try{ps.close();}catch(SQLException ex){}
            if(con!=null) try{con.close();}catch(SQLException ex){}

        }        
		
		InsertDone();
		
		
	}
	public static void exercise_cardio() { //심폐지구력
		System.out.println("<건강관리 다이어리>");
		System.out.println("# 운동기록");
		//Ex_Date
		int result=0;
		String car = "심폐지구력";
		Connection con = null;
		PreparedStatement ps = null;
		
		String url = "jdbc:mysql://localhost:3306/dbteam?useSSL=false&useUnicode=true&characterEncoding=euckr";
        String user = "root";
        String passwd = "root";
		
        String cardate=Date.getDate(); //날짜 값 가져오기
		String cartime = Date.gettime(); // 시간 값 가져오기
		
		System.out.println("심폐지구력");
		System.out.println("심폐지구력은 저강도의 반복적인 운동을 말하며 큰 근육을 이용하여 심폐의 적응도를 향상시키는 운동");
		System.out.println("주 2~3회, 30분~1시간을 하는 것이 적당합니다.");
		System.out.println("ex) 걷기, 계단 오르기, 줄넘기, 스포츠 등");
		System.out.println("-> 몇분동안 운동하셨나요?");
		
		String car_time;
		car_time = sc.next();
		
		
		
		try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	con = DriverManager.getConnection(url,user,passwd);

        	String sql = "insert into exercise values(?,?,?,?)";
        	
        	ps = con.prepareStatement(sql);
    
        	ps.setString (1,cardate);//날짜 ex)2020.12.5
        	ps.setString(2,cartime); //오전/오후
        	ps.setString(3,car);
        	ps.setString(4, car_time);
        	
        	result = ps.executeUpdate();
        	
        	ps.close();    
        	
        } catch (Exception ex) {
        	ex.printStackTrace();
        } finally{
        	if(ps!=null) try{ps.close();}catch(SQLException ex){}
            if(con!=null) try{con.close();}catch(SQLException ex){}

        }  
		
		InsertDone();
	}
	
	public static void exercise_flex() { //유연성
		System.out.println("<건강관리 다이어리>");
		System.out.println("# 운동기록");
		//p_date 추가
		int result=0;
		String flex = "유연성";
		Connection con = null;
		PreparedStatement ps = null;
		
		String flexdate=Date.getDate();
		String flextime = Date.gettime();
			
		String url = "jdbc:mysql://localhost:3306/dbteam?useSSL=false&useUnicode=true&characterEncoding=euckr";
        String user = "root";
        String passwd = "root";
        
		System.out.println("유연성");
		System.out.println("유연성은 전신 뻗기, 앚아 허리숙이기, 요가, 필라테스가 있습니다.");
		System.out.println("유연성 운동은 10초 유지 2~3세트를 반복하는 것이 좋습니다. 하지만 무리하지 말아주세요");
		System.out.println("->유연성운동은 몇분 동안 했나요?");
		System.out.println("\t(분단위, 10의 자리수로 입력해주세요");
		
		String flex_time;
		flex_time = sc.next();
		
		try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	con = DriverManager.getConnection(url,user,passwd);

        	String sql = "insert into exercise values(?,?,?,?)";
        	
        	ps = con.prepareStatement(sql);
    
        	ps.setString (1,flexdate);//날짜 ex)2020.12.5
        	ps.setString(2,flextime); //오전/오후
        	ps.setString(3,flex);
        	ps.setString(4, flex_time);
        	
        	result = ps.executeUpdate();
        	
        	ps.close();    
        	
        } catch (Exception ex) {
        	ex.printStackTrace();
        } finally{
        	if(ps!=null) try{ps.close();}catch(SQLException ex){}
            if(con!=null) try{con.close();}catch(SQLException ex){}

        }  
		InsertDone();
		
	}
	
	public static void DoNotExercise() {//운동안함 
		System.out.println("운동하지 않았어요");
		System.out.println("하루에 조금씩 운동하는 것이 중요해요");
	}
	
	
	public static void InsertDone() {// 추가하기/완료
		int insertdone = 0;
		System.out.println("1.추가하기\n2.완료");
		insertdone=sc.nextInt();
		switch (insertdone) {		
		case 1:
			exercise_first(); //추가하기
		case 2://완료
			System.out.println("\n\n--------------");
			 // 완료하고 나서 기록 출력과 파일출력
			int doneNum=0;
			switch (doneNum) {
			case 1:
				System.out.println("기록 출력하기");
				//DB연동 한거 출력하기 
				
				break;
				
			case 2:
				
				System.out.println("파일 생성하기");
				break;
				
			case 3:
				System.out.println("기능 메뉴로 돌아갑니다");
				Menu.menu();
				break;
				
			default:
				System.out.println("1.기록출력 2.파일출력 3.기능메뉴로돌아가기 중에 선택하세요");
				break;
			}
			break;
			//기능 메뉴로 돌아가기
		default:
			System.out.println("1과 2중에 입력해주세요.");
			InsertDone();
		}	
	}

	
	
	public static void RecordList() {
		
	}
	
	public static void createFile() {
	
	}
	
	
	public static void main(String[] args) {
		Date d = new Date();
		d.Ex_Date();
		exercise_first();
	}
}



