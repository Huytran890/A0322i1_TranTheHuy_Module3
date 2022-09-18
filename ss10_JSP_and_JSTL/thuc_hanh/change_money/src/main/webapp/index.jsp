<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 9/16/2022
  Time: 4:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Currency Converter</title>
  </head>
  <body>
    <h2>Currency Converter</h2>
    <form method="post" action="converter.jsp">
      <label>Rate: </label><br/>
      <input type="text" name="rate" placeholder="RATE" value="0"/><br/>
      <label>USD: </label><br/>
      <input type="text" name="usd" placeholder="USD" value="0"/><br/>
      <input type = "submit" id = "submit" value = "Converter"/>
    </form>
  </body>
</html>
