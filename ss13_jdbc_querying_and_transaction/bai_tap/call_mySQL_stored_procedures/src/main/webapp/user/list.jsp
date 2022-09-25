<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 9/24/2022
  Time: 7:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
</head>
<body>
    <center>
        <h1>User Management</h1>
        <form action="/users?action=search" method="post">
            <input type="text" name="search" placeholder="search">
            <input type="submit" value="search">
        </form>
        <h2>
            <a href="/users?action=create">Add New User</a>
        </h2>
    </center>
    <div align="center">
        <table class="table table-striped m-4">
            <caption><h2>List of Users</h2></caption>
            <tr class="row">
                <th class="col-1">ID</th>
                <th class="col-3">Name</th>
                <th class="col-3">Email</th>
                <th class="col-3">Country</th>
                <th class="col-2">Actions</th>
            </tr>
            <c:forEach var="user" items="${listUser}">
                <tr class="row">
                    <td class="col-1"><c:out value="${user.id}"/></td>
                    <td class="col-3"><c:out value="${user.name}"/></td>
                    <td class="col-3"><c:out value="${user.email}"/></td>
                    <td class="col-3"><c:out value="${user.country}"/></td>
                    <td class="col-2">
                        <a href="/users?action=edit&id=${user.id}"><button class="btn-primary">Edit</button></a>
                        <a href="/users?action=delete&id=${user.id}"><button class="btn-primary">Delete</button></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <link rel="stylesheet" href="/bootstrap-4.0.0-dist/js/bootstrap.bundle.js">
    <link rel="stylesheet" href="/bootstrap-4.0.0-dist/js/bootstrap.js">
</body>
</html>
