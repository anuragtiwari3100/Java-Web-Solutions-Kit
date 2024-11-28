import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/firstServlet")


public class FirstServletApp extends HttpServlet {
	    public FirstServletApp() {
	    	System.out.println("Servlet Object is created By container interlny");
	    }
	    
	    @Override
	    public void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException ,IOException{

	        // Set content type to HTML
	        response.setContentType("text/html");
	        
	        // Retrieve parameters
	        String name = request.getParameter("uname");
	        String city = request.getParameter("ucity");
	        
	        // Get writer
	        PrintWriter writer = response.getWriter();
	        

	        // Generate styled HTML response
	        writer.println("<html><head><title>Second App</title></head>");
	        writer.println("<body bgcolor='cyan'>");
	        writer.println("<h1><marquee>Welcome to our dynamic app</marquee></h1>");
	        writer.println("<table border='1' cellspacing='5' cellpadding='10'>");
	        writer.println("<tr><th>Name</th><th>City</th></tr>");
	        writer.println("<tr><td>" + name + "</td><td>" + city + "</td></tr>");
	        writer.println("</table>");
	        writer.println("</body>");
	        writer.println("</html>");
	        writer.close();

	    }
}