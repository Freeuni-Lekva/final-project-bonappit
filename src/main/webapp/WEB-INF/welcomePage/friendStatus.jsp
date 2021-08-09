<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 09-Aug-21
  Time: 4:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Friend Request</title>
</head>
<body>
<%
  String message = (String) request.getAttribute("attribute");
  String username = request.getParameter("username");
  String restaurantId = request.getParameter("restaurantId");

  out.println("<h1>" + message + "</h1><br><br>");

  out.print("<br><a href=\"homePage?restaurantId=" + restaurantId +
          "&username=" + username + "\">return to home page</a>");
%>

</body>
</html>
