<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import = "java.io.*,java.util.*,java.sql.*,javax.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="com.mysql.jdbc.Driver.*"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Redirecting...</title>
</head>
<body>
<%
String UID = request.getParameter("UID");
String password = request.getParameter("password");
Class.forName("com.mysql.jdbc.Driver"); 
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","12345678"); 
try{  
	Statement stmt = con.createStatement();  
	ResultSet rs=stmt.executeQuery("select Name from bankdetails where UID = '"+UID+"' and password ='"+password+"';");
	String Name = null;
	if(rs.next()){
		Name = rs.getString("Name");
		out.println("<br> Welcome " + Name + "<br>");
		session.setAttribute("Name", Name);
		session.setAttribute("UID", UID);
		response.sendRedirect("home.jsp");
		}
	else{
		response.sendRedirect("Error.jsp");
	}
	}catch (Exception e){ out.println("Exception"+e);
}
finally{
	con.close();
}
%>
<br> Welcome<br>
</body>
</html>