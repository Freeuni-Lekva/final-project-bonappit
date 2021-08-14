<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 14-Aug-21
  Time: 8:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Review</title>
</head>
<body>
<h1>Thank you for your review</h1>

<%
    out.print("<a href=\"homePage?restaurantId=" + request.getParameter("restaurantId") +
            "&username=" + request.getParameter("username") + "\">Home Page</a>");
%>

</body>
</html>
