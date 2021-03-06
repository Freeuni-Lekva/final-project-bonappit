<%@ page import="database.RestaurantsDao" %>
<%@ page import="java.util.List" %>
<%@ page import="javaClasses.Restaurant" %>

<%
    RestaurantsDao restaurantsDao = (RestaurantsDao) request.getServletContext().getAttribute(RestaurantsDao.daoString);
    List<String> total = restaurantsDao.getFriends(request.getParameter("username"));
    List<Restaurant> restaurants = restaurantsDao.getRestaurants();

    for (int i = 0; i < restaurants.size(); i++){
        total.add(restaurants.get(i).getName());
    }
%>

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

<head>

</head>

<title>Chat</title>
<body>
<div class="Pageheader">
<h1>Welcome to Chat</h1>
</div>


<table id="thisTable">
    <tr class="tableHeader">
        <th>Contacts</th>
    </tr>

    <%
        for(int i = 0; i < total.size(); i++){
            out.print("<tr><td>");
            out.print("<form action=\"chatClassServlet\" method=\"post\">");
            out.print("<a href=\"javascript:;\" onclick=\"parentNode.submit();\">" + total.get(i) + "</a>");
            out.println("<input type=\"hidden\" name=\"username\" value='" + request.getParameter("username") + "'>");
            out.println("<input type=\"hidden\" name=\"to\" value='" + total.get(i) + "'>");
            out.println("</form></td></tr>");
        }
    %>
</table>

<div class="links">
<%
    out.print("<a href=\"homePage?username=" + request.getParameter("username") + "\">Home</a>");
%>
</div>

</body>
</html>
