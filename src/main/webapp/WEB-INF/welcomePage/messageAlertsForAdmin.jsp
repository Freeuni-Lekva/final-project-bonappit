<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 8/14/2021
  Time: 10:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<style>
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
    <title>Alert</title>
    <%String massage="";
    if(request.getParameter("status").equals("0"))
        massage="Already Accepted";
    else if(request.getParameter("status").equals("1"))
        massage="Already accepted! Reject is denied!";
    else if(request.getParameter("status").equals("2"))
        massage="Dinner does not started yet! Can not end!";
    else if (request.getParameter("status").equals("3"))
        massage="No more tables!";
    %>

</head>
<body>

<div class="Pageheader">
<h1><%=massage%></h1>
</div>

<div class="links">
<%
    out.print("<a href=\"adminHomePage?username=" + request.getParameter("admin") + "\">Home Page</a>");
%>
</div>

</body>
</html>
