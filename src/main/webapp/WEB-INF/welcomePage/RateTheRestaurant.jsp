
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 8/14/2021
  Time: 12:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <link href="css/style.css" rel="stylesheet" type="text/css">

    <title>Rate your visit</title>


    <style>
        body {
            font-family: Verdana, arial;
        }

        .Pageheader {
            padding: 10px;
            text-align: center;
            background: #1abc9c;
            color: white;
            font-size: 15px;
        }

        #thisUl li a:hover:not(.header) {
            background-color: #eee;
        }

        .notation-text {
            color: #000000;
            font-size: 18px;
            text-align: center;
            margin: 18px;
        }

        .notation-star {
            background-image: url("https://upload.wikimedia.org/wikipedia/commons/thumb/e/e7/Empty_Star.svg/2000px-Empty_Star.svg.png");
            background-repeat: no-repeat;
            cursor: pointer;
            display: table-cell;
            float: right;
            height: 60px;
            width: 60px;
            padding:  10px;
            background-size: cover;
        }


        .notation-star:hover,
        .notation-star:hover ~ .notation-star {
            background-image: url("http://findicons.com/files/icons/1035/human_o2/128/bookmark_new.png");
        }

        .notation-star-selected ~ .notation-star {
            background-image: initial;
            background-repeat: no-repeat;
            cursor: pointer;
            display: table-cell;
            float: right;
            height: 84px;
            width: 84px;
            padding: 0 5px;
            background-image: initial;
        }

        .links {
            width: 100%;
            background-color: gray;
            overflow: auto;
        }

        .links a {
            float: left;
            padding: 12px;
            color: white;
            text-decoration: none;
            font-size: 15px;
            width: 98%;
            text-align: center;
        }

        .links a:hover {
            background-color: #555;
        }
    </style>

</head>
<body>

<div class="Pageheader">
<%
    if (!request.getParameter("attribute").equals("")){
        out.println("<h1>" + request.getParameter("attribute") +"</h1></div>");
    } else {
%>

<h1>Thank you for choosing us!</h1></div>


<form method="post" action="evaluateVisitServlet">
    <button name="rating" class="notation-star"type="submit" value="10">
        <input type="hidden" name="restaurantId" value="<%=request.getParameter("restaurantId")%>">
        <input type="hidden" name="username" value="<%=request.getParameter("username")%>">
    </button>
    <button name="rating" class="notation-star"type="submit" value="9">
        <input type="hidden" name="restaurantId" value="<%=request.getParameter("restaurantId")%>">
        <input type="hidden" name="username" value="<%=request.getParameter("username")%>">
    </button>
    <button name="rating" class="notation-star"type="submit" value="8">
        <input type="hidden" name="restaurantId" value="<%=request.getParameter("restaurantId")%>">
        <input type="hidden" name="username" value="<%=request.getParameter("username")%>">
    </button>
    <button name="rating" class="notation-star"type="submit" value="7">
        <input type="hidden" name="restaurantId" value="<%=request.getParameter("restaurantId")%>">
        <input type="hidden" name="username" value="<%=request.getParameter("username")%>">
    </button>
    <button name="rating" class="notation-star"type="submit" value="6">
        <input type="hidden" name="restaurantId" value="<%=request.getParameter("restaurantId")%>">
        <input type="hidden" name="username" value="<%=request.getParameter("username")%>">
    </button>
    <button name="rating" class="notation-star"type="submit" value="5">
        <input type="hidden" name="restaurantId" value="<%=request.getParameter("restaurantId")%>">
        <input type="hidden" name="username" value="<%=request.getParameter("username")%>">
    </button>
    <button name="rating" class="notation-star"type="submit" value="4">
        <input type="hidden" name="restaurantId" value="<%=request.getParameter("restaurantId")%>">
        <input type="hidden" name="username" value="<%=request.getParameter("username")%>">
    </button>
    <button name="rating" class="notation-star"type="submit" value="3">
        <input type="hidden" name="restaurantId" value="<%=request.getParameter("restaurantId")%>">
        <input type="hidden" name="username" value="<%=request.getParameter("username")%>">
    </button>
    <button name="rating" class="notation-star"type="submit" value="2">
        <input type="hidden" name="restaurantId" value="<%=request.getParameter("restaurantId")%>">
        <input type="hidden" name="username" value="<%=request.getParameter("username")%>">
    </button>
    <button name="rating" class="notation-star"type="submit" value="1">
        <input type="hidden" name="restaurantId" value="<%=request.getParameter("restaurantId")%>">
        <input type="hidden" name="username" value="<%=request.getParameter("username")%>">
    </button>
    <button name="rating" class="notation-star"type="submit" value="0">
        <input type="hidden" name="restaurantId" value="<%=request.getParameter("restaurantId")%>">
        <input type="hidden" name="username" value="<%=request.getParameter("username")%>">
    </button>



<%
    }
    %>
    <div class="links">
    <%
    out.print("<a href=\"homePage?restaurantId=" + request.getParameter("restaurantId") +
            "&username=" + request.getParameter("username") + "\">return to Home</a>");
    %>
    </div>

</body>
</html>
