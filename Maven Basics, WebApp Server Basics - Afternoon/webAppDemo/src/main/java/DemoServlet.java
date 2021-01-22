import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoServlet extends HttpServlet {
    private static final long serialVersionUID = -4751096228274971485L;
    @Override
    protected void doGet(HttpServletRequest reqest, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html");  
        response.getWriter().println("<h1>Demo Servlet WebApp<h1><h3> Ajay</h3>");
    }
    @Override
    public void init() throws ServletException {
        System.out.println("Servlet " + this.getServletName() + " has started");
    }
    @Override
    public void destroy() {
        System.out.println("Servlet " + this.getServletName() + " has stopped");
    }
}