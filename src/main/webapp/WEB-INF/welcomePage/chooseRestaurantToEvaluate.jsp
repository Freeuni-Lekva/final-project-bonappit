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
    width: 97%;
    text-align: center;
  }

</style>

<head>
    <title>Restaurants</title>
</head>
<body>
<div class="Pageheader">
<h1>Pls, choose restaurant to evaluate</h1>

<%
  RestaurantsDao restaurantsDao = (RestaurantsDao) request.getServletContext().getAttribute(RestaurantsDao.daoString);
  List<String> evaluates = restaurantsDao.getRestaurantToEvaluate(request.getParameter("username"));
  String attribute = "";
  if (!request.getAttribute("attribute").equals("")) {
    attribute = "You don't have visits to rate";
    out.println("<h2>You don't have visits to rate</h2></div>");
  } else {
%>
</div>

<table id="thisTable">
  <tr class="tableHeader">
    <th>Restaurants to Evaluate</th>
  </tr>

    <%
      for(int i = 0; i < evaluates.size(); i++)
        out.print("<tr><td><a href=\"rateTheRestaurant?restaurantId=" + evaluates.get(i) +
                "&username=" + request.getParameter("username") +
                "&attribute=" + attribute +
                "\">" + restaurantsDao.getRestaurantById(evaluates.get(i)).getName() + "</a></td></tr>");
    %>
</table>
<%
  }
%>
<br><br>

<div class="links">
<%
  out.print("<a href=\"homePage?restaurantId=" + request.getParameter("restaurantId") +
          "&username=" + request.getParameter("username") + "\">Home page</a>");
%>
</div>

</body>
</html>
