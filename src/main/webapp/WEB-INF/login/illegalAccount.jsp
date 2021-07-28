<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 28-Jul-21
  Time: 12:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wrong Account</title>
</head>
<body>
<h1>Please Try Again</h1>
<p>Either your username or password is incorrect. Please try again.</p>
<form action="loginServlet" method="post">
    <label for="username">User Name:</label>
    <input type="text" id="username" name="username" />
    <br></br>
    <label for="password">Password:</label>
    <input id="password" type="text" name="password"/>
    <button type="submit">login</button>
</form>

<a href="createAccount">Create New Account </a>

</body>
</html>
