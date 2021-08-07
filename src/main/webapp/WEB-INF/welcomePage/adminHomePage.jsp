<%@ page import="database.RestaurantsDao" %>
<%@ page import="javaClasses.Reservation" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 31-Jul-21
  Time: 1:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Admin of : <%= request.getParameter("username")%></title>
</head>
<body>
<center>
    <h1>Welcome</h1>
</center>
<div align="center">
    <table border="1" cellpadding="3">
        <caption><h2><%= request.getParameter("username")%></h2></caption>
        <tr>
            <th>Name</th>
            <th>Menu</th>
            <th>R/A</th>
        </tr>
        <c:forEach var="reservations" items="${listReservations}">
            <tr>
                <td><c:out value="${reservations.username}" /></td>
                <td> <a href="menu?id=<c:out value='${reservations.username}' />">Menu</a></td>
                <td><c:out value="${reservations.rejected}" /></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>