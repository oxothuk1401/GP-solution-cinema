<%--
  Created by IntelliJ IDEA.
  User: oxothuk1401
  Date: 04.04.2017
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reservation</title>
</head>
<body>
<a href="index"><h1 align="center">To main</h1></a>
<h1 align="center">Reservation</h1>
<form:form method="POST" modelAttribute="order" action="reserved">
   <p align="center">
        <select name="time">
            <option disabled>Select time</option>
            <option value="10.00">10.00
            <option value="12.00">12.00
            <option value="14.00">14.00
            <option value="16.00">16.00
            <option value="18.00">18.00
        </select>
    </p>
    <p align="center">
        <select size="11" name="place">
            <option disabled>Select a place</option>
            <option value="1">Place number 1
            <option value="2">Place number 2
            <option value="3">Place number 3
            <option value="4">Place number 4
            <option value="5">Place number 5
            <option value="6">Place number 6
            <option value="7">Place number 7
            <option value="8">Place number 8
            <option value="9">Place number 9
            <option value="10">Place number 10
        </select>
    </p>
    <p align="center"><input type="submit" value="Reservation"></p>
</form:form>


</body>
</html>
