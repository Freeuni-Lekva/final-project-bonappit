<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 7/9/2021
  Time: 2:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Registration</title>
</head>
<h1>Admin Registration</h1>
<p>Please enter requested data</p><br>
<form action="createAdmin" method="post">
    <label for="restaurantName">Restaurant Name:</label>
    <input type="text" id="restaurantName" name="restaurantName">
    <br></br>
    <label for="username">User Name:</label>
    <input type="text" id="username" name="username">
    <br></br>
    <label for="password">Password:</label>
    <input type="text" id="password" name="password">
    <br></br>
    <label for="numberTable">Number Table:</label>
    <input type="text" id="numberTable" name="numberTable">
    <br></br>
    <label for="menu">Menu:</label>
    <input type="text" id="menu" name="menu">
    <input type="submit" value="Register">
</form>

<a href="loginServlet">return to login </a>

</body>
</html>

