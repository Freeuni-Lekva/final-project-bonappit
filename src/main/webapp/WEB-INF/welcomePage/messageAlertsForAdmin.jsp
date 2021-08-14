<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 8/14/2021
  Time: 10:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Alert</title>
    <%String massage="";
    if(request.getParameter("status").equals("0"))
        massage="Already Accepted";
    else if(request.getParameter("status").equals("1"))
        massage="Already accepted! Reject is denied!";
                else if(request.getParameter("status").equals("0"))
                    massage="Dinner does not started yet! Can not end!";
    }
                %>

</head>
<body>
<h1><%=massage%></h1>
<%
    out.print("<a href=\"adminHomePage?username=" + request.getParameter("admin") "\">Home Page</a>");
%>

</body>
</html>
