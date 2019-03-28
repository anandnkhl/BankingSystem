

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Servlet1() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String n = request.getParameter("name");
		String r = request.getParameter("roll");
		Cookie ck = new Cookie("name","Nikhil");
		response.addCookie(ck);
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<br> Welcome " + n);
		out.println("<br> Your roll no is " + r);
		out.println("</body></html>");
		
	}

}
