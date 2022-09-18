<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 9/16/2022
  Time: 1:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Delete product</h1>
    <p>
        <a href="/product">Back to product list</a>
    </p>
    <form method="post">
        <h3>Are you sure?</h3>
        <fieldset>
            <legend>Product information</legend>
            <table>
                <tr>
                    <td>Name:</td>
                    <td>${product.getNameProduct()}</td>
                </tr>
                <tr>
                    <td>Price:</td>
                    <td>${product.getPriceProduct()}</td>
                </tr>
                <%--  OR  --%>
                <tr>
                    <td>Description:</td>
                    <td>${requestScope["product"].getDescriptionProduct()}</td>
                </tr>
                <tr>
                    <td>Producer:</td>
                    <td>${requestScope["product"].getProducer()}</td>
                </tr>
                <tr>
                    <td><input type="submit" value="Delete product"></td>
                    <td><a href="/product">Back to product list</a></td>
                </tr>
            </table>
        </fieldset>
    </form>
</body>
</html>
