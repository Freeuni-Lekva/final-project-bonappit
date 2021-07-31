<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 31-Jul-21
  Time: 1:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome <%= request.getParameter("username")%></title>
</head>
<body>
<h1>Please, choose restaurant <%= request.getParameter("username")%> </h1>

<a>adminia es</a>
</body>
</html>
