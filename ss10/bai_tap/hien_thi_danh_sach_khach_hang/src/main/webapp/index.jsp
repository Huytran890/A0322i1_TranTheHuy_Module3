<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 9/12/2022
  Time: 2:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
  </head>
  <body>
  <table class="table table-striped">
    <tr class="row">
      <th class="col-3">Tên</th>
      <th class="col-3">Ngày sinh nhật</th>
      <th class="col-3">Địa chỉ</th>
      <th class="col-3">Ảnh</th>
    </tr>
    <c:forEach var="customer" items="${customers}">
      <tr class="row">
        <td class="col-3">${customer.name}</td>
        <td class="col-3">${customer.dayOfBirth}</td>
        <td class="col-3">${customer.address}</td>
        <td class="col-3"><img src="${customer.picture}" alt="" width="40px"></td>
      </tr>
    </c:forEach>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </table>
  </body>
</html>
