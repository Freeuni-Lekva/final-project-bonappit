<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13-Aug-21
  Time: 6:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rate Visit</title>
</head>
<body>
<%
  if (!request.getAttribute("attribute").equals("")){
    out.println("<h1>" + request.getAttribute("attribute") +"</h1>");
  } else {
%>
  <h1>Rate your visit</h1>

  <form action="evaluateVisitServlet" method="post">
    <label for="rating">Rate Restaurant:</label><br>
    <input type="text" id="rating" name="rating" required/>
    <input type="hidden" name="restaurantId" value="<%=request.getParameter("restaurantId")%>">
    <input type="hidden" name="username" value="<%=request.getParameter("username")%>">
    <button type="submit">Confirm Rating</button>
  </form>

<%
  }
  out.print("<a href=\"homePage?restaurantId=" + request.getParameter("restaurantId") +
          "&username=" + request.getParameter("username") + "\">return to Home</a>");
%>

</body>
</html>
