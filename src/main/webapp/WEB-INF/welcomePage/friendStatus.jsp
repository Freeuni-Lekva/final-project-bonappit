<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 09-Aug-21
  Time: 4:46 PM
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

  .links {
    width: 100%;
    background-color: gray;
    overflow: auto;
  }

  .links a {
    float: left;
    padding: 12px;
    color: white;
    text-decoration: none;
    font-size: 15px;
    width: 98%;
    text-align: center;
  }

</style>

<head>
    <title>Friend Request</title>
</head>
<body>

<div class="Pageheader">
<%
  String message = (String) request.getAttribute("attribute");
  String username = request.getParameter("username");
  String restaurantId = request.getParameter("restaurantId");

  out.println("<h1>" + message + "</h1></div><br><br>");
  %>

  <div class="links">
  <%
  out.print("<br><a href=\"homePage?restaurantId=" + restaurantId +
          "&username=" + username + "\">return to home page</a>");
  %>
  </div>

</body>
</html>
