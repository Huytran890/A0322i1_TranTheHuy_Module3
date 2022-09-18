<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 9/12/2022
  Time: 7:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>$Title$</title>
</head>
<body>
  <form method="post" action="/calculate">
    <h1>Simple Calculator</h1>
    <fieldset>
      <legend>Calculator</legend>
      <table>
        <tr>
          <td>First operand:</td>
          <td><input name="first-operand" type="text"/></td>
        </tr>
        <tr>
          <td>Operator:</td>
          <td>
            <select name="operator">
              <option value="+">Addition</option>
              <option value="-">Subtraction</option>
              <option value="*">Multiplication</option>
              <option value="/">Division</option>
            </select>
          </td>
        </tr>
        <tr>
          <td>Second operand:</td>
          <td><input name="second-operand" type="text"/></td>
        </tr>
        <tr>
          <td></td>
          <td><input type="submit" value="Calculate"/></td>
        </tr>
      </table>
    </fieldset>
  </form>
</body>
</html>
