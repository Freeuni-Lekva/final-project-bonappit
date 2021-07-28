<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 28-Jul-21
  Time: 1:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Create Account</title>
</head>
<body>
<h1>The Name <%= request.getParameter("username")%> is Already In Use</h1>

<p>Please enter another username</p>

<form action="createAccount" method="post">
  <label for="username">User Name:</label>
  <input type="text" id="username" name="username">
  <br></br>
  <label for="password">Password:</label>
  <input type="text" id="password" name="password">
  <input type="submit" value="Register">
</form>

<a href="adminRegistration">Register as restaurant </a>

</body>
</html>
