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

<style>
    body {
        text-align: center;
    }

    .Pageheader {
        padding: 10px;
        text-align: center;
        background: #1abc9c;
        color: white;
        font-size: 15px;
    }

    .links {
        width: 100%;
        background-color: gray;
        overflow: auto;
    }

    .links a {
        float: left;
        padding: 12px;
        color: white;
        text-decoration: none;
        font-size: 15px;
        width: 98%;
        text-align: center;
    }

    .links a:hover {
        background-color: #555;
    }
</style>

<head>
    <title>Reservation</title>
</head>
<body>

<div class="Pageheader">
<h1><%= request.getParameter("username")%>
        <%
    if (request.getAttribute("reserved").equals("0"))
        out.println(", you dont have reservation</h1>");
    else{
        RestaurantsDao restaurantsDao = (RestaurantsDao) request.getServletContext().getAttribute(RestaurantsDao.daoString);
        Restaurant restaurant = restaurantsDao.getRestaurantById(request.getParameter("restaurantId"));
        out.println("reservation is successfully cancelled in " + restaurant.getName() + "</h1>");
      }
  %>
</div>

    <br>
<div class="links">
        <%
        out.print("<a href=\"homePage?restaurantId=" + request.getParameter("restaurantId") +
                "&username=" + request.getParameter("username") + "\">return to home page</a>");
    %>
</div>

</body>
</html>
