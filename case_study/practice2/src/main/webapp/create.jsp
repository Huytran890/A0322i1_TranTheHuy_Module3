<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Products Management Application</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: blue">
        <div>
            <a href="#" class="navbar-brand"> Rooms Management Application </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/room?action=list"
                   class="nav-link">Rooms</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${room == null}">
            <form action="room?action=insert" method="post">
                </c:if>

                <caption>
                    <h2>
                        <c:if test="${room == null}">
                            Add New Room
                        </c:if>
                    </h2>
                </caption>

                <c:if test="${room != null}">
                    <input type="hidden" name="id_room" value="<c:out value='${room.roomID}' />" />
                </c:if>

                <%--                        <div style="display: none" id="show-alert" class="alert alert-success">--%>
                <%--                            <strong>Success Creating!</strong>--%>
                <%--                        </div>--%>
                <div style="display: none" class="alert alert-info  alert-dismissible">
                    <strong>Success Creating</strong> Welcome back!
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">&times;</button>
                </div>

                <fieldset class="form-group">
                    <label>Name Customer</label> <input type="text"
                                                       value="<c:out value='${room.nameCustomer}' />" class="form-control"
                                                       name="name_customer" required="required">
                </fieldset>
<%--                    pattern="[A-Za-z]{5,60}--%>

                <fieldset class="form-group">
                    <label>Phone Number</label> <input type="text"
                                                        value="<c:out value='${room.phoneNumberCustomer}' />" class="form-control"
                                                        name="phone_number" required="required">
                </fieldset>

                <fieldset class="form-group">
                    <label>Date Begin Rentment</label> <input type="date"
                                                           value="<c:out value='${room.dateRent}' />" class="form-control"
                                                           name="date_begin" required="required">
                </fieldset>

                <fieldset class="form-group">
                    <%--                            <label>Product Color</label>--%>
                    <%--                            <input type="text" value="<c:out value='${product.color}' />" class="form-control dropdown-toggle"--%>
                    <%--                                                                name="color" required="required">--%>
                    <label for="inputState">Type of Payment</label>
                    <select id="inputState" class="form-control" name="id_payment"
                            value="<c:out value='${room.id_payment}' />">
                        <option selected>Choose...</option>
                        <option value="1">Month</option>
                        <option value="2">Precious</option>
                        <option value="3">year</option>
                    </select>
                </fieldset>

<%--                <fieldset class="form-group">--%>
<%--                    <label>Product Description</label> <textarea type="textarea"--%>
<%--                                                                 value="<c:out value='${product.description}' />" class="form-control"--%>
<%--                                                                 name="description" required="required" pattern="[a-z]{1,15}">--%>

<%--                                                                </textarea>--%>
<%--                </fieldset>--%>

<%--                <fieldset class="form-group">--%>
<%--                    &lt;%&ndash;                            <label>Product Category</label> <input type="text"&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                                                                value="<c:out value='${product.id_category}' />" class="form-control"&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                                                                name="id_category" required="required">&ndash;%&gt;--%>
<%--                    <label for="inputState">Product Category</label>--%>
<%--                    <select id="inputState" class="form-control" name="id_category"--%>
<%--                            value="<c:out value='${product.id_product}' />">--%>
<%--                        <option selected>Choose...</option>--%>
<%--                        <option value="1">Iphone</option>--%>
<%--                        <option value="2">Laptop</option>--%>
<%--                        <option value="3">Television</option>--%>
<%--                    </select>--%>
<%--                </fieldset>--%>

                <button id="btn1" onclick="show_alert()" type="submit" class="btn btn-success col-sm-3 ">Save</button>

                <a href="<%=request.getContextPath()%>/room?action=list" type="button" class="btn btn-outline-success col-sm-3">
                    Cancel
                </a>
            </form>
        </div>
    </div>
</div>
</body>
<script>
    document.getElementById("btn1").onclick = function () {
        document.getElementById("show-alert").style.display = 'block';
    };
</script>
</html>