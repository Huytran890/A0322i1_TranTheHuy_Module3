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
            <a href="#" class="navbar-brand"> Student Management Application </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/student?action=list"
                   class="nav-link">Students</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${student != null}">
            <form action="student?action=update" method="post">
                </c:if>
                <caption>
                    <h2>
                        <c:if test="${student != null}">
                            Edit Student
                        </c:if>
                    </h2>
                </caption>

                <c:if test="${student != null}">
                    <input type="hidden" name="id" value="<c:out value='${student.id}' />" readonly/>
                </c:if>

                <fieldset class="form-group">
                    <label>Student Name</label> <input type="text"
                                                       value="<c:out value='${student.name}' />" class="form-control"
                                                       name="name" required="required">
                </fieldset>

                <fieldset class="form-group">
<%--                    <label>Student Gender</label> <input type="text"--%>
<%--                                                        value="<c:out value='${student.price}' />" class="form-control"--%>
<%--                                                        name="price" required="required">--%>
                    <div>Student Gender</div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="gender" value="<c:out value='1' />" id="flexRadioDefault1" checked>
                        <label class="form-check-label" for="flexRadioDefault1">
                            Male
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="gender" value="<c:out value='0'/>" id="flexRadioDefault2">
                        <label class="form-check-label" for="flexRadioDefault2">
                            Female
                        </label>
                    </div>
                </fieldset>

                <fieldset class="form-group">
                    <label>Date Of Birth</label> <input type="date"
                                                          value="<c:out value='${student.dob}' />"
                                                          class="form-control"
                                                          name="dob" required="required">
                </fieldset>

                <button type="submit" class="btn btn-success">Save</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
