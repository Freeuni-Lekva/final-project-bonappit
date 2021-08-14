<%@ page import="javaClasses.ProductsInMenu" %>
<%@ page import="javaClasses.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="database.RestaurantsDao" %>
<%@ page import="javaClasses.MenuReader" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 05-Aug-21
  Time: 12:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>

<style>
    .btn-group button {
        background-color: #04AA6D;
        border: 1px solid green;
        color: white;
        padding: 10px 24px;
        cursor: pointer;
        float: left;
    }

    .btn-group button:not(:last-child) {
        border-right: none;
    }

    .btn-group:after {
        content: "";
        clear: both;
        display: table;
    }

    .btn-group button:hover {
        background-color: #3e8e41;
    }
</style>

<head>
    <title>Products in Menu</title>
</head>
<body>
<h1>Current Menu</h1>

<form action="menuServlet" method="post">
    <ul>

        <%
            ProductsInMenu productsInMenu = new ProductsInMenu();
            productsInMenu = (ProductsInMenu) session.getAttribute(productsInMenu.Products);
            productsInMenu.removeZeroQuantities();

            for(Product currProduct : productsInMenu.getProductsInMenu().keySet()){
                out.println("<li> <input type ='number' value='" + productsInMenu.getProductsInMenu().get(currProduct)
                        + "' name='" + currProduct.getProductName() + "'>" +
                        "<input type ='hidden' value='" + request.getParameter("username")
                        + "' name='" + "username" + "'>"
                        + currProduct.getProductName() + ", " + currProduct.getProductPrice() + "</li>");
            }
        %>
    </ul>

    <input type="hidden" name="restaurantId" value="<%=request.getParameter("restaurantId")%>">
    <input type="hidden" name="username" value="<%=request.getParameter("username")%>">
    <input type="hidden" name="invitation" value="<%=request.getParameter("invitation")%>">
    Total: $<%=productsInMenu.getTotalPrice()%>
    <div class="btn-group"><button type="submit">Update Menu</button></div>
</form>

<form action="manageMenuServlet" method="post">
    <input type="hidden" name="restaurantId" value="<%=request.getParameter("restaurantId")%>">
    <input type="hidden" name="username" value="<%=request.getParameter("username")%>">
    <input type="hidden" name="invitation" value="<%=request.getParameter("invitation")%>">
    <div class="btn-group"><button type="submit">Clear Menu</button></div>
</form>

<form action="inviteOnReservationServlet" method="post">
    <input type="hidden" name="restaurantId" value="<%=request.getParameter("restaurantId")%>">
    <input type="hidden" name="username" value="<%=request.getParameter("username")%>">
    <input type="hidden" name="invitation" value="<%=request.getParameter("invitation")%>">
    <div class="btn-group"><button type="submit">Change Reservation</button></div>
</form>

<%
    out.print("<a href=\"restaurantPage?restaurantId=" + request.getParameter("restaurantId") +
            "&username=" + request.getParameter("username") + "&invitation=" + request.getParameter("invitation") +
            "\">add more products</a>");

%>

</body>
</html>
