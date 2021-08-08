<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 08-Aug-21
  Time: 5:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Friends</title>
</head>
<body>
<h1>Find Friends</h1>
<p>Please find friend</p>

<form action="addFriendServlet" method="post">
    <label for="username">User Name:</label><br>
    <input type="text" id="username" name="username" required/>
    <button type="submit">Find Friend</button>
</form>

</body>
</html>
