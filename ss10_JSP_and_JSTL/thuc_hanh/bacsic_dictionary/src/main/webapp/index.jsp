<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 9/16/2022
  Time: 5:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>Simple Dictionary</title>
  </head>
  <body>
    <h2>Vietnamese Dictionary</h2>
    <form action="dictionary.jsp" method="post">
      <input type="text" name="search" placeholder="Enter your word: "/>
      <input type = "submit" id = "submit" value = "Search"/>
    </form>
  </body>
</html>
