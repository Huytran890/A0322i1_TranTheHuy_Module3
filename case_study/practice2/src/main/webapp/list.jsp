<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Rooms Management Application</title>
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
            align-items: center;
        }
        #f {
            margin-bottom: 0px;
        }
        .search-box {
            display: inline-block;
            position: absolute;
            top: 23.8%;
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
            top: -4px;
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

    </style>
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: blue">
        <div>
            <a href="#" class="navbar-brand"> Room
                Management Application </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/room?action=list"
                   class="nav-link">Rooms</a></li>
        </ul>
    </nav>
</header>
<br>

<div class="row">
    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

    <div class="container">
        <h2 class="text-center">List of Rooms</h2>
        <hr>
        <div class="function">
            <span>
                <a href="<%=request.getContextPath()%>/create.jsp" class="btn btn-success mb-3 mr-3 mt-2" role="button">
                    Add New Rooms</a>
            </span>
<%--            <form action="/room" id="f">--%>
<%--                <input type="hidden" name="action" value="sort">--%>
<%--                &lt;%&ndash;                <a href="<%=request.getContextPath()%>/product-list.jsp" class="btn btn-primary mb-2 mt-2" role="button">Sort Products</a>&ndash;%&gt;--%>
<%--                <button class="btn btn-primary mb-3 mt-2" type="submit">Sort Products</button>--%>
<%--            </form>--%>

            <form action="/room">
                <div class="search-box">
                    <input type="hidden" name="action" value="search">
                    <input class="search-txt" type="text" name="name_customer" placeholder="Type to search">
                    <a href="#" class="search-btn" type="submit">
                        <i class="fa fa-magnifying-glass search-btn-link"></i>
                    </a>
                </div>
            </form>
        </div>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name Customer</th>
                <th>Phone Number</th>
<%--                <th>Quantity</th>--%>
                <th>Date Begin Rentment</th>
                <th>Type of Payment</th>
<%--                <th>Description</th>--%>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="room" items="${listRoom}">

                <tr>
                    <td><c:out value="${room.roomID}" /></td>
                    <td><c:out value="${room.nameCustomer}" /></td>
                    <td><c:out value="${room.phoneNumberCustomer}" /></td>
                    <td><c:out value="${room.dateRent}" /></td>
<%--                    <td><c:out value="${room.color}" /></td>--%>
                    <td><c:out value="${room.name_payment}" /></td>
<%--                    <td><c:out value="${room.description}" /></td>--%>
                    <td>
                            <%--                        <a href="/product?action=edit&id=<c:out value='${product.id}' />">Edit</a>--%>
                            <%--                        <a href="delete?id=<c:out value='${product.id}' />">Delete</a></td>--%>
                        <button type="button" class="btn btn-warning">
                            <a class="btn__edit" href="/room?action=edit&id=<c:out value='${room.roomID}' />">Edit</a>
                        </button>
                        <button onclick="deleteRoomtModal(${room.roomID}, '${room.nameCustomer}')" type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal">
                            Delete
                        </button></td>
                </tr>
            </c:forEach>

            </tbody>

        </table>

        <form action="room">
            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Delete Rooms?</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <input type="hidden" name="id_room" id="idUserDelete">
                            <input type="hidden" name="action" value="delete">
                            Do you want to delete this Room? <br>
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
    function deleteRoomtModal(id, name) {
        document.getElementById("idUser").innerText = id;
        document.getElementById("idUserDelete").value = id;
        document.getElementById("nameUser").innerText = name;
    }
</script>
</html>