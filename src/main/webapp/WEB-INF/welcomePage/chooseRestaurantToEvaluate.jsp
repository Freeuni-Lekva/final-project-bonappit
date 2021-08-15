<%@ page import="database.RestaurantsDao" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 15-Aug-21
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Restaurants</title>
</head>
<body>
<h1>Pls, choose restaurant to evaluate</h1>

<%
  RestaurantsDao restaurantsDao = (RestaurantsDao) request.getServletContext().getAttribute(RestaurantsDao.daoString);
  List<String> evaluates = restaurantsDao.getRestaurantToEvaluate(request.getParameter("username"));
  String attribute = "";
  if (!request.getAttribute("attribute").equals(""))
    attribute = "You don't have visits to rate";
%>

<table>
  <tr>
    <th>Restaurants to Evaluate</th>
  </tr>

    <%
      for(int i = 0; i < evaluates.size(); i++)
        out.print("<tr><td><a href=\"rateTheRestaurant?restaurantId=" + evaluates.get(i) +
                "&username=" + request.getParameter("username") +
                "&attribute=" + attribute +
                "\">" + restaurantsDao.getRestaurantById(evaluates.get(i)).getName() + "</a></td></tr>");
    %>
</table><br><br>

<%
  out.print("<a href=\"homePage?restaurantId=" + request.getParameter("restaurantId") +
          "&username=" + request.getParameter("username") + "\">Home page</a>");
%>

</body>
</html>
