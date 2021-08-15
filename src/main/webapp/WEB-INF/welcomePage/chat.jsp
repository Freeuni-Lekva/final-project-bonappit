<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 15-Aug-21
  Time: 8:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<%
    String uname = request.getParameter("username");
%>

<head>
    <link rel="stylesheet" type="text/css" href="styles.css">

    <title>Chatting Room</title>
    <link rel="shortcut icon" href="icon.jpeg" />

    <script>
        function startchating() {
            var uname = document.getElementById('username');
            var pw = document.getElementById('pw');
            if (uname.value == '' || pw.value == '') {
                alert('Please login to continue.');
                return false;
            }

            var xmlhttp;
            if (window.XMLHttpRequest) { // code for IE7+, Firefox, Chrome, Opera, Safari
                xmlhttp = new XMLHttpRequest();
            } else { // code for IE6, IE5
                xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
            }

            xmlhttp.open("POST", "chatClassServlet?uname=" + uname.value + "&pw=" + pw.value, true);

            document.getElementById("loading-icon").innerHTML = '<img src="loader.gif" border="0" alt="Loading, please wait..." />';
            xmlhttp.onreadystatechange = function() {
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                    if (xmlhttp.responseText.indexOf('Incorrect') !== -1) {
                        document.getElementById("loading-icon").innerHTML = "<h4 style='color:red'>" + xmlhttp.responseText + "<h4>";
                    } else {
                        document.getElementById("result-data").innerHTML = '<h1>' + xmlhttp.responseText + '</h1>';
                    }


                }


            }
            xmlhttp.send(null);

        }

        function addText()
        {
            var username = document.getElementById('u').value;
            var msg = document.getElementById('h').value;
            olist = document.getElementById('list');
            op = document.createElement('p');
            op.innerHTML = username + "- <g>" + msg + "</g>";
            ocontent = document.getElementById('content');
            ocontent.appendChild(op);             //Add new line on click
            olist.scrollTop = olist.scrollHeight; //Adjust Height
            document.getElementById('h').value = '';
            var xmlhttp;
            if (window.XMLHttpRequest)
            {// code for IE7+, Firefox, Chrome, Opera, Safari
                xmlhttp = new XMLHttpRequest();
            }
            else
            {// code for IE6, IE5
                xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
            }

            xmlhttp.open("POST", "chatServlet?uname=" + username + "&msg=" + msg, true);

            xmlhttp.onreadystatechange = function()
            {
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
                {
                    document.getElementById("result").innerHTML = 'sent';
                    document.getElementById("result").innerHTML = '';
                }
            }
            xmlhttp.send(null);
        }

        function reloaddata()
        {
            var xmlhttp;
            if (window.XMLHttpRequest)
            {// code for IE7+, Firefox, Chrome, Opera, Safari
                xmlhttp = new XMLHttpRequest();
            }
            else
            {// code for IE6, IE5
                xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
            }


            xmlhttp.open("POST", "openChat", true);

            xmlhttp.onreadystatechange = function()
            {
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
                {

                    document.getElementById("content").innerHTML = xmlhttp.responseText;
                    olist = document.getElementById('list'); //everything in id list
                    olist.scrollTop = olist.scrollHeight;


                }


            }
            xmlhttp.send(null);

        }

    </script>

    <script>
        setInterval(reloaddata, 3000);
    </script>
</head>

<body>
<p id="result"></p>
    Welcome, <%=uname%>

<div id="list">
    <div id="content">
    </div>
    <input style="display: none" type="text" id="u" value="<%=uname%>">
    <textarea id='h' style="width: 100%; height: 10%;"></textarea>
    <input type="button" value="send" onclick="addText()" />
</div>
</body>


</html>
