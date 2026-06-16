package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class jdbc_Dynamic_inputs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root", "root");
			PreparedStatement pst = con.prepareStatement("insert into product values (?,?,?)");
			Scanner sc = new Scanner(System.in);
			int id = sc.nextInt();
			String name = sc.next();
			double price = sc.nextDouble();
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setDouble(3, price);
			pst.executeUpdate();
			System.out.println("row created");
			PreparedStatement pst2 = con.prepareStatement("select * from "+sc.next());
			ResultSet rs = pst2.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3));
			}
			rs.close();
			pst2.close();
			pst.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
