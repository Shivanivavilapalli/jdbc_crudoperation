package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class jdbcApp1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try 
		{
		//load the driver;
		Class.forName("com.mysql.cj.jdbc.Driver");
		//connection with database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");
		//create statement object
		Statement st = con.createStatement();
		// prepare the parse query
//		String qry2 = "insert into product values(123,'mobile',35000)";
	//taking dynamic inputs
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		String name = sc.next();
		double price = sc.nextDouble();
		String qry2 = "insert into product values("+id+",'"+name+"',"+price+")";
		//Execute query
		int x = st.executeUpdate(qry2);
		//get the result
		System.out.println(x);
		System.out.println("row created");
		// to get results
		ResultSet rs = st.executeQuery("select * from "+ sc.next());
		System.out.println("row retrieved");
		System.out.println("===============");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3));
		}
		st.close();
		con.close();
		
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
