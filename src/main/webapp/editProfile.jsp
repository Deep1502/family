<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="com.deep.customer.Customer" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Edit Profile</title>
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
        			
        			out.print("<br><br>"+session.getAttribute("message"));
        %>
        <form action="editProfile" method="post">
        	Name: <input type="text" name="name"><br><br>
        	Password: <input type="password" name="password"><br><br>
        	<input type="submit" value="Edit my profile">
        </form>
        <br>
        <a href="home.jsp">Back to home page</a>
        <%}} %>
    </div>
</body>
</html>