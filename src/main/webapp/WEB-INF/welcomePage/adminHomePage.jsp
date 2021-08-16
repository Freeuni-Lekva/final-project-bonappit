
<%@ page import="database.RestaurantsDao" %>
<%@ page import="javaClasses.Reservation" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
<%@ page import="database.RestaurantsDao" %>
<%@ page import="javaClasses.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%
    RestaurantsDao restaurantsDao = (RestaurantsDao) request.getServletContext().getAttribute(RestaurantsDao.daoString);
    User user = restaurantsDao.getUserByUsername(request.getParameter("username"));
    Map<String,Reservation> res = restaurantsDao.getReservationList(user.getRestaurantId());
%>
<html>

<head>
    <title>
      <%=  user.getUsername() %>
    </title>

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

        .button {
            position: relative;
            background-color: #04AA6D;
            border: none;
            font-size: 28px;
            color: #FFFFFF;
            padding: 20px;
            width: 200px;
            text-align: center;
            -webkit-transition-duration: 0.4s; /* Safari */
            transition-duration: 0.4s;
            text-decoration: none;
            overflow: hidden;
            cursor: pointer;
        }

        .button:after {
            content: "";
            background: #90EE90;
            display: block;
            position: absolute;
            padding-top: 300%;
            padding-left: 350%;
            margin-left: -20px!important;
            margin-top: -120%;
            opacity: 0;
            transition: all 0.8s
        }

        .button:active:after {
            padding: 0;
            margin: 0;
            opacity: 1;
            transition: 0s
        }

    </style>
</head>
<body>
    <div class="Pageheader">
    <h1>Welcome</h1>
        <caption><h2><%= request.getParameter("username")%></h2></caption>
        <h3>Total Tables Available:<%=restaurantsDao.nTablesAccepted(user.getRestaurantId())%>/<%=restaurantsDao.getRestaurantById(user.getRestaurantId()).getNumTable()%></h3>
        <% int n=restaurantsDao.nTablesAccepted(user.getRestaurantId())-restaurantsDao.getRestaurantById(user.getRestaurantId()).getNumTable();
            String N=""+n;%>
    </div>

<div align="center">
        <table border="1" cellpadding="3" id="thisTable">
            <tr class="tableHeader">
                <th>Name</th>
                <th>Menu</th>
                <th>Status</th>
                <th>R/A</th>
                <th>End Dinner</th>
            </tr>
            <%
                Set<String> resList=res.keySet();
                for (String key:
                        resList) {

                    out.print("<tr><td>" + res.get(key).getUsername() + "</td>");
                    out.print("<td> <a href=\"inviteOnReservationServlet?username="+res.get(key).getUsername()+
                            "&restaurantId=" + user.getRestaurantId() + "&invitation=-1\">Menu</a> </td>");
                    out.print("<td>"+res.get(key).getStringStatus()+"</td>");
            %>
            <td> <form action="adminButtons" method="post">
                <input type="hidden" name="tables" value="<%=N%>">
                <input type="hidden" name="button" value=accept>
                <input type="hidden" name="status" value="<%=res.get(key).getStringStatus()%>">
                <input type="hidden" name="restaurantId" value="<%=user.getRestaurantId()%>">
                <input type="hidden" name="username" value="<%=res.get(key).getUsername()%>">
                <input type="hidden" name="admin" value="<%=request.getParameter("username")%>">
                <button type="submit">Accept</button>
            </form>
                <form action="adminButtons" method="post">
                    <input type="hidden" name="button" value=reject>
                    <input type="hidden" name="status" value="<%=res.get(key).getStringStatus()%>">
                    <input type="hidden" name="restaurantId" value="<%=user.getRestaurantId()%>">
                    <input type="hidden" name="username" value="<%=res.get(key).getUsername()%>">
                    <input type="hidden" name="admin" value="<%=user.getUsername()%>">
                    <button type="submit">Reject</button>
                </form></td>
            <td> <form action="adminButtons" method="post">
                <input type="hidden" name="button" value=end>
                <input type="hidden" name="status" value="<%=res.get(key).getStringStatus()%>">
                <input type="hidden" name="restaurantId" value="<%=user.getRestaurantId()%>">
                <input type="hidden" name="username" value="<%=res.get(key).getUsername()%>">
                <input type="hidden" name="admin" value="<%=user.getUsername()%>">
                <button type="submit">End Dinner</button>
            </form></td></tr>
            <%}%>
        </table>

    <br><br>
    <form action="adminChatPage">
        <input type="hidden" name="restaurantId" value="<%=user.getRestaurantId()%>">
        <button class="button">Chat</button>
    </form>

</div>
</body>
</html>
