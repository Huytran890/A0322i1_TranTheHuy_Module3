<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 9/12/2022
  Time: 5:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Danh sách khách hàng</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<table class="table table-striped">
    <tr>
        <th colspan="5">THÔNG TIN KHÁCH HÀNG</th>
    </tr>
    <tr class="">
        <th class="">STT</th>
        <th class="">Tên</th>
        <th class="">Ngày sinh nhật</th>
        <th class="">Địa chỉ</th>
        <th class="">Ảnh</th>
    </tr>
    <c:forEach var="customerList" items="${customers}" varStatus="status">
        <tr class="">
            <td>${status.count}</td>
            <td class="">${customerList.name}</td>
            <td class="">${customerList.dayOfBirth}</td>
            <td class="">${customerList.address}</td>
            <td class=""><img src="${customerList.picture}" alt="Ảnh cá nhân" width="80px" height="60px"></td>
        </tr>
    </c:forEach>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</table>
</body>
</html>
