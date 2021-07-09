<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 09-Jul-21
  Time: 1:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BonAppIt</title>
</head>
<body>
<h1>Welcome to BonAppIt</h1>
<p>Please log in</p>
<form action="loginServlet" method="post">
    <label for="username">User Name:</label>
    <input type="text" id="username" name="username" /><br/>
    <br></br>
    <label for="password">Password:</label>
    <input id="password" type="text" name="password"/>
    <button type="submit">login</button>
</form>

<a href="createAccount">Create New Account </a>

</body>
</html>
