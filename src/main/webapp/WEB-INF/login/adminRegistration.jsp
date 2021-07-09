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
<form action="adminRegitration" method="post">
    <label for="RestaurantName">User Name:</label>
    <input type="text" id="RestaurantName" name="RestaurantName"><br>
    <label for="Password">Password:</label>
    <input type="text" id="Password" name="Password">
    <label for="NumberTable">Number Table:</label>
    <input type="text" id="NumberTable" name="NumberTable">
    <label for="Menu">Menu:</label>
    <input type="text" id="Menu" name="Menu">
    <input type="submit" value="Login">
</form>

<a href="createAccount">go back </a>

</body>
</html>

