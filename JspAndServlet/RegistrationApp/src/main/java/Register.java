

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     System.out.println("Control in side servlet");
		String  uname= request.getParameter("uname");
      String  emailId= request.getParameter("uEmailid");
      String  upassword= request.getParameter("uPass");
      String  ucity= request.getParameter("ucity");
     
      try {
    	  Class.forName("com.mysql.cj.jdbc.Driver");
	String url = "jdbc:mysql://localhost:3306/LoginApplication";
	String user = "root";
	String password ="abhishek@2002";
	Connection	connect= DriverManager.getConnection(url,user,password);
	String sql = "INSERT INTO personalinfo (uname, email, upassword, ucity) "
	           + "VALUES (?, ?, ?, ?)";

	 PreparedStatement pstm =connect.prepareStatement(sql);
	 pstm.setString(1, uname);
	 pstm.setString(2, emailId);
	 pstm.setString(3, upassword); 
	 pstm.setString(4, ucity);
	int rowAff =pstm.executeUpdate();

		
  	PrintWriter writer = response.getWriter();
  	if (rowAff != 0) {
  	    writer.println("<div style='display: flex; align-items: center; justify-content: center; height: 100vh; background-color: #f0f8ff;'>");
  	    writer.println("<h1 style='color: green; font-family: Arial, sans-serif; border: 2px solid green; padding: 20px; border-radius: 10px;'>Registration Success!</h1>");
  	    writer.println("</div>");
  	} else {
  	    writer.println("<div style='display: flex; align-items: center; justify-content: center; height: 100vh; background-color: #f0f8ff;'>");
  	    writer.println("<h1 style='color: red; font-family: Arial, sans-serif; border: 2px solid red; padding: 20px; border-radius: 10px;'>Registration Failed!</h1>");
  	    writer.println("</div>");
  	}

  	
  	  pstm.close();
  	  connect.close();
	
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
		System.out.println(e);
	} catch (SQLException e) {
		e.printStackTrace();
	}
      
	}

}
