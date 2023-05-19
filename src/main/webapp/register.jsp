<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Registration</title>
</head>
<body>
	<div style="text-align: center">
        <h1>Welcome to Family Management Website Registration Page</h1>
        <b>This page is for customers.</b>
        <br><br>
        <form action="register" method="post">
        	ID: <input type="text" name="id"><br><br>
        	Name: <input type="text" name="name"><br><br>
        	Password: <input type="password" name="password"><br><br>
        	<input type="submit" value="Register">
        </form>
    </div>
</body>
</html>