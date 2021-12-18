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
	
	//¼º¸í 
	public static void nameCheck(String name){
		boolean check = Pattern.matches("^[¤¡-¤¾°¡-ÆR]*$", name);

		if (!check) {
			System.out.println("ÀÌ¸§Àº ÇÑ±Û·Î ÀÔ·ÂÇØÁÖ¼¼¿ä");
			insertData();
		}
	}
	//¾ÆÀÌµð 5~20ÀÚ ³»·Î ÀÔ·ÂÇÏµµ·Ï ÇÔ
	public static void idFormat(String str) {
		if (str.length()<5 || str.length()>20) {
			System.out.println("5~20ÀÚ ÀÌ³»·Î ¾ÆÀÌµð¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä");
			insertData();
		}
	}
	//ºñ¹Ð¹øÈ£´Â ¼ýÀÚ·Î 4ÀÚ¸®¸¸ ÀÔ·Â
	public static void pwCheck(String pw1) {
		
		for (int i=0; i<pw1.length(); i++) {
			if (pw1.length() >=5) {
				System.out.println("ºñ¹Ð¹øÈ£´Â 4ÀÚ¸®·Î ÀÔ·ÂÇØÁÖ¼¼¿ä");
				insertData();
			}
		}
		
		for (int i=0; i<pw1.length(); i++) {
			char c= pw1.charAt(i);
			if (Character.isDigit(c) == false) {
				System.out.println("ºñ¹Ð¹øÈ£´Â ¼ýÀÚ·Î ÀÔ·ÂÇØÁÖ¼¼¿ä");
				insertData();
			}
		}
	}
	//ºñ¹Ð¹øÈ£ ¸Â´ÂÁö È®ÀÎ
	public static void pwCheck(String pw1, String pw2) {
		if (!pw1.equals(pw2)) 
			System.out.println("ºñ¹Ð¹øÈ£°¡ ´Ù¸¨´Ï´Ù.");
	}
	//¼ºº°È®ÀÎ
	public static void genCheck(String gender){
		if (!gender.equals("³²")&&!gender.equals("¿©")) {
			System.out.println("³²°ú ¿© Áß¿¡¼­ ÀÔ·ÂÇØÁÖ¼¼¿ä");
			insertData();
		}
	}
	//³ªÀÌ È®ÀÎ
	public static void ageCheck(String age) {
		int intage = Integer.parseInt(age);
		if( intage<= 0 && intage>=80) {
			System.out.println("È¸¿ø°¡ÀÔ°¡´ÉÇÑ ³ªÀÌ´Â 0~80»ì ±îÁöÀÔ´Ï´Ù.");
			insertData();
		}
	}
	//Å° 
	public static void heightCheck(String height) {
		int inth = Integer.parseInt(height);
		if (inth <=130 && inth >200) {
			System.out.println("cm´ÜÀ§·Î ÀÔ·ÂÇØÁÖ¼¼¿ä 130~200·Î Á¦ÇÑÇÕ´Ï´Ù.");
			insertData();
		}
	}
	//¿îµ¿°æÇè
	public static void eEpCheck(String exerciseEP) {
		Boolean eEPB = Boolean.parseBoolean(exerciseEP);
		if (exerciseEP =="T" && exerciseEP =="t") {
			eEPB = true;
		} else if (exerciseEP =="F" && exerciseEP =="f") {
			eEPB=false;
		}else {
			System.out.println("T/F·Î ÀÔ·ÂÇØÁÖ¼¼¿ä");
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
        System.out.println("      È¸¿ø°¡ÀÔ");
        System.out.println("-------------------\n");
        System.out.println("È¸¿ø°¡ÀÔÀ» ÇÕ´Ï´Ù.");
        Scanner sc = new Scanner(System.in);
        System.out.print("¼º¸í:");
        usname = sc.next();
        nameCheck(usname);
        System.out.print("¾ÆÀÌµð:");
        userid=sc.next();
        idFormat(userid);
        System.out.print("ºñ¹Ð¹øÈ£:");
        userpw=sc.next();
        pwCheck(userpw);
        System.out.print("³ªÀÌ:");
        age=sc.next();
        ageCheck(age);
        System.out.print("¼ºº°:");
        gender=sc.next();
        genCheck(gender);
        System.out.print("Å°:");
        height=sc.next();
        heightCheck(height);
        System.out.print("¿îµ¿°æÇè À¯¹«(T/F):");
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

	

