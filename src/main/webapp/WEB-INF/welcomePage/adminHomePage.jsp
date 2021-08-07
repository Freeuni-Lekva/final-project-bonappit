<%@ page import="database.RestaurantsDao" %>
<%@ page import="javaClasses.Reservation" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 31-Jul-21
  Time: 1:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        Display table with vertical scrollbar
    </title>

    <style>
        table.scrolldown {
            width: 100%;

            /* border-collapse: collapse; */
            border-spacing: 0;
            border: 2px solid black;
        }

        /* To display the block as level element */
        table.scrolldown tbody, table.scrolldown thead {
            display: block;
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
            overflow-x: hidden;
        }

        tbody {
            border-top: 2px solid black;
        }

        tbody td, thead th {
            width : 200px;
            border-right: 2px solid black;
        }
        td {
            text-align:center;
        }
    </style>
</head>

<body>
<table class="scrolldown">

    <!-- Table head content -->
    <thead>
    <tr>
        <th>User</th>
        <th>Menu</th>
        <th>A/R</th>
    </tr>
    </thead>
    <tbody>
    <%
        RestaurantsDao restaurantDao = new RestaurantsDao();
        Map<String,Reservation> reservations = restaurantDao.getReservationList(request.getParameter("restaurantid"));
        Set<String> set=reservations.keySet();
        for (String rep:
             set) {
            String status="accepted";
            if (reservations.get(rep).getStatus())
                status="rejected";
    %>
            <tr>
                <td><%System.out.println(reservations.get(rep).getUsername());%></td>
                <td> <a href="Menu">Show Menu </a> </td>
                <td><%=System.out.println(status)%></td>
            </tr>
<% } %>
</tbody>
    </table>
</body>
</html>
