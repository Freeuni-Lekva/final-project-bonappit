<%@ page import="database.RestaurantsDao" %>
<%@ page import="javaClasses.MenuReader" %>
<%@ page import="javaClasses.ProductsInMenu" %>
<%@ page import="javaClasses.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 31-Jul-21
  Time: 3:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%
    RestaurantsDao restaurantsDao = new RestaurantsDao();
    javaClasses.Restaurant currRestaurant = restaurantsDao.getRestaurantById(request.getParameter("id"));
    ProductsInMenu productsInMenu = (ProductsInMenu) session.getAttribute("products");

    MenuReader menuReader = new MenuReader();
    List<Product> menuList = menuReader.readMenu(currRestaurant.getMenu());

    request.setAttribute("menuList", menuList);
%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><%=currRestaurant.getName()%></title>
</head>
<body>
    <h1><%=currRestaurant.getName()%></h1>

    <p>Please, choose menu </p>

    <table>
        <tr>
            <th>Product</th>
            <th>Price</th>
            <th>choose product</th>
        </tr>

       <%
           for(int i = 0; i < menuList.size(); i++){
               out.print("<tr><td>" + menuList.get(i).getProductName() + "</td>");
               out.print("<td>" +"$" + menuList.get(i).getProductPrice() + "</td>");
               Product currProduct = menuList.get(0);
               out.print("<td>");
       %>

        <form action="addToMenu" method="post">
            <input type="hidden" name="productName" value="<%=currProduct.getProductName()%>"/>
            <input type="hidden" name="productPrice" value="<%=currProduct.getProductPrice()%>">
            <button type="submit"> Add to Menu </button>

        <%
                out.print("</td></tr>");
            }
        %>
    </table>

</body>
</html>
