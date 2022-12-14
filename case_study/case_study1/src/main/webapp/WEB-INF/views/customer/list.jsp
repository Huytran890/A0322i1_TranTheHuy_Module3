<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: linht
  Date: 9/14/2022
  Time: 7:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>Product list</title>
    <jsp:include page="/WEB-INF/views/layout/header.jsp" />
</head>
<body>
    <jsp:include page="/WEB-INF/views/layout/page-loader.jsp" />
    <jsp:include page="/WEB-INF/views/layout/navbar.jsp" />
    <jsp:include page="/WEB-INF/views/layout/sidebar.jsp" />
    <section class="content">
        <div class="container-fluid">
            <!-- Vertical Layout -->
            <div class="row clearfix">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="card">
                        <div class="header">
                            <h2>Customer list</h2>
                        </div>
                        <div class="body table-responsive">
                            <a href="/product?action=create" class="btn btn-primary btn-custom">
                                <i class="fa fa-plus-circle" aria-hidden="true"></i> Add new customer
                            </a>
                            <table class="table table-striped" id="dataTable-listStudent">
                                <thead>
                                <tr>
                                    <th>No</th>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Date Of Birth</th>
                                    <th>Gender</th>
                                    <th>Identity card</th>
                                    <th>Phone number</th>
                                    <th>Email</th>
                                    <th>Address</th>
                                </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${products}" varStatus="item">
                                        <tr>
                                            <td>${item.count}</td>
                                            <td>${item.current.id}</td>
                                            <td>${item.current.customerName}</td>
                                            <td>${item.current.customerBirthday}</td>
                                            <td>${item.current.customerGender}</td>
                                            <td>${item.current.customerIdentityCard}</td>
                                            <td>${item.current.customerPhone}</td>
                                            <td>${item.current.customerEmail}</td>
                                            <td>${item.current.customerAddress}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <jsp:include page="/WEB-INF/views/layout/script.jsp" />
    <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
</body>
</html>
