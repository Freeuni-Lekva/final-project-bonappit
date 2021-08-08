<%@ page import="database.RestaurantsDao" %>
<%@ page import="javaClasses.Restaurant" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 07-Aug-21
  Time: 2:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reservation</title>
</head>
<body>
<h1><%= request.getParameter("username")%>
        <%
    if (request.getAttribute("reserved").equals("0"))
        out.println(", you dont have reservation</h1>");
    else{
        RestaurantsDao restaurantsDao = new RestaurantsDao();
        Restaurant restaurant = restaurantsDao.getRestaurantById(request.getParameter("restaurantId"));
        out.println("reservation is successfully cancelled in " + restaurant.getName() + "</h1>");
      }
  %>


    <br>
        <%
        out.print("<a href=\"homePage?restaurantId=" + request.getParameter("restaurantId") +
                "&username=" + request.getParameter("username") + "\">return to home page</a>");
    %>

</body>
</html>
