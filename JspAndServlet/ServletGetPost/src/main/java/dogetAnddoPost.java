

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/servlet")
public class dogetAnddoPost extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public dogetAnddoPost() {
    }


	public  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   System.out.println("Control in Servlet/contriller");
		
	String name = request.getParameter("uname");
   String city = request.getParameter("ucity");
   
   if(name.equals("Rohan") && city.equals("Pune")) {
	   System.out.println("Success he is the right rohan loogged in");
   }else {
	   System.out.println("Differnt person logged in");
   }
   
	}




}
