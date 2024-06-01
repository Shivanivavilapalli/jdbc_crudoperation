package application;

import java.awt.DisplayMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class crudoperations {
	
	//do while,switch,jdbc,exception handling by using this we will write the code
	
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String USERNAME = "root";
	private static final String PASSWORD= "root";
	
	
	
	public static void main(String[] args) {
		   
		int ch;
		
		do {
			
			System.out.println("crud operation :");
			
			System.out.println("*************");
			
			display();
			
			Scanner scr = new Scanner(System.in);
			
			System.out.println("enter your choice:");
			
			ch = Integer.parseInt(scr.next());
			
			System.out.println("****************");
			
			switch (ch) {
			
			case 1:
				
				createdatabase();
				
				break;
				
             case 2:
				
				dropdatabase();
				
				break;
case 3:
	
	createtable();
	
	break;
case 4:
	
	droptable();
	
	break;
case 5:
	
	insertion();
	
	break;
case 6:
	
	update();
	
	break;
case 7:
	
	delete();
	
	break;
  case 8:
	
	getall();
	
	break;
   case 9:
	
	getbyemail();
	
	break;
    case 10:
	
	System.exit(0);
	
	break;

			default:
				
				System.out.println("invalid");
				
				break;
			}
			
		} while (ch>0);
		
	}

	
	private static void createtable() {
		
		System.out.println("CREATING TABLE");
		
		try {
			Scanner scr = new Scanner(System.in);
			
			System.out.println("provide database name:");
			
			String URL = "jdbc:mysql://localhost:3306/ " + scr.next();
			
			Class.forName(DRIVER);
			
			Connection conn = DriverManager.getConnection(URL , USERNAME , PASSWORD);
			
			System.out.println("enter the table name:");
			
			String sql = "create table " + scr.next() +"(id int,name varchar(20), email varchar(30))";
			
			PreparedStatement pmst = conn.prepareStatement(sql);
			
			int i = pmst.executeUpdate();
			
			if (i==0) {
				
				System.out.println("table created");
				
			}
			
			else {
				
				System.out.println(" table not created");
			}
			
			conn.close();
			
			pmst.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}


	private static void getbyemail() {
		
		System.out.println("GET BY EMAIL");
		try {
			
			Scanner scr = new Scanner(System.in);
			
			System.out.println("provide database name:");
			
			String URL = "jdbc:mysql://localhost:3306/ " + scr.next();
			
			Class.forName(DRIVER);
			
			Connection conn = DriverManager.getConnection(URL , USERNAME , PASSWORD);
			
			System.out.println("enter the table name:");
			
			String sql = "select * from "+ scr.next() +" where email =?";
			
			PreparedStatement pmst = conn.prepareStatement(sql);
			
			System.out.println("enter email:");
			
			pmst.setString(1, scr.next());
			
			ResultSet rs = pmst.executeQuery();
			
			while (rs.next()) {
				
				System.out.println("**************");
				
				System.out.println("ID:" +rs.getInt("id"));
				
				System.out.println("NAME:" +rs.getString("name"));
				
				System.out.println("EMAIL:" +rs.getString("email"));
				
				System.out.println("*******************");
			}
			
			conn.close();
			
			pmst.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}


	private static void getall() {
		
		System.out.println("GETALL");
		try {
			
			Scanner scr = new Scanner(System.in);
			
			System.out.println("provide database name:");
			
			String URL = "jdbc:mysql://localhost:3306/ " + scr.next();
			
			Class.forName(DRIVER);
			
			Connection conn = DriverManager.getConnection(URL , USERNAME , PASSWORD);
			
			System.out.println("enter the table name:");
			
			String sql = "select * from "+ scr.next();
			
			PreparedStatement pmst = conn.prepareStatement(sql);
			
			ResultSet rs = pmst.executeQuery();
			
			while (rs.next()) {
				
				System.out.println("**************");
				
				System.out.println("ID:" +rs.getInt("id"));
				
				System.out.println("NAME:" +rs.getString("name"));
				
				System.out.println("EMAIL:" +rs.getString("email"));
				
				System.out.println("*******************");
			}
			
			conn.close();
			
			pmst.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}


	private static void delete() {
		
		System.out.println("DELETING");
		try {
			Scanner scr = new Scanner(System.in);
			
			System.out.println("provide database name:");
			
			String URL = "jdbc:mysql://localhost:3306/ " + scr.next();
			
			Class.forName(DRIVER);
			
			Connection conn = DriverManager.getConnection(URL , USERNAME , PASSWORD);
			
			System.out.println("enter the table name:");
			
			String sql = "delete from " + scr.next() +" where email = ?";
			
			PreparedStatement pmst = conn.prepareStatement(sql);
			
			System.out.println("enter email:");
			
			pmst.setString(1, scr.next());
			
			
			int i = pmst.executeUpdate();
			
			if (i>0) {
				
				System.out.println("succefully deleted");
				
			}
			
			else {
				
				System.out.println("not deleted");
			}
			
			conn.close();
			
			pmst.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	
		
	}


	private static void update() {
		
		System.out.println("UPDATING");
		try {
			
			Scanner scr = new Scanner(System.in);
			
			System.out.println("provide database name:");
			
			String URL = "jdbc:mysql://localhost:3306/ " + scr.next();
			
			Class.forName(DRIVER);
			
			Connection conn = DriverManager.getConnection(URL , USERNAME , PASSWORD);
			
			System.out.println("enter the table name:");
			
			
			
			String sql = "update "+ scr.next() + " set name = ?, email =? where id = ?";
			
			PreparedStatement pmst = conn.prepareStatement(sql);
			
			System.out.println("enter name:");
			
			pmst.setString(1, scr.next());
			
			System.out.println("enter email:");
			
			pmst.setString(2, scr.next());
			
			System.out.println("enter id:");
			
			pmst.setInt(3, scr.nextInt());
			
			int i = pmst.executeUpdate();
			
			if (i>0) {
				
				System.out.println("table updated");
				
			}
			
			else {
				
				System.out.println("not updated");
			}
			
			conn.close();
			
			pmst.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}


	private static void insertion() {
		
		System.out.println("INSERTION");
		
		try {
			
			Scanner scr = new Scanner(System.in);
			
			System.out.println("provide database name:");
			
			String URL = "jdbc:mysql://localhost:3306/ " + scr.next();
			
			Class.forName(DRIVER);
			
			Connection conn = DriverManager.getConnection(URL , USERNAME , PASSWORD);
			
			System.out.println("enter the table name:");
			
			String sql = "insert into "+ scr.next()+"(id,name,email)"+"values(?,?,?)";
			
			PreparedStatement pmst = conn.prepareStatement(sql);
			
			System.out.println("enter id:");
			
			pmst.setInt(1, scr.nextInt());
			
			System.out.println("enter name:");
			
			pmst.setString(2, scr.next());
			
			System.out.println("enter email:");
			
			pmst.setString(3, scr.next());

			
			int i = pmst.executeUpdate();
			
			if (i>0) {
				
				System.out.println("data inserted");
				
			}
			
			else {
				
				System.out.println("data not inserted");
			}
			
			conn.close();
			
			pmst.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	


	private static void droptable() {
		
		System.out.println("DROP TABLE");
		try {
			Scanner scr = new Scanner(System.in);
			
			System.out.println("provide database name:");
			
			String URL = "jdbc:mysql://localhost:3306/ " + scr.next();
			
			Class.forName(DRIVER);
			
			Connection conn = DriverManager.getConnection(URL , USERNAME , PASSWORD);
			
			System.out.println("enter the table name:");
			
			String sql = "drop table " + scr.next();
			
			PreparedStatement pmst = conn.prepareStatement(sql);
			
			int i = pmst.executeUpdate();
			
			if (i==0) {
				
				System.out.println("table deleted");
				
			}
			
			else {
				
				System.out.println("table not deleted");
			}
			
			conn.close();
			
			pmst.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}

	private static void dropdatabase() {
		
		System.out.println("DROP DATABASE");
		
		try {
			Scanner scr = new Scanner(System.in);
			
			Class.forName(DRIVER);
			
			 String URL = "jdbc:mysql://localhost:3306/";
			 
			Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			
			System.out.println("enter the database name:");
			
			String sql = "drop database " + scr.next();
			
			PreparedStatement pmst = conn.prepareStatement(sql);
			
			int i = pmst.executeUpdate();
			
			if (i==0) {
				
				System.out.println("database deleted");
				
			}
			
			else {
				
				System.out.println("datebase not deleted");
			}
			
			conn.close();
			pmst.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}

	private static void createdatabase() {
		
		System.out.println("DATEBASE");
		  
		try {
			
			Scanner scr = new Scanner(System.in);
			
			 String URL = "jdbc:mysql://localhost:3306/";
			
			Class.forName(DRIVER);
			
			Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			
			System.out.println("enter the database name:");
			
			
			String sql = "create database " + scr.next();
			
			PreparedStatement pmst = conn.prepareStatement(sql);
			
			int i = pmst.executeUpdate();
			
			if (i>0) {
				
				System.out.println("database created");
				
			}
			
			else {
				
				System.out.println("not created");
			}
			
			conn.close();
			
			pmst.close();
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}

	private static void display() {
		
		System.out.println("/t1.create database");
		
		System.out.println("/t2.drop database");
		
		System.out.println("/t3.create table");
		
		System.out.println("/t4.drop table");
		
		System.out.println("/t5.insertion");
		
		System.out.println("/t6.update");
		
		System.out.println("/t7.delete");
		
		System.out.println("/t8.getall");
		
		System.out.println("/t9.get by email");
		
		System.out.println("/t10.exit");
		
		System.out.println("*****************");
		
	}

}
