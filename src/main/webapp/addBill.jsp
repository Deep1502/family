<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.deep.customer.Customer" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Add Bill</title>
</head>
<body>
	<div style="text-align: center">
        <h1>Welcome to Family Management Website Admin Panel</h1>
        <b>This page is for admin.</b>
        <br><br>
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
        			out.print("<br>"+session.getAttribute("message"));
        %>
        <br><br>
        <form action="addbill" method="post">
        	Bill ID: <input type="text" name="id"><br><br>
        	Type: <input type="text" name="type"><br><br>
        	Amount: <input type="number" name="amount"><br><br>
        	<input type="submit" value="Add">
        </form><br><br>
        <a href="adminhome.jsp">Back to home</a>
        <%}} %>
    </div>
</body>
</html>