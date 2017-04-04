<%--
  Created by IntelliJ IDEA.
  User: oxothuk1401
  Date: 04.04.2017
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>See timetable</title>
</head>
<body>
<a href="index"><h1 align="center">To main</h1></a>
<h1 align="center">FILMS</h1>

<table border="1" align="center">
    <tbody>
    <c:forEach items="${listFilms}" var="view">
        <tr>
            <td>${view}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
