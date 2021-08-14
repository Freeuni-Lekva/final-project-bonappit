<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 28-Jul-21
  Time: 12:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<style>
    form {
        border: 1ch solid #f1f1f1;
        width: 50%;
    }
    input[type=text], input[type=password] {
        width: 40%;
        padding: 12px 22px;
        margin: 7px 0;
        display: inline-block;
        border: 1px solid #ccc;
        box-sizing: border-box;
    }
    button {
        background-color: #04AA6D;
        color: white;
        padding: 15px 20px;
        margin: 7px 0;
        border: none;
        cursor: pointer;
        width: 40%;
    }
    button:hover {
        opacity: 0.8;
    }
    .container {
        padding: 15px;
    }
</style>

<head>
    <title>Wrong Account</title>
</head>
<body>
<div align="center">
    <h1>Please Try Again</h1>
    <p>Either your username or password is incorrect. Please try again.</p>
    <form action="loginServlet" method="post">
        <div class="container">
            <label for="username">User Name:</label><br>
            <input type="text" id="username" name="username" /><br>
            <label for="password">Password:</label><br>
            <input id="password" type="text" name="password"/><br>
            <button type="submit">login</button>
        </div>
    </form>

    <a href="createAccount">Create New Account </a>

</div>
</body>
</html>
