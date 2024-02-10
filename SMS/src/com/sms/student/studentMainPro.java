package com.sms.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class studentMainPro {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	intro();
	Class.forName("com.mysql.cj.jdbc.Driver");
	Scanner s1=new Scanner(System.in);
	while(true) {
		intro();
		System.out.println("===================================");
		System.out.println("Choose the Operation:");
		int o=s1.nextInt();
		switch (o) {
		case 1:
			System.out.println("*******************************");
			System.out.println("*         INSERT RECORD       *");
			System.out.println("*******************************");
			insert();
			break;
		case 2:
			System.out.println("*******************************");
			System.out.println("*        EDIT RECORD          *");
			System.out.println("*******************************");
			edit();
			break;
		case 3:
			System.out.println("*******************************");
			System.out.println("*         VIEW RECORD         *");
			System.out.println("*******************************");
			view();
			break;
		case 4:
			System.out.println("*******************************");
			System.out.println("*          DELETE RECORD      *");
			System.out.println("*******************************");
			delete();
			break;
		case 5:
			System.out.println("*******************************");
			System.out.println("*           STOP RECORD       *");
			System.out.println("*******************************");
			System.exit(0);
			break;
           
		default:
			System.out.println("Enter the Valid Number");
			break;
		}
	}
	//insert();
	//view();v
	
	
}
public static void delete() throws SQLException {
	String url="jdbc:mysql://localhost:3306/sms_db";
	Connection con=DriverManager.getConnection(url, "root","Root@1234");
	
	String q="DELETE FROM student_info WHERE (id=?);";
	PreparedStatement ps=con.prepareStatement(q);
	
	Scanner s=new Scanner(System.in);
	System.out.println("Select ID to DELETE:");
	int id=s.nextInt();
	
	ps.setInt(1, id);
	ps.executeUpdate();
	System.out.println("Record deleted successfully...............");
	
}
	
	
	
	
	
	
	public static void edit() throws SQLException {
		String url3="jdbc:mysql://localhost:3306/sms_db";
		Connection con3=DriverManager.getConnection(url3, "root","Root@1234");
	
	String query="UPDATE student_info SET name =?,std =?,fname=?,mobile=? WHERE (id=?);";
	PreparedStatement ps=con3.prepareStatement(query);
	Scanner s=new Scanner(System.in);
	System.out.println("Select the id to EDIT:");
	int i=s.nextInt();
	System.out.println("Enter your Name:");
	s.nextLine();
	String n=s.nextLine();
	System.out.println("Enter STD:");
	String c=s.nextLine();
	System.out.println("Enter Fname:");
	String fn=s.nextLine();
	System.out.println("Enter mobile:");
	String mob=s.nextLine();
	
	
	ps.setString(1, n);
	ps.setString(3, fn);
	ps.setString(2, c);
	ps.setString(4, mob);
	ps.setInt(5, i);
	
	ps.executeUpdate();
	System.out.println("data updated successfully...........");
	
	
	}
	public static void view() throws SQLException {
		String url1="jdbc:mysql://localhost:3306/sms_db";
		Connection con1=DriverManager.getConnection(url1, "root","Root@1234");
		Statement st=con1.createStatement();
		ResultSet rs=st.executeQuery("select * from student_info");
		System.out.println("ID | Name | std | father | Mobile");
		System.out.println("-------------------------------------");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"|"+rs.getString(2)+"|"+rs.getString(3)+"|"+rs.getString(4)+" |"+rs.getString(5));
		}
		
	}



  public static void insert() throws SQLException {
	  Scanner  s=new Scanner(System.in);
  String url="jdbc:mysql://localhost:3306/sms_db";
	Connection con=DriverManager.getConnection(url, "root", "Root@1234");
	
	
	System.out.println("Enter your Name:");
	String n=s.nextLine();
	System.out.println("Enter your Class:");
	String c=s.nextLine();
	System.out.println("Enter your Father Name:");
	String f=s.nextLine();
	System.out.println("Enter your Mobile No:");
	String m=s.nextLine();
	
	String query="insert into student_info(name,std,fname,mobile) "
			+"value(?,?,?,?)";
	PreparedStatement ps=con.prepareStatement(query);
	ps.setString(1, n);
	ps.setString(2,c);
	ps.setString(3, f);
	ps.setString(4,m);
	ps.executeUpdate();
	System.out.println("Data inserted successfully......");
	  
  }
public static void intro() {
	System.out.println("*************************************");
	System.out.println("*          STUDENTS MODULE          *");
	System.out.println("*************************************");
	System.out.println("\n 1.Insert");
	System.out.println("2.Edit");
	System.out.println("3.View");
	System.out.println("4.Delete");
	System.out.println("5.Stop");
}
}
