<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 10/5/2022
  Time: 5:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Products Management Application</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
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
            <c:if test="${product != null}">
            <form action="product?action=update" method="post">
                </c:if>
                <caption>
                    <h2>
                        <c:if test="${product != null}">
                            Edit Product
                        </c:if>
                    </h2>
                </caption>

                <c:if test="${product != null}">
                    <input type="hidden" name="id" value="<c:out value='${product.id}' />" readonly/>
                </c:if>

                <fieldset class="form-group">
                    <label>Product Name</label> <input type="text"
                                                       value="<c:out value='${product.name}' />" class="form-control"
                                                       name="name" required="required">
                </fieldset>

                <fieldset class="form-group">
                    <label>Product Price</label> <input type="number"
                                                        value="<c:out value='${product.price}' />" class="form-control"
                                                        name="price" required="required" min="100">
                </fieldset>

                <fieldset class="form-group">
                    <label>Product Quantity</label> <input type="number"
                                                           value="<c:out value='${product.quantity}' />"
                                                           class="form-control"
                                                           name="quantity" required="required" min="1">
                </fieldset>

                <fieldset class="form-group">
                    <%--                    <label>Product Color</label> <input type="text"--%>
                    <%--                                                        value="<c:out value='${product.color}' />" class="form-control"--%>
                    <%--                                                        name="color">--%>
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
                    <%--                    <label>Product Category</label> <input type="text"--%>
                    <%--                                                           value="<c:out value='${product.id_category}' />"--%>
                    <%--                                                           class="form-control"--%>
                    <%--                                                           name="id_category" required="required">--%>
                    <label for="inputState">Product Category</label>
                    <select id="inputState" class="form-control" name="id_category"
                            value="<c:out value='${product.id_category}' />">
                        <option selected>Choose...</option>
                        <option value="1">Iphone</option>
                        <option value="2">Laptop</option>
                        <option value="3">Television</option>
                    </select>
                </fieldset>
                <button type="submit" class="btn btn-success">Save</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
