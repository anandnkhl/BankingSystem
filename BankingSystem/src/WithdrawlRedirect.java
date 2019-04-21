

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class WithdrawlRedirect
 */
@WebServlet("/WithdrawlRedirect")
public class WithdrawlRedirect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WithdrawlRedirect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int withdrawalAmount = 0;
		String Page ="home.jsp";
		PrintWriter out = response.getWriter();
		out.println("Amount to withdraw " + withdrawalAmount);
		String name = request.getSession().getAttribute("Name").toString();
		String uid = request.getSession().getAttribute("UID").toString();
		
		try {
			withdrawalAmount = Integer.parseInt(request.getParameter("withdrawalAmount"));
		}catch (Exception e) {
			out.println(e);
			Page = "withdraw.jsp";
		}
		
		
		
		//db connection
 
		try{  
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","12345678");
			Statement stmt = con.createStatement();  
			ResultSet rs=stmt.executeQuery("select Bal from bankdetails where UID = '"+uid+"' and name ='"+name+"';");
			int currBal = 0;
			if(rs.next()){
				currBal = rs.getInt("Bal");
				currBal -= withdrawalAmount;
				stmt.executeUpdate("UPDATE `bank`.`bankdetails` SET `Bal` = '"+ currBal +"' WHERE (`UID` = '"+ uid +"');");
				}
			else{
				Page ="Error.jsp";
			}
		}
		catch (Exception e){ out.println("Exception"+e);
		}
		
		
		response.sendRedirect(Page);
	}

}
