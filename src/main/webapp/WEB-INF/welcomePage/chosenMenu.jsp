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

    .Pageheader {
        padding: 10px;
        text-align: center;
        background: #1abc9c;
        color: white;
        font-size: 15px;
    }


    .btn-group button {
        background-color: #1abc9c;
        border: #1abc9c;
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
        background-color: #1abc9c;
    }

    .links {
        text-align: center;
        width: 20%;
        background-color: #1abc9c;
        overflow: auto;
    }

    .links a {
        float: left;
        padding: 12px;
        color: white;
        text-decoration: none;
        font-size: 15px;
        width: 91%;
        text-align: center;
    }

</style>

<head>
    <title>Products in Menu</title>
</head>

<body>
<div class="Pageheader">
<h1>Current Menu</h1>
</div>

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
        Total: $<%=productsInMenu.getTotalPrice()%>
        <div class="btn-group"><button type="submit">Update Menu</button></div>
    </form>

    <form action="manageMenuServlet" method="post">
        <input type="hidden" name="restaurantId" value="<%=request.getParameter("restaurantId")%>">
        <input type="hidden" name="username" value="<%=request.getParameter("username")%>">
        <div class="btn-group"><button type="submit">Clear Menu</button></div>
    </form>

    <form action="reservationServlet" method="post">
        <input type="hidden" name="restaurantId" value="<%=request.getParameter("restaurantId")%>">
        <input type="hidden" name="username" value="<%=request.getParameter("username")%>">
        <div class="btn-group"><button type="submit">Make Reservation</button></div>
    </form>

<div class="links">
<%
    out.print("<a href=\"restaurantPage?restaurantId=" + request.getParameter("restaurantId") +
                    "&username=" + request.getParameter("username") +
            "\">add more products</a>");

%>
</div>

</body>
</html>
