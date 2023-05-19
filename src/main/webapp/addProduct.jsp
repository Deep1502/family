<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.deep.customer.Customer" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Add Product</title>
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
        %>
        <br><br>
        <form action="addproduct" method="post">
        	<input type="radio" name="type" value="grocery">Grocery
        	<input type="radio" name="type" value="bill">Bill
        	<input type="radio" name="type" value="insurance">Insurance<br><br>
        	<input type="submit" value="Submit">
        </form><br><br>
        <a href="adminhome.jsp">Back to home</a>
        <%}} %>
    </div>
</body>
</html>