package Login;

import java.sql.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.*;

import java.util.Scanner;
import java.util.regex.Pattern;


public class SignUp {	
	
	//���� 
	public static void nameCheck(String name){
		boolean check = Pattern.matches("^[��-����-�R]*$", name);

		if (!check) {
			System.out.println("�̸��� �ѱ۷� �Է����ּ���");
			insertData();
		}
	}
	//���̵� 5~20�� ���� �Է��ϵ��� ��
	public static void idFormat(String str) {
		if (str.length()<5 || str.length()>20) {
			System.out.println("5~20�� �̳��� ���̵� �Է����ּ���");
			insertData();
		}
	}
	//��й�ȣ�� ���ڷ� 4�ڸ��� �Է�
	public static void pwCheck(String pw1) {
		
		for (int i=0; i<pw1.length(); i++) {
			if (pw1.length() >=5) {
				System.out.println("��й�ȣ�� 4�ڸ��� �Է����ּ���");
				insertData();
			}
		}
		
		for (int i=0; i<pw1.length(); i++) {
			char c= pw1.charAt(i);
			if (Character.isDigit(c) == false) {
				System.out.println("��й�ȣ�� ���ڷ� �Է����ּ���");
				insertData();
			}
		}
	}
	//��й�ȣ �´��� Ȯ��
	public static void pwCheck(String pw1, String pw2) {
		if (!pw1.equals(pw2)) 
			System.out.println("��й�ȣ�� �ٸ��ϴ�.");
	}
	//����Ȯ��
	public static void genCheck(String gender){
		if (!gender.equals("��")&&!gender.equals("��")) {
			System.out.println("���� �� �߿��� �Է����ּ���");
			insertData();
		}
	}
	//���� Ȯ��
	public static void ageCheck(String age) {
		int intage = Integer.parseInt(age);
		if( intage<= 0 && intage>=80) {
			System.out.println("ȸ�����԰����� ���̴� 0~80�� �����Դϴ�.");
			insertData();
		}
	}
	//Ű 
	public static void heightCheck(String height) {
		int inth = Integer.parseInt(height);
		if (inth <=130 && inth >200) {
			System.out.println("cm������ �Է����ּ��� 130~200�� �����մϴ�.");
			insertData();
		}
	}
	//�����
	public static void eEpCheck(String exerciseEP) {
		Boolean eEPB = Boolean.parseBoolean(exerciseEP);
		if (exerciseEP =="T" && exerciseEP =="t") {
			eEPB = true;
		} else if (exerciseEP =="F" && exerciseEP =="f") {
			eEPB=false;
		}else {
			System.out.println("T/F�� �Է����ּ���");
			insertData();
		}
	}
	
	
	
	public static void insertData() {
		
		int result=0;
		Connection con = null;
		PreparedStatement ps = null;
		
		String url = "jdbc:mysql://localhost:3306/dbteam?useSSL=false&useUnicode=true&characterEncoding=euckr";
        String user = "root";
        String passwd = "root";
        
        
        String usname, userid, userpw, age, gender, height, exerciseEP;
        
        System.out.println("\n-------------------");
        System.out.println("      ȸ������");
        System.out.println("-------------------\n");
        System.out.println("ȸ�������� �մϴ�.");
        Scanner sc = new Scanner(System.in);
        System.out.print("����:");
        usname = sc.next();
        nameCheck(usname);
        System.out.print("���̵�:");
        userid=sc.next();
        idFormat(userid);
        System.out.print("��й�ȣ:");
        userpw=sc.next();
        pwCheck(userpw);
        System.out.print("����:");
        age=sc.next();
        ageCheck(age);
        System.out.print("����:");
        gender=sc.next();
        genCheck(gender);
        System.out.print("Ű:");
        height=sc.next();
        heightCheck(height);
        System.out.print("����� ����(T/F):");
        exerciseEP=sc.next();
        
        
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	con = DriverManager.getConnection(url,user,passwd);

        	String sql = "insert into userinfo values(?,?,?,?,?,?,?)";
        	
        	ps = con.prepareStatement(sql);
        	
        	ps.setString(1,usname);
        	ps.setString(2,userid);
        	ps.setString(3,userpw);
        	ps.setString(4,age);
        	ps.setString(5,gender);
        	ps.setString(6,height);
        	ps.setString(7,exerciseEP);
        	
        	result = ps.executeUpdate();
        	
        	ps.close();    
        	
        } catch (Exception ex) {
        	ex.printStackTrace();
        } finally{
        	if(ps!=null) try{ps.close();}catch(SQLException ex){}
            if(con!=null) try{con.close();}catch(SQLException ex){}

        }        

	}
		
	public static void main(String[] args) {
		insertData();
	}
}

	

