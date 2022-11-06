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
            <a href="#" class="navbar-brand"> Product Management Application </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/product?action=list"
                   class="nav-link">Products</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
                <c:if test="${product == null}">
                <form action="product?action=insert" method="post">
                    </c:if>

                    <caption>
                        <h2>
                            <c:if test="${product == null}">
                                Add New Product
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${product != null}">
                        <input type="hidden" name="id" value="<c:out value='${product.id}' />" />
                    </c:if>

<%--                        <div style="display: none" id="show-alert" class="alert alert-success">--%>
<%--                            <strong>Success Creating!</strong>--%>
<%--                        </div>--%>
                        <div class="alert alert-info  alert-dismissible">
                            <strong>Hi Tran!</strong> Welcome back!
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">&times;</button>
                        </div>

                    <fieldset class="form-group">
                        <label>Product Name</label> <input type="text"
                                                        value="<c:out value='${product.name}' />" class="form-control"
                                                        name="name" required="required" pattern="[A-Za-z0-9]{1,15}">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Product Price</label> <input type="number"
                                                         value="<c:out value='${product.price}' />" class="form-control"
                                                         name="price" required="required" min="100">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Product quantity</label> <input type="number"
                                                           value="<c:out value='${product.quantity}' />" class="form-control"
                                                           name="quantity" required="required" min="1">
                    </fieldset>

                        <fieldset class="form-group">
<%--                            <label>Product Color</label>--%>
<%--                            <input type="text" value="<c:out value='${product.color}' />" class="form-control dropdown-toggle"--%>
<%--                                                                name="color" required="required">--%>
                            <label for="inputState">Product Color</label>
                            <select id="inputState" class="form-control" name="color"
                                    value="<c:out value='${product.color}' />">
                                <option selected>Choose...</option>
                                <option>Red</option>
                                <option>Green</option>
                                <option>Yellow</option>
                            </select>
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Product Description</label> <textarea type="textarea"
                                                                         value="<c:out value='${product.description}' />" class="form-control"
                                                                         name="description" required="required" pattern="[a-z]{1,15}">

                                                                </textarea>
                        </fieldset>

                        <fieldset class="form-group">
<%--                            <label>Product Category</label> <input type="text"--%>
<%--                                                                value="<c:out value='${product.id_category}' />" class="form-control"--%>
<%--                                                                name="id_category" required="required">--%>
                            <label for="inputState">Product Category</label>
                            <select id="inputState" class="form-control" name="id_category"
                                    value="<c:out value='${product.id_product}' />">
                                <option selected>Choose...</option>
                                <option value="1">Iphone</option>
                                <option value="2">Laptop</option>
                                <option value="3">Television</option>
                            </select>
                        </fieldset>

                        <button id="btn1" onclick="show_alert()" type="submit" class="btn btn-success col-sm-3 ">Save</button>

                        <a href="<%=request.getContextPath()%>/product?action=list" type="button" class="btn btn-outline-success col-sm-3">
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