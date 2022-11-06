<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 10/6/2022
  Time: 2:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login Form</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <form action="login" method="get">
        <div class="box">
            <div class="form">
                <h2>Sign in</h2>
                <div class="inputBox">
                    <input name="user" type="text" required="required">
                    <span>Username</span>
                    <i></i>
                </div>
                <div class="inputBox">
                    <input name="password" type="password" required="required">
                    <span>password</span>
                    <i></i>
                </div>
                <div class="links">
                    <a href="#">Forgot Password</a>
                    <a href="#">Signup</a>
                </div>
                <input type="submit" value="Login">
            </div>
        </div>
    </form>
</body>
</html>
