<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Login Page</title>
</head>
<body>
	<div style="text-align: center">
        <h1>Login</h1>
        <form action="login" method="post">
            <label for="name">Name:</label>
            <input type="text" name="name" />
            <br><br>
            <label for="password">Password:</label>
            <input type="password" name="password" />
            <br>
            <br><br>
            <button type="submit">Login</button>
        </form>
        <p>To register yourself: <a href="register.jsp" title="Registration">Register</a></p>
    </div>
</body>
</html>