<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 28-Jul-21
  Time: 12:32 PM
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
        padding: 12px 22px;
        margin: 7px 0;
        display: inline-block;
        border: 1px solid #ccc;
        box-sizing: border-box;
    }
    button {
        background-color: #04AA6D;
        color: white;
        padding: 15px 20px;
        margin: 7px 0;
        border: none;
        cursor: pointer;
        width: 40%;
    }
    button:hover {
        opacity: 0.8;
    }
    .container {
        padding: 15px;
    }

    #message {
        display:none;
        background: #f1f1f1;
        color: #000;
        position: relative;
        padding: 20px;
        margin-top: 10px;
    }

    #message p {
        padding: 10px 35px;
        font-size: 18px;
    }

    .invalid {
        color: red;
    }

    .invalid:before {
        position: relative;
        left: -35px;
        content: "&#10006;";
    }

</style>

<script>
    var myInput = document.getElementById("password");
    var myInput2 = document.getElementById("username");
    var number = document.getElementById("number");
    var length = document.getElementById("length");

    myInput.onfocus = function() {
        document.getElementById("message").style.display = "block";
    }

    myInput.onblur = function() {
        document.getElementById("message").style.display = "none";
    }

    myInput.onkeyup = function() {
        var numbers = /[0-9]/g;
        if(myInput.value.match(numbers)) {
            number.classList.remove("invalid");
            number.classList.add("valid");
        } else {
            number.classList.remove("valid");
            number.classList.add("invalid");
        }

        if(myInput.value.length <= 8 && myInput.value.length > 0) {
            length.classList.remove("invalid");
            length.classList.add("valid");
        } else {
            length.classList.remove("valid");
            length.classList.add("invalid");
        }

        myInput2.onfocus = function() {
            document.getElementById("message").style.display = "block";
        }

        myInput2.onblur = function() {
            document.getElementById("message").style.display = "none";
        }

        myInput2.onkeyup = function() {
            var numbers = /[0-9]/g;
            if (myInput.value.match(numbers)) {
                number.classList.remove("invalid");
                number.classList.add("valid");
            } else {
                number.classList.remove("valid");
                number.classList.add("invalid");
            }

            if (myInput.value.length <= 8 && myInput.value.length > 0) {
                length.classList.remove("invalid");
                length.classList.add("valid");
            } else {
                length.classList.remove("valid");
                length.classList.add("invalid");
            }
        }
    }
</script>

<head>
    <title>Wrong Account</title>
</head>
<body>
<div align="center">
    <h1>Please Try Again</h1>
    <p>Either your username or password is incorrect. Please try again.</p>
    <form action="loginServlet" method="post">
        <div class="container">
            <label for="username">User Name:</label><br>
            <input type="text" id="username" name="username" pattern="(?=.*\d).{1,8}"
                   title="Must contain at least one number and maximum 8 or less characters" required><br>
            <label for="password">Password:</label><br>
            <input id="password" type="text" name="password" pattern="(?=.*\d).{1,8}"
                   title="Must contain at least one number and maximum 8 or less characters" required><br>
            <button type="submit">login</button>
        </div>
    </form>

    <div id="message">
        <h3>must contain the following:</h3>
        <p id="number" class="invalid">A <b>number</b></p>
        <p id="length" class="invalid">Minimum <b>8 characters</b></p>
    </div>

    <a href="createAccount">Create New Account </a>

</div>
</body>
</html>
