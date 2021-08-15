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
    <title>Reservations</title>
</head>
<body>

<div class="Pageheader">
<h1><%= request.getParameter("username")%>
  <%
    String username = request.getParameter("username");
    String restaurantId = request.getParameter("restaurantId");
    ProductsInMenu productsInMenu = (ProductsInMenu) request.getSession().getAttribute("products");

    if (productsInMenu.getProductsInMenu().isEmpty()){
        out.println(", menu is empty</h1>");
    }else if (request.getAttribute("reserved").equals("0")){
        out.println(", your reservation is waiting for administrators' approval</h1>");
    }
  %>
</div>

  <br>

<div class="links">
    <%
        out.print("<a href=\"restaurantPage?restaurantId=" + restaurantId +
                "&username=" + username + "\">return to products page</a><br><br>");
        out.print("<a href=\"currentReservations?restaurantId=" + restaurantId +
            "&username=" + username + "\">My Reservations </a>");
    %>
</div>

</body>
</html>
