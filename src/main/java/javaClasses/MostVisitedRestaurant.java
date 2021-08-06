package javaClasses;

import database.RestaurantsDao;

import java.util.List;

public class MostVisitedRestaurant {
    private String username;
    private RestaurantsDao restaurantsDao;

    public MostVisitedRestaurant(String username, RestaurantsDao restaurantsDao){
        this.username = username;
        this.restaurantsDao = restaurantsDao;
    }

    public List<String> getMostVisitedRestaurants(){
        return restaurantsDao.mostVisitedRestaurants(username);
    }
}
