<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.deep.customer.Customer" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Home</title>
</head>
<body>
	<div style="text-align: center">
        <h1>Welcome to Family Management Website Customer Panel</h1>
        <b>This page is for customers.</b>
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
        <a href="editProfile.jsp">Edit Profile</a><br><br>
        <a href="showOrders.jsp">Show my orders</a><br><br>
        <a href="logout">Logout</a>
        <%}} %>
    </div>
</body>
</html>