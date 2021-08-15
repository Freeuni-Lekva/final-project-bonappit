<%@ page import="java.util.ArrayList" %>
<%@ page import="database.RestaurantsDao" %>
<%@ page import="javaClasses.Restaurant" %>
<%@ page import="java.util.List" %>
<%@ page import="javaClasses.MostVisitedRestaurant" %>
<%@ page import="javaClasses.ProductsInMenu" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 28-Jul-21
  Time: 1:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<style>
    form {
        border: 1ch solid #f1f1f1;
        width: 100%;
    }

    body {
        background-color: gray;
    }

    .Pageheader {
        padding: 10px;
        text-align: center;
        background: #1abc9c;
        color: white;
        font-size: 15px;
    }

    #homePageInput {
        background-position: 10px 11px;
        width: 100%;
        font-size: 16px;
        padding: 12px 20px 12px 40px;
        border: 1px solid #ddd;
        margin-bottom: 11px;
    }

    #thisUl {
        list-style-type: none;
        padding: 0;
        margin: 0;
    }

    #thisUl li a {
        border: 1px solid #ddd;
        margin-top: -1px;
        background-color: #f6f6f6;
        padding: 12px;
        text-decoration: none;
        font-size: 18px;
        color: black;
        display: block;
    }

    #thisUl li a:hover:not(.header) {
        background-color: #eee;
    }

    /*now write links style*/
    .links {
        width: 100%;
        background-color: #555;
        overflow: auto;
    }

    .links a {
        float: left;
        padding: 12px;
        color: white;
        text-decoration: none;
        font-size: 17px;
        width: 18%;
        text-align: center;
    }

    .links a:hover {
        background-color: #04AA6D;
    }

    /*style for below table*/
    .restLink {
        width: 100%;
        background-color: gray;
        overflow: auto;
    }

    .restLink a {
        float: left;
        padding: 12px;
        color: white;
        text-decoration: none;
        font-size: 17px;
        width: 95%;
        text-align: left;
    }

    .restLink a:hover {
        background-color: #555;
    }


</style>

<script>
    function search() {
        var inp = document.getElementById('homePageInput');
        var filterRestaurant = inp.value.toUpperCase();
        var UL = document.getElementById("thisUl");
        var LItype = UL.getElementsByTagName('li');

        for (var i = 0; i < LItype.length; i++) {
            var aVar = LItype[i].getElementsByTagName("a")[0];
            var txtValue = aVar.textContent || aVar.innerText;
            if (txtValue.toUpperCase().indexOf(filterRestaurant) > -1) {
                LItype[i].style.display = "";
            } else {
                LItype[i].style.display = "none";
            }
        }
    }
</script>

<head>
    <title>Welcome <%= request.getParameter("username")%></title>
</head>
<body>

<div class="links">
    <%
        out.println("<a href=\"chatPge\">Chat</a>");
        out.print("<a href=\"currentReservations?restaurantId=" + request.getParameter("restaurantId") +
                "&username=" + request.getParameter("username") + "\">My Reservations </a>");
        out.print("<a href=\"addFriendServlet?restaurantId=" + request.getParameter("restaurantId") +
                "&username=" + request.getParameter("username") + "\">Add Friends </a>");

        out.print("<a href=\"evaluateVisitServlet?restaurantId=" + request.getParameter("restaurantId") +
                "&username=" + request.getParameter("username") + "\">Visits Evaluation</a>");
        out.print("<a href=\"inviteOnReservationServlet?restaurantId=" + request.getParameter("restaurantId") +
                "&username=" + request.getParameter("username") + "\">Invites on Reservation</a>");
    %>

</div>

<div class="Pageheader">
    <h1>Welcome <%= request.getParameter("username")%></h1>
    <p>Please, choose restaurant <%= request.getParameter("username")%> </p
    <p>Restaurants are sorted by rating </p><br>
</div>


<u1>

    <%
        RestaurantsDao restaurantDao = (RestaurantsDao) request.getServletContext().getAttribute(RestaurantsDao.daoString);
        ArrayList<Restaurant> restaurants = (ArrayList<Restaurant>) restaurantDao.getRestaurants();
        ProductsInMenu productsInMenu = (ProductsInMenu) request.getSession().getAttribute("products");
        productsInMenu.clearMenu();
    %>

    <%!
        static int partition(ArrayList<Restaurant> array, int begin, int end) {
            int pivot = end;

            int counter = begin;
            for (int i = begin; i < end; i++) {
                if (array.get(i).getRating() > array.get(pivot).getRating()) {
                    Restaurant temp = array.get(counter);
                    array.set(counter, array.get(i));
                    array.set(i, temp);
                    counter++;
                }
            }
            Restaurant temp = array.get(pivot);
            array.set(pivot, array.get(counter));
            array.set(counter, temp);

            return counter;
        }

        public void quickSort(ArrayList<Restaurant> array, int begin, int end) {
            if (end <= begin) return;
            int pivot = partition(array, begin, end);
            quickSort(array, begin, pivot-1);
            quickSort(array, pivot+1, end);
        }
    %>

    <input type="text" id="homePageInput" onkeyup="search()" placeholder="search for restaurants...">
    <ul id="thisUl">
      <%
          quickSort(restaurants, 0, restaurants.size() - 1);
          for(javaClasses.Restaurant restaurant : restaurants) {
            out.print("<li><a href=\"restaurantPage?restaurantId=" + restaurant.getId() +
                    "&username=" + request.getParameter("username") + "\">"
                    + restaurant.getName() + " - Rating " + restaurant.getRating() + "</a></li>");
        }
    %>
    </ul>

</u1><br>

<br>
<div class="Pageheader">
<h2>Most visited Restaurants</h2>
</div>

<div class="restLink">
<%

    MostVisitedRestaurant mostVisitedRestaurant = new MostVisitedRestaurant(request.getParameter("username"), restaurantDao);
    List<String> mostViwed = mostVisitedRestaurant.getMostVisitedRestaurants();

    for(String id : mostViwed) {
        Restaurant restaurant = restaurantDao.getRestaurantById(id);
        out.print("<a href=\"restaurantPage?restaurantId=" + restaurant.getId() +
                "&username=" + request.getParameter("username") + "\">"
                + restaurant.getName() + "</a>");
    }
%>
</div>


</body>
</html>
