<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 14-Aug-21
  Time: 8:31 PM
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

    .links a:hover {
        background-color: #555;
    }
</style>

<head>
    <title>Review</title>
</head>
<body>
<div class="Pageheader">
<h1>Thank you for your review</h1>
</div>

<div class="links">
<%
    out.print("<a href=\"homePage?restaurantId=" + request.getParameter("restaurantId") +
            "&username=" + request.getParameter("username") + "\">Home Page</a>");
%>
</div>

</body>
</html>
