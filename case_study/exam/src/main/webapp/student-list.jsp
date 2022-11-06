<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Product Management Application</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
    <link rel="script" href="./asset/fontawesome-free-6.2.0-web/js/all.min.js">
    <link rel="stylesheet" href="./asset/fontawesome-free-6.2.0-web/css/all.min.css">
    <style>
        .btn__edit {
            text-decoration: none !important;
            outline: none;
            color: white;
        }
        .function {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .search-box {
            display: inline-block;
            position: absolute;
            top: 23.5%;
            left: 75%;
            transform: translate(-50%, -50%);
            background: #2f3640;
            height: 48px;
            border-radius: 40px;
            padding: 10px;
            text-decoration: none;
            outline: none;
        }

        .search-box:hover > .search-txt{
            width: 260px;
            padding: 0 6px;
            overflow: hidden;
        }

        .search-box:hover > .search-btn{
            background: white;
            position: absolute;
            top: 6px;
            right: 12px;
        }

        .search-btn {
            color: #e84118;
            float: right;
            width: 38px;
            height: 38px;
            border-radius: 50%;
            background: #2f3640;
            text-align: center;
            display: flex;
            justify-content: center;
            align-items: center;
            transition: 0.4s;
            position: relative;
            top: -2px;
        }

        .search-btn-link {
           font-size: 20px;
            text-decoration: none;
            outline: none;
        }

        .search-txt {
            border: none;
            background: none;
            outline: none;
            text-decoration: none;
            float: left;
            padding: 0;
            color: white;
            font-size: 16px;
            transition: 0.4s;
            line-height: 30px;
            width: 0px;
            overflow: hidden;
        }

        /*.text {*/
        /*    position: absolute;*/
        /*    left: 50%;*/
        /*    top: 50%;*/
        /*    background-size: 300%;*/
        /*    transform: translate(-50%, -50%);*/
        /*    background: linear-gradient(-45deg, #DFB79E, #DFB79E, #2B0413, #2B0413, #E25D52, #E25D52);*/
        /*    font-weight: 900;*/
        /*    letter-spacing: -5px;*/
        /*    text-transform: uppercase;*/
        /*    -webkit-background-clip: text;*/
        /*    -webkit-text-fill-color: transparent;*/
        /*    animation: animate_text 6s ease-in-out infinite;*/
        /*    -webkit-animation: animate_text 6s ease-in-out infinite;*/
        /*}*/
        /*@keyframes animate_text {*/
        /*    0% {*/
        /*        background-position: 0px 50%;*/
        /*    }*/
        /*    50% {*/
        /*        background-position: 100% 50%;*/
        /*    }*/
        /*    100% {*/
        /*        background-position: 0px 50%;*/
        /*    }*/
        /*}*/

    </style>
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: blue">
        <div>
            <a href="#" class="navbar-brand"> Students
                Management Application </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/student?action=list"
                   class="nav-link">Students</a></li>
        </ul>
    </nav>
</header>
<br>

<div class="row">
    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

    <div class="container">
        <h3 class="text-center text">List of Students</h3>
        <hr>
        <span class="function">
            <div class="container w-300">
                <a href="<%=request.getContextPath()%>/student-create.jsp" class="btn btn-success">Add
                    New Students</a>
            </div>

            <form action="/student">
                <div class="search-box">
                    <input type="hidden" name="action" value="search">
                    <input class="search-txt" type="text" name="name" placeholder="Type to search">
                    <a href="#" class="search-btn" type="submit">
                        <i class="fa fa-magnifying-glass search-btn-link"></i>
                    </a>
                </div>
            </form>
        </span>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Gender</th>
                <th>Date Of Birth</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="student" items="${ListStudent}">

                <tr>
                    <td><c:out value="${student.id}" /></td>
                    <td><c:out value="${student.name}" /></td>
                    <td>
                        <c:if test="${student.gender == 1}" >Male</c:if>
                        <c:if test="${student.gender == 0}" >Female</c:if>
                    </td>
                    <td><c:out value="${student.dob}" /></td>
                    <td>
<%--                        <a href="/product?action=edit&id=<c:out value='${product.id}' />">Edit</a>--%>
<%--                        <a href="delete?id=<c:out value='${product.id}' />">Delete</a></td>--%>
                            <button type="button" class="btn btn-warning">
                                <a class="btn__edit" href="/student?action=edit&id=<c:out value='${student.id}' />">Edit</a>
                            </button>
                            <button onclick="deleteStudentModal(${student.id}, '${student.name}')" type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal">
                                Delete
                            </button></td>
                </tr>
            </c:forEach>

            </tbody>

        </table>

        <form action="/student">
            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Delete Students?</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <input type="hidden" name="id" id="idUserDelete">
                            <input type="hidden" name="action" value="delete">
                            Do you want to delete this Student? <br>
                            User id: <span id="idUser"></span> <br>
                            User name: <span id="nameUser"></span>
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
</div>
</body>
    <script>
        function deleteStudentModal(id, name) {
            document.getElementById("idUser").innerText = id;
            document.getElementById("idUserDelete").value = id;
            document.getElementById("nameUser").innerText = name;
        }
    </script>
</html>