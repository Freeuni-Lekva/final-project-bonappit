<%@ page import="database.RestaurantsDao" %>
<%@ page import="javaClasses.MenuReader" %>
<%@ page import="javaClasses.Product" %>
<%@ page import="java.util.List" %>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: User--%>
<%--  Date: 31-Jul-21--%>
<%--  Time: 3:00 PM--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%
    RestaurantsDao restaurantsDao = (RestaurantsDao) request.getServletContext().getAttribute(RestaurantsDao.daoString);
    javaClasses.Restaurant currRestaurant = restaurantsDao.getRestaurantById(request.getParameter("restaurantId"));

    MenuReader menuReader = new MenuReader();
    List<Product> menuList = menuReader.readMenu(currRestaurant.getMenu());
%>

<html>

<style>
    .Pageheader {
        padding: 10px;
        text-align: center;
        background: #1abc9c;
        color: white;
        font-size: 15px;
    }

    #restaurantPageInput {
        background-position: 10px 12px;
        width: 100%;
        font-size: 15px;
        padding: 11px 20px 11px 40px;
        border: 1px solid #ddd;
        margin-bottom: 11px;
    }

    #thisTable {
        border-collapse: collapse;
        width: 100%;
        border: 1px solid #ddd;
        font-size: 19px;
    }

    #thisTable th, #thisTable td {
        text-align: left;
        padding: 12px;
    }

    #thisTable tr {
        border-bottom: 1px solid #ddd;
    }

    #thisTable tr.tableHeader, #thisTable tr:hover {
        background-color: #f1f1f1;
    }

    /*now write links style*/
    .links {
        width: 100%;
        background-color: #555;
        overflow: auto;
    }

    .links a {
        float: left;
        padding: 12px;
        color: white;
        text-decoration: none;
        font-size: 17px;
        width: 48%;
        text-align: center;
    }

    .links a:hover {
        background-color: #04AA6D;
    }

</style>

<script>
    function search() {
        var inp = document.getElementById("restaurantPageInput");
        var filter = inp.value.toUpperCase();
        var myTable = document.getElementById("thisTable");
        var trVar = myTable.getElementsByTagName("tr");

        for (var i = 0; i < trVar.length; i++) {
            var tdVar = trVar[i].getElementsByTagName("td")[0];
            if (tdVar) {
                var textValue = tdVar.textContent || tdVar.innerText;
                if (textValue.toUpperCase().indexOf(filter) > -1) {
                    trVar[i].style.display = "";
                } else {
                    trVar[i].style.display = "none";
                }
            }
        }
    }
</script>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><%=currRestaurant.getName()%></title>
</head>
<body>

    <div class="links">
        <%
            out.print("<a href=\"homePage?restaurantId=" + request.getParameter("restaurantId") +
                    "&username=" + request.getParameter("username") + "\">Home</a>");
            out.print("<a href=\"manageMenuServlet?restaurantId=" + request.getParameter("restaurantId") +
                    "&username=" + request.getParameter("username") +
                    "&invitation=" + request.getParameter("invitation") + "\">Show Products in Menu</a>");
        %>
    </div>

    <div class="Pageheader">
        <h1><%=currRestaurant.getName()%></h1>
        <p>Please, choose menu </p>
    </div>

    <input type="text" id="restaurantPageInput" onkeyup="search()" placeholder="search for products...">
    <table id="thisTable">
        <tr class="tableHeader">
            <th>Product</th>
            <th>Price</th>
            <th>choose product</th>
        </tr>

       <%
           for(int i = 0; i < menuList.size(); i++){
               out.print("<tr><td>" + menuList.get(i).getProductName() + "</td>");
               out.print("<td>" +"$" + menuList.get(i).getProductPrice() + "</td>");
               out.print("<td>");
               out.print("<a href=\"menuServlet?productName=" + menuList.get(i).getProductName() +
                       "&productPrice=" + menuList.get(i).getProductPrice() +
                       "&restaurantId=" + request.getParameter("restaurantId") +
                       "&username=" + request.getParameter("username") +
                       "&invitation=" + request.getParameter("invitation") +
                       "\">Add to Menu</a></td></tr>");
            }
        %>
    </table>


</body>
</html>
