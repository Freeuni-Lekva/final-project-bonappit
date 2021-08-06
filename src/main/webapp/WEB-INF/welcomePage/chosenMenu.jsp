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
<head>
    <title>Products in Menu</title>
</head>
<body>
<h1>Shopping Cart</h1>

    <form action="menuServlet" method="post">
        <ul>

            <%
                ProductsInMenu productsInMenu = new ProductsInMenu();
                productsInMenu = (ProductsInMenu) session.getAttribute(productsInMenu.Products);

                for(Product currProduct : productsInMenu.getProductsInMenu().keySet()){
                    out.println("<li> <input type ='number' value='" + productsInMenu.getProductsInMenu().get(currProduct)
                            + "' name='" + currProduct.getProductName() + "'>"
                            + currProduct.getProductName() + ", " + currProduct.getProductPrice() + "</li>");
                }
            %>
        </ul>

        <input type="hidden" name="restaurantId" value="<%=request.getParameter("restaurantId")%>">
        Total: $<%=productsInMenu.getTotalPrice()%> <button type="submit">Update Menu</button>
    </form>

    <form action="manageMenuServlet" method="post">
        <input type="hidden" name="restaurantId" value="<%=request.getParameter("restaurantId")%>">
        <button type="submit">Clear Menu</button>
    </form>

<%
    out.print("<a href=\"restaurantPage?restaurantId=" + request.getParameter("restaurantId") +
            "\">add more products</a>");
%>

</body>
</html>
