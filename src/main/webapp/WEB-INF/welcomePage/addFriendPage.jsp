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
    <label for="friendName">User Name:</label><br>
    <input type="text" id="friendName" name="friendName" required/>
    <input type="hidden" name="restaurantId" value="<%=request.getParameter("restaurantId")%>">
    <input type="hidden" name="username" value="<%=request.getParameter("username")%>">
    <button type="submit">Add Friend</button>
</form>

</body>
</html>
