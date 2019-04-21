<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Deposit Money - Anand Bank</title>
</head>
<body>
<%
String name = session.getAttribute("Name").toString();
out.println("<center>");
out.println(name + ", Please enter the amount you want to deposit: <br>");
out.println("<form action = 'DepositlRedirect' method = 'POST'>");
out.println("<input type = 'number' name = 'depositAmount'>");
out.println("<input type = 'submit' value = 'deposit'>");
out.println("</form>");
%>
</body>
</html>