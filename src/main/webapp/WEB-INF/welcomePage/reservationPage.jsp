<%@ page import="database.RestaurantsDao" %>
<%@ page import="javaClasses.ProductsInMenu" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 07-Aug-21
  Time: 12:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reservations</title>
</head>
<body>
<h1><%= request.getParameter("username")%>
  <%
    String username = request.getParameter("username");
    String restaurantId = request.getParameter("restaurantId");

    if (request.getAttribute("reserved").equals("0")){
        out.println(", your reservation is waiting for administrators' approval</h1>");

      RestaurantsDao restaurantsDao = new RestaurantsDao();
      int count = 0;
      while (count < 10){
          count++;
          if (restaurantsDao.reserved(username, restaurantId)){
            out.println("<p>Reservation is approved </p>");
            ProductsInMenu productsInMenu = new ProductsInMenu();
            productsInMenu = (ProductsInMenu) session.getAttribute(productsInMenu.Products);
            restaurantsDao.getChangedMenu(username, restaurantId, productsInMenu);
            //ukve aproved unda wavshalo bazidan am usernamet da restaurantIdit, reservaton bazashi

            break;
        }
        if (restaurantsDao.rejected(username, restaurantId)){
            out.println("<p>Reservation is rejected by administrator </p>");
            //ukve rejected unda wavshalo bazidan am usernamet da restaurantIdit, reservaton bazashi
            break;
        }
        Thread.sleep(100);

      }
    }
    else
      out.println(", you already have reservation, pls remove previous reservation first</h1>");
  %>


  <br></br>
    <%
        out.print("<a href=\"restaurantPage?restaurantId=" + request.getParameter("restaurantId") +
                "&username=" + request.getParameter("username") + "\">return to products page</a>");
    %>

</body>
</html>
