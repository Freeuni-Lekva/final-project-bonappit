<%@ page import="database.RestaurantsDao" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Set" %>
<%@ page import="javaClasses.Restaurant" %>
<%@ page import="javaClasses.User" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 16-Aug-21
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    RestaurantsDao restaurantsDao = (RestaurantsDao) request.getServletContext().getAttribute(RestaurantsDao.daoString);
    List<String> users = restaurantsDao.getUsers();
    User user = null;
    if (request.getParameter("restaurantId") != null) {
        user = restaurantsDao.getUserById(request.getParameter("restaurantId"));

    }else {
        user = restaurantsDao.getUserByUsername(request.getParameter("username"));
    }

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
        width: 92%;
        text-align: center;
    }

</style>

<title>Chat</title>
<body>
<div class="Pageheader">
<h1>Welcome</h1>
</div>

<table id="thisTable">
    <tr class="tableHeader">
        <th>Contacts</th>
    </tr>

    <%
        for(int i = 0; i < users.size(); i++){
            out.print("<tr><td>");
            out.print("<form action=\"chatClassServlet\" method=\"post\">");
            out.print("<a href=\"javascript:;\" onclick=\"parentNode.submit();\">" + users.get(i) + "</a>");
            out.println("<input type=\"hidden\" name=\"username\" value='" + user.getUsername() + "'>");
            out.println("<input type=\"hidden\" name=\"to\" value='" + users.get(i) + "'>");
            out.println("</form></td></tr>");
        }
    %>
</table>

<div class="links">
<%
    out.print("<a href=\"adminHomePage?restaurantId=" + user.getRestaurantId() +
            "&username=" + user.getUsername() + "\">Home</a>");
%>
</div>

</body>
</html>
