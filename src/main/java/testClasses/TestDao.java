package testClasses;


import database.RestaurantsDao;
import javaClasses.Product;
import javaClasses.ProductsInMenu;
import javaClasses.Restaurant;
import javaClasses.User;
import junit.framework.TestCase;

import java.util.List;

public class TestDao extends TestCase {

    public void testGetUser() {
        RestaurantsDao restaurantsDao = new RestaurantsDao();
        User user =  restaurantsDao.getUserByUsername("saba");
        assertEquals("1", user.getRestaurantId());
        assertEquals("saba", user.getPassword());
        assertTrue(user.isAdmin());

        user = restaurantsDao.getUserByUsername("beqa");
        assertEquals("-1", user.getRestaurantId());
        assertEquals("beqa", user.getPassword());
        assertFalse(user.isAdmin());

        user = restaurantsDao.getUserById("1");
        assertEquals("saba", user.getUsername());
        assertTrue(user.isAdmin());

    }

    public void testGetRestaurant() {
        RestaurantsDao restaurantsDao = new RestaurantsDao();
        Restaurant restaurant = restaurantsDao.getRestaurantById("1");
        assertEquals("1", restaurant.getId());
        assertEquals("domino.txt", restaurant.getMenu());
        assertEquals("Domino", restaurant.getName());
        assertEquals(10, restaurant.getNumTable());

        List<Restaurant> restaurants = restaurantsDao.getRestaurants();
        Restaurant restaurant1 = restaurants.get(0);
        Restaurant restaurant2 = restaurants.get(1);
        assertEquals("1", restaurant1.getId());
        assertEquals("2", restaurant2.getId());
        assertEquals("KFC", restaurant2.getName());

    }

    public void testReservations(){
        RestaurantsDao restaurantsDao = new RestaurantsDao();
        String username = "temp1";
        String friendName = "temp2";
        String restaurantId = "temp3";

        ProductsInMenu productsInMenu = new ProductsInMenu();
        productsInMenu.addProduct(new Product("1", 1), restaurantId);
        restaurantsDao.addReservations(username, restaurantId, friendName, productsInMenu);

        assertTrue(restaurantsDao.hasreservation(username, restaurantId));
        assertFalse(restaurantsDao.rejected(username, restaurantId));
        assertFalse(restaurantsDao.reserved(username, restaurantId));

        restaurantsDao.getChangedMenu(username, restaurantId, productsInMenu);

        restaurantsDao.removeReservation(username, restaurantId);

    }

    public void testReservations2(){
        RestaurantsDao restaurantsDao = new RestaurantsDao();
        String username = "temp1";
        String friendName = "temp2";
        String restaurantId = "temp3";

        ProductsInMenu productsInMenu = new ProductsInMenu();
        productsInMenu.addProduct(new Product("1", 1), restaurantId);
        restaurantsDao.addReservations(username, restaurantId, friendName, productsInMenu);

        assertTrue(restaurantsDao.hasreservation(username, restaurantId));

        restaurantsDao.rejectReservation(username, restaurantId);
        assertTrue(restaurantsDao.rejected(username, restaurantId));

        restaurantsDao.removeReservation(username, restaurantId);

        restaurantsDao.addReservations(username, restaurantId, friendName, productsInMenu);
        restaurantsDao.acceptReservation(username, restaurantId);
        assertTrue(restaurantsDao.reserved(username, restaurantId));

        restaurantsDao.removeReservation(username, restaurantId);
    }

    public void testReservations3(){
        RestaurantsDao restaurantsDao = new RestaurantsDao();
        String username = "temp1";
        String friendName = "temp2";
        String restaurantId = "temp3";

        ProductsInMenu productsInMenu = new ProductsInMenu();
        productsInMenu.addProduct(new Product("1", 1), restaurantId);
        restaurantsDao.addReservations(username, restaurantId, friendName, productsInMenu);

        productsInMenu.addProduct(new Product("2", 2), restaurantId);
        restaurantsDao.changeReservation(username, restaurantId, friendName, productsInMenu);

        assertEquals(1, restaurantsDao.getReservationList(restaurantId).size());
        assertEquals(0, restaurantsDao.getUserReservations(username).size());

        restaurantsDao.removeReservation(username, restaurantId);

    }

    public void testFriends(){
        RestaurantsDao restaurantsDao = new RestaurantsDao();
        String username = "temp1";
        String friendName = "temp2";

        assertEquals(0, restaurantsDao.getFriends(username).size());
        assertEquals(0, restaurantsDao.getFriends(friendName).size());

        assertEquals(0, restaurantsDao.friendRequestsReceived(username).size());

    }

}
