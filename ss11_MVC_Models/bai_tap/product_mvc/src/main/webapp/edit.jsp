<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 9/16/2022
  Time: 1:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Edit product</h1>
    <p>
        <a href="/product">Back to product list</a>
    </p>
    <form method="post">
        <fieldset>
            <legend>Product information</legend>
            <table>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name" id="name" value="${requestScope["product"].getNameProduct()}"></td>
                </tr>
                <tr>
                    <td>Price:</td>
                    <td><input type="text" name="price" id="price" value="${requestScope["product"].getPriceProduct()}">
                    </td>
                </tr>
                <tr>
                    <td>Description:</td>
                    <td><input type="text" name="description" id="description"  value="${requestScope["product"].getDescriptionProduct()}"></td>
                </tr>
                <tr>
                    <td>Producer</td>
                    <td><input type="text" name="producer" id="producer" value="${requestScope["product"].getProducer()}">
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Update product"></td>
                </tr>
            </table>
        </fieldset>
    </form>
</body>
</html>
