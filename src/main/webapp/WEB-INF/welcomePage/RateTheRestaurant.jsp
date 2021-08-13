
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

    <title>Notation</title>


    <style>
        body {
            font-family: Verdana, arial;
        }

        .notation-text {
            color: #000000;
            font-size: 18px;
            text-align: center;
            margin: 18px;
        }

        .notation-block-star {
            display: table;
            margin: 0 auto;
            width: inherit;
        }


        .notation-star {
            background-image: url("https://upload.wikimedia.org/wikipedia/commons/thumb/e/e7/Empty_Star.svg/2000px-Empty_Star.svg.png");
            background-repeat: no-repeat;
            cursor: pointer;
            display: table-cell;
            float: right;
            height: 20px;
            width: 20px;
            padding:  5px;
            background-size: cover;
        }


        .notation-star:hover,
        .notation-star:hover ~ .notation-star {
            background-image: url("http://findicons.com/files/icons/1035/human_o2/128/bookmark_new.png");
        }

        .notation-star-selected {
            background-image: initial;
            background-repeat: no-repeat;
            cursor: pointer;
            display: table-cell;
            float: right;
            height: 64px;
            width: 64px;
            padding: 0 5px;
        }

        .notation-star-selected  ~ .notation-star {
            background-image: initial;
        }
    </style>

</head>

<div class="notation-text">Thank you for choosing us!+<%= request.getParameter("username")%></div>


<form method="post" action="voting">
    <div id="star5" class="notation-star" onClick="notation(this.id);"></div>
    <div id="star4" class="notation-star" onClick="notation(this.id);"></div>
    <div id="star3" class="notation-star" onClick="notation(this.id);"></div>
    <div id="star2" class="notation-star" onClick="notation(this.id);"></div>
    <div id="star1" class="notation-star" onClick="notation(this.id);"></div>
    <input type="hidden" id="notationNote" name="notation_note" value="0">
    <input type="submit" value="ok"></form>  <br>

<p id="vote"></p>

</html>

