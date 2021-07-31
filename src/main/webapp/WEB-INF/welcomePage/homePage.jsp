<%@ page import="java.util.ArrayList" %>
<%@ page import="database.RestaurantsDao" %>
<%@ page import="javaClasses.Restaurant" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 28-Jul-21
  Time: 1:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome <%= request.getParameter("username")%></title>
</head>
<body>
<h1>Welcome <%= request.getParameter("username")%></h1>
<p>Please, choose restaurant <%= request.getParameter("username")%> </p>

<u1>
    <%
        RestaurantsDao restaurantDao = new RestaurantsDao();
        ArrayList<Restaurant> restaurants = (ArrayList<Restaurant>) restaurantDao.getRestaurants();

        for(javaClasses.Restaurant restaurant : restaurants) {
            out.print("<li><a href=\"restaurantPage?id=" + restaurant.getId() + "\">"
                    + restaurant.getName() + "</a>" +
                    " Rating " + restaurant.getRating() + "</li><br></br>");
            out.println("\n");
        }
    %>

</u1>

<br></br>
<a href="chatPge">Open Chat </a>

</body>
</html>
