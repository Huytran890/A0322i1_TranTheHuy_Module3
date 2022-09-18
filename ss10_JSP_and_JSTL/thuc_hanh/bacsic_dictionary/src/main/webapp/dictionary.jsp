<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<html>
<head>
    <title>Simple Dictionary</title>
</head>
<body>
    <%!
        Map<String, String> dic = new HashMap<>();
    %>
    <%
        dic.put("hello", "Xin chào");
        dic.put("how", "Thế nào");
        dic.put("book", "Quyển vở");
        dic.put("computer", "Máy tính");
        String search = request.getParameter("search");
        String result = dic.get(search);
    %>
    <c:forEach var="dictionary" items="${dic}">
        <c:if test=" ${dictionary} != null">
            <h3>Word: ${search}</h3>
            <h3>result: ${result}</h3>
        </c:if>

        <c:if test=" ${result} == null">
        <h3>Not found!</h3>
        </c:if>
    </c:forEach>
</body>
</html>
