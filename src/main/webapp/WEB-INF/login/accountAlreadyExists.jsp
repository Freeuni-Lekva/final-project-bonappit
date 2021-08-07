<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 28-Jul-21
  Time: 1:31 PM
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
  <title>Create Account</title>
</head>
<body>
<div align="center">
  <h1>The Name <%= request.getParameter("username")%> is Already In Use</h1>

  <p>Please enter another username</p>

  <form action="createAccount" method="post">
    <div class="container">
      <label for="username">User Name:</label><br>
      <input type="text" id="username" name="username"><br>
      <label for="password">Password:</label><br>
      <input type="text" id="password" name="password"><br>
      <input type="submit" value="Register">
    </div>
  </form>

  <a href="adminRegistration" style="color:dodgerblue">Register as restaurant </a>

</div>
</body>
</html>
