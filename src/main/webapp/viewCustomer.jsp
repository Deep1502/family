<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.deep.customer.Customer, java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>View Customers</title>
<style>
	table, tr, td, th{
		border: 1px solid black;
		text-align: center;
	}
	table{
		margin-left: auto;
		margin-right: auto;
	}
</style>
</head>
<body>
	<div style="text-align: center">
        <h1>Welcome to Family Management Website Admin Panel</h1>
        <b>This page is for admin.</b>
        <br>
        <% 
        	session=request.getSession(false);
        	if(session==null){
        		out.print("You need to login first. <a href='login.jsp'>Click here</a> to login.");
        	}
        	else{
        		Customer c=(Customer)session.getAttribute("user");
        		if(c==null){
        			out.print("You need to login first. <a href='login.jsp'>Click here</a> to login.");
        		}
        		else{
        			out.print("<br><br>You are logged in as: "+c.getName());
        			out.print("<br><br>");
        			String id=c.getId();
        			String jdbcURL = "jdbc:mysql://localhost:3306/jt_project";
        	        String dbUser = "root";
        	        String dbPassword = "";
        	 
        	        Class.forName("com.mysql.jdbc.Driver");
        	        Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
        	        String sql = "SELECT * FROM customer";
        	        PreparedStatement statement = connection.prepareStatement(sql);
        	 
        	        ResultSet result = statement.executeQuery();
        	        out.print("<table>");
        	        out.print("<tr><th>Customer id</th><th>Name</th><th>Password</th><th>Role</th></tr>");
        	        while(result.next()){
        	        	out.print("<tr>");
        	        	out.print("<td>"+result.getString("id")+"</td><td>"+result.getString("name")+"</td><td>"+result.getString("password")+"</td><td>"+result.getString("role")+"</td>");
        	        	out.print("</tr>");
        	        }
        	        out.print("</table>");
        %>
        <br><br>
        
        <a href="adminhome.jsp">Back to home</a>
        <%}} %>
    </div>
</body>
</html>