<%@ page import="database.RestaurantsDao" %>
<%@ page import="javaClasses.ProductsInMenu" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 08-Aug-21
  Time: 11:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reservation</title>
</head>
<body>

<%
    RestaurantsDao restaurantsDao = new RestaurantsDao();
    String username = request.getParameter("username");
    String restaurantId = request.getParameter("restaurantid");

    if (restaurantsDao.rejected(username, restaurantId)){
        out.println("<h1>" + username + ", administrator has rejected your reservation offer, pls try other menu or restaurant</h1><br>");
        restaurantsDao.removeReservation(username, restaurantId);
    } else if (restaurantsDao.reserved(username, restaurantId)){

        out.println("<p>Reservation is approved </p>");
        ProductsInMenu productsInMenu = new ProductsInMenu();
        productsInMenu = (ProductsInMenu) session.getAttribute(productsInMenu.Products);
        restaurantsDao.getChangedMenu(username, restaurantId, productsInMenu);
        restaurantsDao.removeReservation(username, restaurantId);
    }
    else {
        out.println("<h1>" + username + ", pls wait for administrator's approval</h1><br>");
    }
%>


<%
    out.print("<a href=\"restaurantPage?restaurantId=" + restaurantId +
            "&username=" + username + "\">return to products page</a><br><br>");

    out.print("<a href=\"currentReservations?restaurantId=" + restaurantId +
            "&username=" + username + "\">My Reservations </a>");
%>
</body>
</html>
