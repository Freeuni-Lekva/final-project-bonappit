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
  String username = request.getParameter("username");

  if (reservations.isEmpty())
      out.println("you don't have any reservations");
  else {
      for (String id : reservations.keySet()) {
          Restaurant restaurant = restaurantDao.getRestaurantById(id);
          out.println("<table><tr><th>" + restaurant.getName() + " products</th>");
          out.println("<th> Price per </th>");
          out.println("<th> Quantity </th>");
          out.println("<th> Status </th></tr>");


          ProductsInMenu productsInMenu = reservations.get(id);
          for (Product product : productsInMenu.getProductsInMenu().keySet()) {

              out.print("<tr><td>" + product.getProductName() + "</td>");
              out.print("<td>" + "$" + product.getProductPrice() + "</td>");
              out.print("<td>" + productsInMenu.getProductsInMenu().get(product) + "</td>");
              if (restaurantDao.rejected(username, productsInMenu.getRestaurantId()))
                  out.print("<td>rejected</td></tr></table><br>");
              else if(restaurantDao.reserved(username, productsInMenu.getRestaurantId()))
                  out.print("<td>reservation approved by administrator</td></tr></table><br>");
              else
                  out.print("<td>waiting for administrators' approval</td></tr></table><br>");
          }
          out.print("<a href=\"reservationServlet?restaurantId=" + id +
                  "&username=" + username + "\">cancel reservation in " +
                  restaurant.getName() + "</a><br>");

          out.print("<a href=\"friendsPage?restaurantId=" + id +
                  "&username=" + username + "\">invite friends on reservation</a><br><br>");
      }
  }

    out.print("<br><br><a href=\"homePage?restaurantId=" + request.getParameter("restaurantId") +
            "&username=" + username + "\">return to home page</a>");
  %>

</body>
</html>
