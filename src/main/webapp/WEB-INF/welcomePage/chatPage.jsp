<head>

</head>

<title>Chat</title>
<body>
<h1>Welcome to Chat</h1>

<%
    out.print("<a href=\"chat?restaurantId=" + request.getParameter("restaurantId") +
            "&username=" + request.getParameter("username") +
            "&to=" + "beqa2" +
            "\">go to chatting room</a>");
%>


</body>
</html>
