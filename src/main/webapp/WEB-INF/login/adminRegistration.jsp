<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 7/9/2021
  Time: 2:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<style>
    * {box-sizing: border-box}

    input[type=text], input[type=password] {
        width: 40%;
        padding: 15px;
        margin: 5px 0 22px 0;
        display: inline-block;
        border: none;
        background: #f1f1f1;
    }

    input[type=text]:focus, input[type=password]:focus {
        background-color: #ddd;
        outline: none;
    }

    hr {
        border: 1px solid #f1f1f1;
        margin-bottom: 25px;
    }

    button {
        background-color: #04AA6D;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        cursor: pointer;
        width: 40%;
        opacity: 0.9;
    }

    button:hover {
        opacity:1;
    }

    .container {
        padding: 16px;
    }
</style>

<head>
    <title>Admin Registration</title>
</head>
<h1>Admin Registration</h1>
<p>Please enter requested data</p><br>
<form action="createAdmin" method="post">
    <div class="container">
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
        <br></br>
        <input type="submit" value="Register">
    </div>
</form>

<a href="loginServlet" style="color:dodgerblue">return to login </a>

</body>
</html>

