<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 9/22/2022
  Time: 8:23 PM
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
    <h1 style="text-align: center">User Management</h1>
    <h2 style="text-align: center">
        <a href="/users?action=create">Add New User</a>
    </h2>
    <form action="/users" style="text-align: center">
        <input type="hidden" name="action" value="search">
        <input type="text" name="country">
        <input type="submit" value="Seach by country">
    </form>
    <form action="/users" style="padding-left:666px ">
        <input type="hidden" name="action" value="sort">
        <button type="submit">Sort by name</button>
    </form>
    <div align="center">
        <table  class="table" border="1" style="width: 100%;margin: auto">
            <div align="left" style="color: #333333;"><h2>List of Users</h2></div>
            <head>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Country</th>
                    <th>Actions</th>
                </tr>
            </head>
            <body>
            <c:forEach var="user" items="${listUser}">
                <tr>
                    <td><c:out value="${user.id}"/></td>
                    <td><c:out value="${user.name}"/></td>
                    <td><c:out value="${user.email}"/></td>
                    <td><c:out value="${user.country}"/></td>
                    <td>
                        <a href="/users?action=edit&id=${user.id}">Edit</a>
                        <button onclick="deleteUserModal(${user.id},'${user.name}')" type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal">
                            Delete
                        </button>
                    </td>
                </tr>
            </c:forEach>
            </body>
        </table>
        <form action="/users">
            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Delete user?</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <input type="hidden" name="id" id="idUserDelete">
                            <input type="hidden" name="action" value="delete">
                            Do you want to delete this user? <br>
                            User id: <p id="idUser"></p>
                            User name: <p id="nameUser"></p>
                            <p>Can not undo</p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-primary">Delete</button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</body>
    <script>
        function deleteUserModal(id, name) {
            document.getElementById("idUser").innerText = id;
            document.getElementById("idUserDelete").value = id;
            document.getElementById("nameUser").innerText = name;
        }
    </script>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</html>
