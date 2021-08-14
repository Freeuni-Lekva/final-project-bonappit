
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
        table.scrolldown{
            width: 100%;
            /* border-collapse: collapse; */
            border-spacing: 0;
            border: 2px black;
        }

        /* To display the block as level element */
        table.scrolldown tbody, table.scrolldown thead {
            display: -ms-inline-flexbox;
        }

        thead tr th {
            height: 40px;
            line-height: 40px;
        }

        table.scrolldown tbody {

            /* Set the height of table body */
            height: 50px;

            /* Set vertical scroll */
            overflow-y: auto;

            /* Hide the horizontal scroll */
            overflow-x: initial;
        }

        tbody {
            border-top: 2px black;
        }

        tbody td, thead th {
            width : 200px;
            border-right: 2px springgreen;
        }
        td {
            text-align:center;
        }
    </style>
</head>
<body>
<center>
    <h1>Welcome</h1>
</center>
<div align="center">
        <table border="1" cellpadding="3">
            <caption><h2><%= request.getParameter("username")%></h2></caption>
            <tr>
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
                    out.print("<td> <a href=\"adminReservedMenu?username="+res.get(key).getUsername()+
                            "&restaurantId=" + user.getRestaurantId() + "\">Menu</a> </td>");
                    out.print("<td>"+res.get(key).getStringStatus()+"</td>");

            %>
            <td> <form action="adminButtons" method="post">
                <input type="hidden" name="button" value=accept>
                <input type="hidden" name="restaurantId" value="<%=user.getRestaurantId()%>">
                <input type="hidden" name="username" value="<%=res.get(key).getUsername()%>">
                <input type="hidden" name="admin" value="<%=request.getParameter("username")%>">
                <button type="submit">Accept</button>
            </form>
                <form action="adminButtons" method="post">
                    <input type="hidden" name="button" value=reject>
                    <input type="hidden" name="restaurantId" value="<%=user.getRestaurantId()%>">
                    <input type="hidden" name="username" value="<%=res.get(key).getUsername()%>">
                    <input type="hidden" name="admin" value="<%=request.getParameter("username")%>">
                    <button type="submit">Reject</button>
                </form></td>
            <td> <form action="adminButtons" method="post">
                <input type="hidden" name="button" value=end>
                <input type="hidden" name="restaurantId" value="<%=user.getRestaurantId()%>">
                <input type="hidden" name="username" value="<%=res.get(key).getUsername()%>">
                <input type="hidden" name="admin" value="<%=request.getParameter("username")%>">
                <button type="submit">End Dinner</button>
            </form></td></tr>
            <%}%>
        </table>

</div>
</body>
</html>
