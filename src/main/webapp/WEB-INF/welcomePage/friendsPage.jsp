<%@ page import="database.RestaurantsDao" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 08-Aug-21
  Time: 3:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    RestaurantsDao restaurantsDao = (RestaurantsDao) request.getServletContext().getAttribute(RestaurantsDao.daoString);
    String username = request.getParameter("username");
    List<String> friendsList = restaurantsDao.getFriends(username);
%>

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

    #thisTable {
        border-collapse: collapse;
        width: 100%;
        border: 1px solid #ddd;
        font-size: 19px;
    }

    #thisTable th, #thisTable td {
        text-align: center;
        padding: 12px;
    }

    #thisTable tr {
        border-bottom: 1px solid #ddd;
    }

    #thisTable tr.tableHeader {
        background-color: #04AA6D;
        color: white;
    }

</style>

<head>
    <title>Friends</title>
</head>
<body>
<div class="Pageheader">
<h1>Your Friends</h1>
</div>

<table id="thisTable">
    <tr class="tableHeader">
        <th>Friend</th>
        <th>Invite</th>
    </tr>

    <%
        for(int i = 0; i < friendsList.size(); i++){
            out.print("<tr><td>" + friendsList.get(i) + "</td>");
            out.print("<td>");
            out.print("<form action=\"inviteFriendsServlet\" method=\"post\">");
            out.print("<a href=\"javascript:;\" onclick=\"parentNode.submit();\">invite</a>");
            out.println("<input type=\"hidden\" name=\"username\" value='" + request.getParameter("username") + "'>");
            out.println("<input type=\"hidden\" name=\"restaurantId\" value='" + request.getParameter("restaurantId") + "'>");
            out.println("<input type=\"hidden\" name=\"friendName\" value='" + friendsList.get(i) + "'>");
            out.println("</form></td></tr>");
        }
    %>
</table>

</body>
</html>
