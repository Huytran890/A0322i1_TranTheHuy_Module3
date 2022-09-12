<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 9/11/2022
  Time: 2:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Calculator Discount</title>
  </head>
  <body>
  <form action="/ProductDiscountCalculatorServlet" method="post">
    <label>Product Description:</label>
    <input type="text" name="product_description" placeholder="Enter product description:">
    <br>
    <label>List Price:</label>
    <input type="text" name="list_price" placeholder="Enter list price:">
    <br>
    <label>Discount Percent:</label>
    <input type="text" name="discount_percent" placeholder="Enter discount percent:">
    <br>
    <input type="submit" value="Submit">
  </form>
  </body>
</html>
