<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>

<html>

<head>
    <title>
        Display table with vertical scrollbar
    </title>

    <style>
        table.scrolldown{
            width: 100%;
            /* border-collapse: collapse; */
            border-spacing: 0;
            border: 2px black;
        }

        /* To display the block as level element */
        table.scrolldown tbody, table.scrolldown thead {
            display: -ms-inline-flexbox;
        }

        thead tr th {
            height: 40px;
            line-height: 40px;
        }

        table.scrolldown tbody {

            /* Set the height of table body */
            height: 50px;

            /* Set vertical scroll */
            overflow-y: auto;

            /* Hide the horizontal scroll */
            overflow-x: initial;
        }

        tbody {
            border-top: 2px black;
        }

        tbody td, thead th {
            width : 200px;
            border-right: 2px springgreen;
        }
        td {
            text-align:center;
        }
    </style>
</head>
<body>
<center>
    <h1>Welcome</h1>
</center>
<div align="center">
    <form method="post">
    <table border="1" cellpadding="3">
        <caption><h2><%= request.getParameter("username")%></h2></caption>
        <tr>
            <th>Name</th>
            <th>Menu</th>
            <th>Status</th>
            <th>R/A</th>
        </tr>
        <%
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                String url="jdbc:mysql://localhost/DB_restaurants";
                String username="root";
                String password="root";
                String query="select * from reservations";
                Connection conn=DriverManager.getConnection(url, username, password);
                Statement stmt=conn.createStatement();
                ResultSet rs=stmt.executeQuery(query);
                while(rs.next())
                {
        %>
                <tr><td><%rs.getString("username"); %></td></tr>
                <tr><td> <a href="menu?id=">Menu</a></td></tr>
                 <tr><td><%rs.getString("username"); %></td></tr>
               <tr> <td><button type="button" onclick="">Reject </button>
                    <button type="button" onclick="">Accept </button>
               </td></tr>
        <%
            }
        %>
    </table>
    <%
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    %>
    </form>
</div>
</body>
</html>