package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/register")
public class studentservlets extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	try {
    		Scanner sc = new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
			String sql = "insert into employee(id,name) value(?,?)";
			int id = Integer.parseInt(req.getParameter("id")) ;
			
			String name = req.getParameter("name");
			
//			int id = Integer.parseInt(req.getParameter("id"));
//			String name = req.getParameter("name");
			
			PreparedStatement pmst = Conn.prepareStatement(sql);
			
//			pmst.setInt(1, id);
//			pmst.setString(2, name);
			PrintWriter pw = resp.getWriter();
			pmst.setInt(1,id);
			 pmst.setString(2,name);
			
			int i=pmst.executeUpdate();
			 
			 if (i>0) {
				System.out.println("successfully inserted");
//				pw.println("successfully inserted");
				resp.sendRedirect("welcome.jsp");
				
			}else {
				System.out.println("error");
				pw.println("error");
				resp.sendRedirect("error.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
    }
	

}
