<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 9/17/2022
  Time: 9:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Trang chu</title>
</head>
<body>
    <h1>Hello User</h1>
    <p>Information of Student</p>
    <p>ID: ${models.getId()}</p>
    <p>Name :${models.getFullName()}</p>
</body>
</html>
