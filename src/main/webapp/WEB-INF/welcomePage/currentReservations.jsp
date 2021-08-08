<%@ page import="database.RestaurantsDao" %>
<%@ page import="javaClasses.ProductsInMenu" %>
<%@ page import="java.util.Map" %>
<%@ page import="javaClasses.Restaurant" %>
<%@ page import="javaClasses.Product" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 08-Aug-21
  Time: 12:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your Reservations</title>
</head>
<body>
<h1>Your Reservations</h1>

<%
  RestaurantsDao restaurantDao = new RestaurantsDao();
  Map<String, ProductsInMenu> reservations = restaurantDao.getUserReservations(request.getParameter("username"));

  if (reservations.isEmpty())
      out.println("you don't have any reservations");
  else {
      for (String id : reservations.keySet()) {
          Restaurant restaurant = restaurantDao.getRestaurantById(id);
          out.println("<table><tr><th>" + restaurant.getName() + " products</th>");
          out.println("<th> Price per </th>");
          out.println("<th> Quantity </th></tr>");


          ProductsInMenu productsInMenu = reservations.get(id);
          for (Product product : productsInMenu.getProductsInMenu().keySet()) {

              out.print("<tr><td>" + product.getProductName() + "</td>");
              out.print("<td>" + "$" + product.getProductPrice() + "</td>");
              out.print("<td>" + productsInMenu.getProductsInMenu().get(product) + "</td></tr></table><br>");
          }
          out.print("<a href=\"reservationServlet?restaurantId=" + id +
                  "&username=" + request.getParameter("username") + "\">cancel reservation in " +
                  restaurant.getName() + "</a><br><br>");
      }
  }

    out.print("<br><br><a href=\"homePage?restaurantId=" + request.getParameter("restaurantId") +
            "&username=" + request.getParameter("username") + "\">return to home page</a>");
  %>

</body>
</html>
