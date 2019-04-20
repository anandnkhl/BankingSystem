<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import = "java.io.*,java.util.*,java.sql.*,javax.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="com.mysql.jdbc.Driver.*"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Anand Bank</title>
</head>
<body><center><br><br>
<%
Class.forName("com.mysql.jdbc.Driver"); 
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","12345678"); 
try{
	String Name = session.getAttribute("Name").toString();
	String UID = session.getAttribute("UID").toString();
	Statement stmt = con.createStatement();  
	ResultSet rs=stmt.executeQuery("select Bal from bankdetails where UID = '"+UID+"' and name ='"+Name+"';");
	rs.next();
	int Bal =  rs.getInt("Bal");
	out.println("Welcome " + Name);
	out.println("<br><br>");
	out.println("Your account balance is Rs. "+ Bal);
	out.println("<br><br>");
	out.println("<table><tr><td>");
	out.println("<form method ='POST' action ='deposit.jsp'>");
	out.println("<input type ='submit' value='Deposit Money'></form></td>");
	out.println("<td><form method ='POST' action ='withdraw.jsp'>");
	out.println("<input type ='submit' value = 'Withdraw Money'></form></td></tr>");

} catch (Exception e){
	out.println("Your session ended, please login again!");
	out.println("<a href = 'Login.html'>Click here to login again</a><br>");
	//out.println(e);
}
%>
</center></body>
</html>