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
<head>
    <title>Welcome <%= request.getParameter("username")%></title>
</head>
<body>
<h1>Welcome <%= request.getParameter("username")%></h1>
<p>Please, choose restaurant <%= request.getParameter("username")%> </p
<p>Restaurants are sorted by rating </p>


<u1>

    <%
        RestaurantsDao restaurantDao = new RestaurantsDao();
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

      <%
          quickSort(restaurants, 0, restaurants.size() - 1);
          for(javaClasses.Restaurant restaurant : restaurants) {
            out.print("<li><a href=\"restaurantPage?restaurantId=" + restaurant.getId() +
                    "&username=" + request.getParameter("username") + "\">"
                    + restaurant.getName() + "</a>" +
                    " Rating " + restaurant.getRating() + "</li><br></br>");
            out.println("\n");
        }
    %>

</u1><br>

<a href="chatPge">Open Chat </a><br>

<%
    out.print("<a href=\"currentReservations?restaurantId=" + request.getParameter("restaurantId") +
            "&username=" + request.getParameter("username") + "\">My Reservations </a><br>");
    out.print("<a href=\"addFriendServlet?restaurantId=" + request.getParameter("restaurantId") +
            "&username=" + request.getParameter("username") + "\">Add Friends </a><br>");
%>


<br>
<h2>Most visited Restaurants</h2>

<%

    MostVisitedRestaurant mostVisitedRestaurant = new MostVisitedRestaurant(request.getParameter("username"), restaurantDao);
    List<String> mostViwed = mostVisitedRestaurant.getMostVisitedRestaurants();

    for(String id : mostViwed) {
        Restaurant restaurant = restaurantDao.getRestaurantById(id);
        out.print("<li><a href=\"restaurantPage?restaurantId=" + restaurant.getId() +
                "&username=" + request.getParameter("username") + "\">"
                + restaurant.getName() + "</a></li>");
    }
%>


</body>
</html>
