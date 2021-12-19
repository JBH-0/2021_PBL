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
		System.out.println("<�ǰ����� ���̾>");
		System.out.println("# ����");
		//dateŬ�������� ���� ��¥
		
		
		int function_menu=0;
		System.out.println("� ��� �ϼ̽��ϱ�? ");
		System.out.println("1. �ٷ� �� ��������   2. ����������   3.������   4.���߾��  5.������  6.���ϻ���");
		function_menu = sc.nextInt();
		switch (function_menu) {
			case 1: //����
				exercise_muscluar();//�ٷ� �� ��������
				break;
			
			case 2:
				exercise_cardio(); //����������
				break;
				
			case 3:
				exercise_flex(); //������
				break;
				
			case 4:
				DoNotExercise(); //���߾��
				break;
				
			case 5:
				RecordList(); //��� ���
				break;
				
			case 6:
				createFile(); // ���ϻ���
				break;	
				
			case 7:
				Menu.menu();
				
			default:
				System.out.println("1~7�� �߿� �������ּ���");
				exercise_first();
		}
	}
	
	
	
	public static void exercise_muscluar()  { //�ٷ� �� �������� 
		System.out.println("<�ǰ����� ���̾>");
		System.out.println("# ����");
		
		int result=0;
		String mus = "�ٷ� �� ��������";
		Connection con = null;
		PreparedStatement ps = null;
		
		String url = "jdbc:mysql://localhost:3306/dbteam?useSSL=false&useUnicode=true&characterEncoding=euckr";
        String user = "root";
        String passwd = "root";
        
        
		System.out.println("�ٷ� �� ��������");
		System.out.println("������ ������ �̰� ���� ���� �ִ����� ������� �����ϴ� �ɷ��Դϴ�.");
		System.out.println("�ٷ� �� ���������� �� 3ȸ, 30���� �����մϴ� ��Ʈ��Ī�� �ʼ��Դϴ�!");
		System.out.println("ex) �ȱ������,��������Ű��,����Ʈ,�ΰ��� ��");
		System.out.println("-> ��е��� ��ϼ̳���?");
		
		String mus_time;
		mus_time = sc.next();
		String musdate=Date.getDate();//��¥ �� �������� ����
		String mustime = Date.gettime();//�ð��� �������� ����
		
		try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	con = DriverManager.getConnection(url,user,passwd);

        	String sql = "insert into exercise values(?,?,?,?)";
        	
        	ps = con.prepareStatement(sql);
    
        	ps.setString(1,musdate);//��¥ ex)2020.12.5
        	ps.setString(2,mustime);//����/����
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
	public static void exercise_cardio() { //����������
		System.out.println("<�ǰ����� ���̾>");
		System.out.println("# ����");
		//Ex_Date
		int result=0;
		String car = "����������";
		Connection con = null;
		PreparedStatement ps = null;
		
		String url = "jdbc:mysql://localhost:3306/dbteam?useSSL=false&useUnicode=true&characterEncoding=euckr";
        String user = "root";
        String passwd = "root";
		
        String cardate=Date.getDate(); //��¥ �� ��������
		String cartime = Date.gettime(); // �ð� �� ��������
		
		System.out.println("����������");
		System.out.println("������������ �������� �ݺ����� ��� ���ϸ� ū ������ �̿��Ͽ� ������ �������� ����Ű�� �");
		System.out.println("�� 2~3ȸ, 30��~1�ð��� �ϴ� ���� �����մϴ�.");
		System.out.println("ex) �ȱ�, ��� ������, �ٳѱ�, ������ ��");
		System.out.println("-> ��е��� ��ϼ̳���?");
		
		String car_time;
		car_time = sc.next();
		
		
		
		try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	con = DriverManager.getConnection(url,user,passwd);

        	String sql = "insert into exercise values(?,?,?,?)";
        	
        	ps = con.prepareStatement(sql);
    
        	ps.setString (1,cardate);//��¥ ex)2020.12.5
        	ps.setString(2,cartime); //����/����
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
	
	public static void exercise_flex() { //������
		System.out.println("<�ǰ����� ���̾>");
		System.out.println("# ����");
		//p_date �߰�
		int result=0;
		String flex = "������";
		Connection con = null;
		PreparedStatement ps = null;
		
		String flexdate=Date.getDate();
		String flextime = Date.gettime();
			
		String url = "jdbc:mysql://localhost:3306/dbteam?useSSL=false&useUnicode=true&characterEncoding=euckr";
        String user = "root";
        String passwd = "root";
        
		System.out.println("������");
		System.out.println("�������� ���� ����, �ؾ� �㸮���̱�, �䰡, �ʶ��׽��� �ֽ��ϴ�.");
		System.out.println("������ ��� 10�� ���� 2~3��Ʈ�� �ݺ��ϴ� ���� �����ϴ�. ������ �������� �����ּ���");
		System.out.println("->��������� ��� ���� �߳���?");
		System.out.println("\t(�д���, 10�� �ڸ����� �Է����ּ���");
		
		String flex_time;
		flex_time = sc.next();
		
		try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	con = DriverManager.getConnection(url,user,passwd);

        	String sql = "insert into exercise values(?,?,?,?)";
        	
        	ps = con.prepareStatement(sql);
    
        	ps.setString (1,flexdate);//��¥ ex)2020.12.5
        	ps.setString(2,flextime); //����/����
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
	
	public static void DoNotExercise() {//����� 
		System.out.println("����� �ʾҾ��");
		System.out.println("�Ϸ翡 ���ݾ� ��ϴ� ���� �߿��ؿ�");
	}
	
	
	public static void InsertDone() {// �߰��ϱ�/�Ϸ�
		int insertdone = 0;
		System.out.println("1.�߰��ϱ�\n2.�Ϸ�");
		insertdone=sc.nextInt();
		switch (insertdone) {		
		case 1:
			exercise_first(); //�߰��ϱ�
		case 2://�Ϸ�
			System.out.println("\n\n--------------");
			 // �Ϸ��ϰ� ���� ��� ��°� �������
			int doneNum=0;
			switch (doneNum) {
			case 1:
				System.out.println("��� ����ϱ�");
				//DB���� �Ѱ� ����ϱ� 
				
				break;
				
			case 2:
				
				System.out.println("���� �����ϱ�");
				break;
				
			case 3:
				System.out.println("��� �޴��� ���ư��ϴ�");
				Menu.menu();
				break;
				
			default:
				System.out.println("1.������ 2.������� 3.��ɸ޴��ε��ư��� �߿� �����ϼ���");
				break;
			}
			break;
			//��� �޴��� ���ư���
		default:
			System.out.println("1�� 2�߿� �Է����ּ���.");
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



