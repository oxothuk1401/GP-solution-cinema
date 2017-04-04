<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="float" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Cinema</title>
</head>
<body background="1">
<a href="index"><h1 align="center">Cinema</h1></a>
<a href="reservation" ><h5 align="center">Reservation</h5></a>
<a href="see_timetable" ><h5 align="center">See timetable</h5></a>

<form:form method="get" modelAttribute="order" action="show_order_info">
    View order information
    <input type="text" name="id">
    <p><input type="submit" value="view"></p>
</form:form>
<form:form method="get" modelAttribute="order" action="cancel_reservation">
    Cancel reservation
    <input type="text" name="id">
    <p><input type="submit" value="cancel reservation"></p>
</form:form>


</body>
</html>