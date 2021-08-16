<%@ page import="database.RestaurantsDao" %>
<%@ page import="javaClasses.User" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="javaClasses.Restaurant" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 15-Aug-21
  Time: 8:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<%
    String username = request.getParameter("username");
    String to = request.getParameter("to");

    RestaurantsDao restaurantsDao = (RestaurantsDao) request.getServletContext().getAttribute(RestaurantsDao.daoString);
    String id = restaurantsDao.getUserByUsername(request.getParameter("username")).getRestaurantId();
%>

<style>

    .Pageheader {
        padding: 10px;
        text-align: center;
        background: #1abc9c;
        color: white;
        font-size: 15px;
    }

    body {
        margin: 0 auto;
        max-width: 800px;
        border-bottom: 100px;
        padding: 0 20px;
        scroll-margin-block-end: 50px;
    }

    .container {
        border: 2px solid #dedede;
        background-color: palegreen;
        border-radius: 5px;
        padding: 10px;
        margin: 10px 0;
    }

    .darker {
        border-color: #ccc;
        background-color: forestgreen;
        text-align: right;
    }

    .container::after {
        content: "";
        clear: both;
        display: table;
    }

</style>

<head>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <title>Chatting Room</title>
</head>

<body>

<div class="Pageheader">
    <h1> Welcome, <%=username%> to Chatting Room</h1>
</div>

   <form name="chatServlet" action="chatServlet" method="post">
       <input type="hidden" name="username" value="<%=username%>">
       <input type="hidden" name="to" value="<%=to%>">

        <br><br>
<%--       <textarea  readonly="readonly"   name="txtMessage" rows="50" cols="80">--%>
       <%
           ResultSet result = restaurantsDao.getResultSet("chat");

           try {
               while (result.next()) {
                   String currUser = result.getString("messagefrom");
                   String currTo = result.getString("messageto");

                   if (currTo.equals(to) && currUser.equals(username)) {
                       out.println("<div class=\"container\">");
                       String messages = currUser + " >> " + result.getString("message");
                       out.println(messages);
                       out.println("</div>");
                   } else if (currTo.equals(username) && currUser.equals(to)){
                       out.println("<div class=\"container darker\">");
                       String messages = result.getString("message") + " << " + currUser;
                       out.println(messages);
                       out.println("</div>");
                   }
               }
           } catch (SQLException throwables) {
               throwables.printStackTrace();
           }
       %>

<%--</textarea>--%>

       <input type="text" name="txtMsg" value="">
       <input type="submit" value="Send" name="cmdSend">
   </form>


    <%
        out.print("<a href=\"chatServlet?to=" + to +
                "&username=" + username + "\">refresh chat</a>");
    %>

    <%
        if (!id.equals("-1")){
            Restaurant restaurant = restaurantsDao.getRestaurantById(id);
            User user = restaurantsDao.getUserById(restaurant.getId());
            out.print("<a href=\"adminHomePage?restaurantId=" + id +
                    "&username=" + user.getUsername() + "\">Home</a>");
        } else {
            out.print("<a href=\"homePage?username=" + request.getParameter("username") + "\">Home</a>");
        }

    %>

</body>

</html>
