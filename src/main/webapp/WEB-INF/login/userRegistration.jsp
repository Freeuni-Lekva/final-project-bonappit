<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 09-Jul-21
  Time: 3:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Registration</title>
</head>
  <h1>User Registration</h1>

  <p>Please enter requested data</p><br>

  <form action="userResgistration" method="post">
    <label for="username">User Name:</label>
    <input type="text" id="username" name="username"><br>
    <label for="password">Password:</label>
    <input type="text" id="password" name="password">
    <input type="submit" value="Login">
  </form>

<a href="adminRegistration">Register as restaurant </a>


</body>

</html>
