import java.io.IOException;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ServlterLife")
public class ServlterLife extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
         static {
        	   System.out.println("Servlet is loaded");
         }
         
    public ServlterLife() {
    	System.out.println("Servelt object is created");
    }
  
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Servlet is initialized");
	
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Service meathod to hanlde http  request and to response back");
	}
	

	public void destroy() {
		
	}

}
