<%@ page import="database.RestaurantsDao" %>
<%@ page import="javaClasses.Reservation" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 31-Jul-21
  Time: 1:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin of:  <%= request.getParameter("username")%></title>
</head>
<body>
<u1>

        <%
        RestaurantsDao restaurantDao = new RestaurantsDao();
        Map<String,Reservation> reservations = restaurantDao.getReservationList(request.getParameter("restaurantid"));
    %>

</u1>
<div align="center">
    <thead border="1" cellpadding="5">
        <caption><h2>Requests</h2></caption>
        <tr>
            <th>Name</th>
            <th>Menu</th>
            <th>A/Rn</th>
        </tr>
    </thead>
</tbody>
            <tr>
                <td>< value="1" /></td>
                <td>< value="2"/></td>
                <td>< value ="3" /></td>
            </tr>
    </table>
</div>
</body>
</html>
