<%@ page import="database.RestaurantsDao" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 31-Jul-21
  Time: 3:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    RestaurantsDao restaurantsDao = new RestaurantsDao();
    javaClasses.Restaurant currRestaurant = restaurantsDao.getRestaurantById(request.getParameter("id"));
%>
<html>
<head>
    <title><%=currRestaurant.getName()%></title>
</head>
<body>
    <h1><%=currRestaurant.getName()%></h1>


</body>
</html>
