<%@ page import="database.RestaurantsDao" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 08-Aug-21
  Time: 5:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<style>
    form {
        border: 1ch solid #f1f1f1;
        width: 100%;
    }

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
    input[type=text], input[type=password] {
        width: 40%;
        padding: 12px 22px;
        margin: 7px 0;
        display: inline-block;
        border: 1px solid #ccc;
        box-sizing: border-box;
    }
    button {
        background-color: #04AA6D;
        color: white;
        padding: 15px 20px;
        margin: 7px 0;
        border: none;
        cursor: pointer;
        width: 40%;
    }
    button:hover {
        opacity: 0.8;
    }
    .container {
        padding: 15px;
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
    <title>Add Friends</title>
</head>
<body>

<div class="Pageheader">
<h1>Find Friends</h1>
<p>Please find friend</p>
</div>

<form action="addFriendServlet" method="post">
    <div class="container">
        <label for="friendName">User Name:</label><br>
        <input type="text" id="friendName" name="friendName" required/>
        <input type="hidden" name="restaurantId" value="<%=request.getParameter("restaurantId")%>">
        <input type="hidden" name="username" value="<%=request.getParameter("username")%>">
        <button type="submit">Add Friend</button>
    </div>
</form>

<%
    RestaurantsDao restaurantsDao = (RestaurantsDao) request.getServletContext().getAttribute(RestaurantsDao.daoString);
    List<String> requests = restaurantsDao.friendRequestsReceived(request.getParameter("username"));
%>

    <table id="thisTable">
        <tr class="tableHeader">
            <th>Friend Requests</th>
        </tr>

        <tr>
            <%
                for(int i = 0; i < requests.size(); i++)
                    out.print("<td>" + requests.get(i) + "</td>");
            %>
        </tr>
    </table>

</body>
</html>
