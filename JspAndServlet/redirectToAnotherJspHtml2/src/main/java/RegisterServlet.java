

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RegisterServlet() {
        System.out.println("Servvlet object us created internally by contienr itself");

    }


//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}


    public void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException ,IOException{

        
        String name = request.getParameter("uname");
        String city = request.getParameter("ucity");
        
        System.out.println("Name "+name+" "+"City "+city);
        
      response.sendRedirect("/redirectToAnotherJspHtml/success.jsp");
        
        
        
        
        
//        writer.println("<html><head><title>Second App</title></head>");
//        writer.println("<body bgcolor='cyan'>");
//        writer.println("<h1><marquee>Welcome to our dynamic app</marquee></h1>");
//        writer.println("<table border='1' cellspacing='5' cellpadding='10'>");
//        writer.println("<tr><th>Name</th><th>City</th></tr>");
//        writer.println("<tr><td>" + name + "</td><td>" + city + "</td></tr>");
//        writer.println("</table>");
//        writer.println("</body>");
//        writer.println("</html>");
//        writer.close();

    }
    

}
