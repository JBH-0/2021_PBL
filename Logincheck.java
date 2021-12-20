package Login;

import java.sql.*;
import java.util.Scanner;
import Menu.Menu;
import Login.SignUp;

public class Logincheck {
	
	public static void Login() {
		int result=0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs;
		
		String url = "jdbc:mysql://localhost:3306/dbteam?useSSL=false&useUnicode=true&characterEncoding=euckr";
        String user = "root";
        String passwd = "root";
        
        Scanner sc = new Scanner(System.in);
        String userid;
        System.out.println("���̵� �Է��ϼ���");
        userid = sc.next();
        String userpw;
        System.out.println("��й�ȣ�� �Է��ϼ���");
        userpw = sc.next();
        
        String sql = "SELECT pw FROM userinfo WHERE id=?";
        try {
        	con = DriverManager.getConnection(url,user,passwd);
        	ps = con.prepareStatement(sql);
        	ps.setString(1, userid);
        	rs=ps.executeQuery();
        	if (rs.next()) {
        		if (rs.getString(1).contentEquals(userpw)) {
        			System.out.println("�α��� ����!");
        			System.out.println("1.���������� 2.��� �޴�");
        			int lognum=0;
        			switch (lognum) {
        			case 1:
        				logp(userid);
        			case 2:
        				Menu.menu();
        				default :
        			}
        			Menu.menu();
        		}
        		else {
        			System.out.println("��й�ȣ�� �ٽ� �Է����ּ���");
        			Login();
        		}
        	}
        	else {
        		System.out.println("���̵� �����ϴ�.");
        		System.out.println("1. ȸ������ 2.�α����ϱ�");
        		int choose =0;
        		switch(choose) {
        		case 1:
        			SignUp();
        		case 2: 
        			Login();
        		}
        	}
        	
        } catch(Exception e){
        	e.printStackTrace();
        	
        } finally {
        	if(ps!=null) try{ps.close();}catch(SQLException ex){}
            if(con!=null) try{con.close();}catch(SQLException ex){}
        }
        
	}
	private static void SignUp() {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		Login();
	}
	public static void logp(String a) {
		int result=0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs;
		
		String url = "jdbc:mysql://localhost:3306/dbteam?useSSL=false&useUnicode=true&characterEncoding=euckr";
        String user = "root";
        String passwd = "root";
        
        String sql = "SELECT * FROM userinfo WHERE id=?";
        try {
        	con = DriverManager.getConnection(url,user,passwd);
        	ps = con.prepareStatement(sql);
        	ps.setString(1, a);
        	rs=ps.executeQuery();
        } catch (Exception e) {
        	
        }
	}
	
}
