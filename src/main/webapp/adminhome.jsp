<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.deep.customer.Customer" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Homepage</title>
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
        <a href="addProduct.jsp">Add Product</a><br><br>
        <a href="viewCustomer.jsp">View Customers</a><br><br>
        <a href="downloadinventory">Download Inventory</a><br><br>
        <a href="logout">Logout</a>
        <%}} %>
    </div>
</body>
</html>