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
    RestaurantsDao restaurantsDao = new RestaurantsDao();
    String username = request.getParameter("username");
    List<String> friendsList = restaurantsDao.getFriends(username);
%>

<html>
<head>
    <title>Friends</title>
</head>
<body>
<h1>Your Friends</h1>

<table>
    <tr>
        <th>Friend</th>
        <th>Invite</th>
    </tr>

    <%
        for(int i = 0; i < friendsList.size(); i++){
            out.print("<tr><td>" + friendsList.get(i) + "</td>");
            out.print("<td>");
            out.print("<form action=\"inviteFriendsServlet\" method=\"post\">");
            out.print("<a href=\"javascript:;\" onclick=\"parentNode.submit();\">invite</a>");
            out.println("<input type=\"hidden\" name=\"username\" value=" + request.getParameter("username") + "\">");
            out.println("<input type=\"hidden\" name=\"restaurantId\" value=" + request.getParameter("restaurantId") + "\">");
            out.println("<input type=\"hidden\" name=\"friendName\" value=" + friendsList.get(i) + "\">");
            out.println("</form></td></tr>");
        }
    %>
</table>

</body>
</html>
