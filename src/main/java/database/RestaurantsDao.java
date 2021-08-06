package database;

import javaClasses.Restaurant;
import javaClasses.User;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RestaurantsDao {
    private Statement statement;
    private Connection connection;
    private static final String insertSt = "insert into restaurants values (?, ?, ?,?);";
    private static final String insertUser = "insert into users values (?, ?, ?,?);";


    public RestaurantsDao(){

    }

    //connector code
    private ResultSet getResultSet(String str) {
        ResultSet result = null;
        DB_restaurants db_products = new DB_restaurants();
        BasicDataSource dataSource = db_products.getDataSoruce();

        connection = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            String tempString = "select * from " + str + ";";
            result = statement.executeQuery(tempString);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }


    //gets product from sql database by id
    public User getUserByUsername(String thisUserName){
        User user = null;
        ResultSet result = getResultSet("users");

        try {
            while (result.next()) {

                String currUserName = result.getString("username");
                if (currUserName.equals(thisUserName)) {
                    String username = result.getString("username");
                    String password = result.getString("password");
                    boolean isAdmin = result.getBoolean("type");
                    String restaurantId = result.getString("restaurantid");

                    user = new User(username, password, isAdmin, restaurantId);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }


    public String getLastId(){
        String resultId = "";

        ResultSet result = getResultSet("restaurants");
        try {
            while (result.next()) {
                if (result.isLast()) {
                    resultId = result.getString("restaurantid");
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultId;
    }


    public Restaurant getRestaurantById(String restaurantId){
        Restaurant res = null;
        ResultSet result = getResultSet("restaurants");
        ResultSet result1 = getResultSet("visits");

        try {
            while (result.next()) {
                String curr= result.getString("restaurantid");
                if (curr.equals(restaurantId)) {
                    res = takeRestaurant(result, result1);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
    }


    //returns all user from database
    public List<Restaurant> getRestaurants(){
        List<Restaurant> restaurants = new ArrayList<>();
        ResultSet result = getResultSet("restaurants");
        ResultSet result1;

        try {
            while (result.next()) {
                result1 = getResultSet("visits");
                Restaurant restaurant = takeRestaurant(result, result1);

                restaurants.add(restaurant);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return restaurants;
    }


    //this return most visited place for current log inned user
    public List<String> mostVisitedRestaurants(String thisUserName){
        List<String> restaurants = new ArrayList<>();
        ResultSet result = getResultSet("visits");

        while (restaurants.size() < 4) {
            if (restaurants.size() > 0)
                result = getResultSet("visits");

            String currRestaurantId = "-1";
            int numVisits = 0;
            try {
                while (result.next()) {
                    String currUserName = result.getString("username");
                    String tempId = result.getString("restaurantid");
                    if (currUserName.equals(thisUserName) && !restaurants.contains(tempId)) {
                        if (numVisits <= result.getInt("numvisits")) {
                            numVisits = result.getInt("numvisits");
                            currRestaurantId = tempId;
                        }
                    }
                }
                if (currRestaurantId.equals("-1"))
                    break;

                restaurants.add(currRestaurantId);

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return restaurants;
    }



    //private void to take restaurant from database
    private Restaurant takeRestaurant(ResultSet result, ResultSet result1) {
        Restaurant restaurant = null;
        double rating = 0;
        int n = 0;

        try {
            String id = result.getString("restaurantid");
            String name = result.getString("name");
            String menu = result.getString("menufile");
            int numTable = result.getInt("numtables");

            while (result1.next()) {
                String curr1 = result1.getString("restaurantid");
                if (curr1.equals(id)) {
                    n = result1.getInt("numvisits");
                    rating = result1.getDouble("rating");
                }
            }
            if(n == 0)
                rating = -1;

            restaurant = new Restaurant(name, id, menu, numTable, rating);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return restaurant;
    }


    public void addUser(User user) throws SQLException {
        try {
            PreparedStatement ps = connection.prepareStatement(insertUser);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setBoolean(3, user.isAdmin());
            ps.setString(4, user.getRestaurantId());

            ps.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }


    public void addRestaurant(Restaurant res) {
        try {
            PreparedStatement ps = connection.prepareStatement(insertSt);
            ps.setString(1, res.getId());
            ps.setString(2, res.getName());
            ps.setString(3, res.getMenu());
            ps.setInt(4, res.getNumTable());

            ps.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}
