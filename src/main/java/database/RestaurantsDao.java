package database;

import com.sun.org.apache.bcel.internal.generic.ARETURN;
import javaClasses.*;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.*;

public class RestaurantsDao {
    public static final String daoString = "daoString";
    private Statement statement;
    private Connection connection;
    private static final String insertSt = "insert into restaurants values (?, ?, ?, ?);";
    private static final String insertUser = "insert into users values (?, ?, ?, ?);";
    private static final String insertReservation = "insert into reservations values (?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String removeReservation = "delete from reservations where (username=?) and (restaurantid=?)";
    private static final String removeReservation2 = "delete from reservations where username=?";
    private static final String insertFriend = "insert into friends values (?, ?, ?);";
    private static final String removeFriendFalse = "delete from friends where (username=?) and (friendname=?)";
    private static final String insertVisit = "insert into visits values (?, ?, ?, ?);";
    private static final String removeEvaluationRequest = "delete from visits where (username=?) and (restaurantid=?) and (rating=?)";
    private static final String accept="UPDATE reservations set reserved=true where (username=?) and (restaurantid=?);";
    private static final String removeReservation3 = "delete from reservations where (username=?) and (restaurantid=?)";
    private static final String reject="UPDATE reservations set rejected=true where (username=?) and (restaurantid=?);";
    private static final String removeVisit = "delete from visits where (username=?) and (restaurantid=?)";
    private static final String insertMessage = "insert into chat values (?, ?, ?);";




    public RestaurantsDao() {
        DB_restaurants db_products = new DB_restaurants();
        try {
            connection = db_products.getConnection();
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //connector code
    public ResultSet getResultSet(String str) {
        ResultSet result = null;

        try {
            statement = connection.createStatement();
            String tempString = "select * from " + str + ";";
            result = statement.executeQuery(tempString);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }


    //gets user from sql database by name
    public User getUserByUsername(String thisUserName) {
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


    //gets user from sql database by id
    public User getUserById(String id) {
        User user = null;
        ResultSet result = getResultSet("users");

        try {
            while (result.next()) {

                String currId = result.getString("restaurantid");
                if (currId.equals(id)) {
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


    public String getLastId() {
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


    public Restaurant getRestaurantById(String restaurantId) {
        Restaurant res = null;
        ResultSet result = getResultSet("restaurants");
        ResultSet result1 = getResultSet("visits");

        try {
            while (result.next()) {
                String curr = result.getString("restaurantid");
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
    public List<Restaurant> getRestaurants() {
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
    public List<String> mostVisitedRestaurants(String thisUserName) {
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
                if (curr1.equals(id) && result1.getDouble("rating") != -1) {
                    n += result1.getInt("numvisits");
                    rating += result1.getDouble("rating");
                }
            }
            if (n == 0)
                rating = -1;
            else
                rating = rating/n;

            restaurant = new Restaurant(name, id, menu, numTable, rating);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return restaurant;
    }


    //if user already has reservation
    public boolean hasreservation(String username, String restaurantId) {
        ResultSet result = getResultSet("reservations");

        try {
            while (result.next()) {
                String currRestaurant = result.getString("restaurantid");
                String currUserName = result.getString("username");

                if (currUserName.equals(username) && (restaurantId.equals("null") || currRestaurant.equals(restaurantId))) {
                    return true;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }


    //dao for reservations
    public boolean reserved(String username, String restaurantId) {
        ResultSet result = getResultSet("reservations");

        try {
            while (result.next()) {
                String currRestaurant = result.getString("restaurantid");
                String currUserName = result.getString("username");

                if (currUserName.equals(username) && currRestaurant.equals(restaurantId)) {
                    if (result.getBoolean("reserved") == true)
                        return true;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }


    //to check if reservations is rejected by admin
    public boolean rejected(String username, String restaurantId) {
        ResultSet result = getResultSet("reservations");

        try {
            while (result.next()) {
                String currRestaurant = result.getString("restaurantid");
                String currUserName = result.getString("username");

                if (currUserName.equals(username) && currRestaurant.equals(restaurantId)) {
                    if (result.getBoolean("rejected") == true)
                        return true;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    //if admin changed menu, we must check in sql database
    public void getChangedMenu(String username, String restaurantId, ProductsInMenu productsInMenu) {
        ResultSet result = getResultSet("reservations");
        if(productsInMenu != null)
            productsInMenu.clearMenu();

        try {
            while (result.next()) {
                String currRestaurant = result.getString("restaurantid");
                String currUserName = result.getString("username");

                if (currUserName.equals(username) && currRestaurant.equals(restaurantId) && result.getString("friendname").equals("-1")) {
                    addInCart(result, productsInMenu);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //private method used for getChangedMenu and getReservationInvitations
    private void addInCart(ResultSet result, ProductsInMenu productsInMenu) {
        try {
            String productName = result.getString("productname");
            Double productPrice = result.getDouble("productprice");
            int numProducts = result.getInt("numproducts");
            Product newProduct = new Product(productName, productPrice);
            productsInMenu.setProductsInCart(newProduct, numProducts);

            String restaurantId = result.getString("restaurantid");
            productsInMenu.setRestaurantId(restaurantId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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

    public void addReservations(String username, String restaurantId, String friendName, ProductsInMenu productsInMenu) {
        if (getReservationInvitationsList(username, restaurantId).contains(friendName))
            return;

        for (Product product : productsInMenu.getProductsInMenu().keySet()) {
            try {
                PreparedStatement ps = connection.prepareStatement(insertReservation);
                ps.setString(1, username);
                ps.setString(2, restaurantId);
                ps.setBoolean(3, false);
                ps.setString(4, product.getProductName());
                ps.setDouble(5, product.getProductPrice());
                ps.setInt(6, productsInMenu.getProductsInMenu().get(product));
                ps.setBoolean(7, false);
                ps.setString(8, friendName);

                ps.executeUpdate();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
    }

    public void removeReservation(String username, String restaurantId) {
        try {
            PreparedStatement ps;
            if (!restaurantId.equals("null")) {
                ps = connection.prepareStatement(removeReservation);
                ps.setString(1, username);
                ps.setString(2, restaurantId);
            } else {
                ps = connection.prepareStatement(removeReservation2);
                ps.setString(1, username);
            }

            ps.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public void changeReservation(String username, String restaurantId, String changerName, ProductsInMenu productsInMenu) {
        List<String> invitations = getReservationInvitationsList(username, restaurantId);

        try {
            PreparedStatement ps;
            ps = connection.prepareStatement(removeReservation3);
            ps.setString(1, username);
            ps.setString(2, restaurantId);

            ps.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        for (int i = 0; i < invitations.size(); i++){
            String currName = invitations.get(i);
            addReservations(username, restaurantId, currName, productsInMenu);
        }
    }

    private List<String> getReservationInvitationsList(String username, String restaurantId) {
        List<String> invitations = new ArrayList<>();
        ResultSet result = getResultSet("reservations");

        try {
            while (result.next()) {
                String currUsername = result.getString("username");
                String currId = result.getString("restaurantid");
                if (currUsername.equals(username) && currId.equals(restaurantId)) {
                    String friend = result.getString("friendname");
                    if (!invitations.contains(friend)) {
                        invitations.add(friend);
                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return invitations;
    }


    public Map<String, Reservation> getReservationList(String restaurantid) {
        Map<String, Reservation> reservations = new HashMap<>();
        ResultSet result = getResultSet("reservations");

        try {
            while (result.next()) {
                if (restaurantid.equals(result.getString("restaurantid"))) {
                    if (reservations.containsKey(result.getString("username"))) {
                        reservations.get(result.getString("username")).addToMenu
                                (result.getString("productname"),
                                        Double.parseDouble(result.getString("productprice")));
                    } else {
                        String username = result.getString("username");
                        double price = Double.parseDouble(result.getString("productprice"));
                        ArrayList<String> menu = new ArrayList<>();
                        menu.add(result.getString("productname"));
                        Reservation res = new Reservation(username, menu, price,result.getBoolean("reserved"));
                        reservations.put(username, res);
                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return reservations;
    }


    public Map<String, ProductsInMenu> getUserReservations(String username) {
        Map<String, ProductsInMenu> reservations = new HashMap<>();
        ResultSet result = getResultSet("reservations");
        ProductsInMenu productsInMenu;

        try {
            while (result.next()) {
                String friendName = result.getString("friendname");
                if (username.equals(result.getString("username")) && friendName.equals("-1")) {
                    String restaurantId = result.getString("restaurantid");
                    if (!reservations.containsKey(restaurantId)){
                        productsInMenu = new ProductsInMenu();
                        reservations.put(restaurantId, productsInMenu);
                    }
                    productsInMenu = reservations.get(restaurantId);
                    String productName = result.getString("productname");
                    double productPrice = result.getDouble("productprice");
                    int numProducts = result.getInt("numproducts");
                    Product product = new Product(productName, productPrice);

                    productsInMenu.setProductsInCart(product, numProducts);
                    productsInMenu.setRestaurantId(restaurantId);
                    reservations.put(restaurantId, productsInMenu);
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return reservations;
    }


    public List<String> getFriends(String username){
        List<String> friends = new ArrayList<>();
        ResultSet result = getResultSet("friends");

        try {
            while (result.next()) {
                String currUsername = result.getString("username");
                if (currUsername.equals(username) && result.getBoolean("isfriend")) {
                    String friend = result.getString("friendname");
                    friends.add(friend);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return friends;

    }


    public void addFriend(String username, String friendName, boolean mutual) throws SQLException {
        try {
            PreparedStatement ps = connection.prepareStatement(insertFriend);
            ps.setString(1, username);
            ps.setString(2, friendName);
            ps.setBoolean(3, mutual);

            ps.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public List<String> friendRequestsReceived(String username){
        List<String > requests = new ArrayList<>();
        ResultSet result = getResultSet("friends");

        try {
            while (result.next()) {
                String name = result.getString("friendname");
                if (username.equals(name) && !result.getBoolean("isfriend")) {
                    requests.add(result.getString("username"));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return requests;

    }

    public void changeFriendStatus(String username, String friendName){
        try {
            PreparedStatement ps;
            ps = connection.prepareStatement(removeFriendFalse);
            ps.setString(1, friendName);
            ps.setString(2, username);

            ps.executeUpdate();
            addFriend(friendName, username, true);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

    }


    public void addRating(String username, String restaurantId, double rating) {
        ResultSet result = getResultSet("visits");
        int numVisits = -1;
        double oldRating = -1;

        try {
            while (result.next()) {
                String currUsername = result.getString("username");
                String currId = result.getString("restaurantid");
                if (currUsername.equals(username) && currId.equals(restaurantId)) {
                    oldRating = result.getDouble("rating");
                    numVisits = result.getInt("numvisits");
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        double newRating = 0;
        int newNumVisits = 0;

        if (oldRating == -1){
            newRating = rating;
            newNumVisits = 1;
        } else {
            newNumVisits = numVisits + 1;
            newRating = (oldRating + rating);
        }

        try {
            PreparedStatement ps;
            ps = connection.prepareStatement(removeVisit);
            ps.setString(1, username);
            ps.setString(2, restaurantId);

            ps.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }


        try {
            PreparedStatement ps;
            ps = connection.prepareStatement(insertVisit);
            ps.setString(1, username);
            ps.setString(2, restaurantId);
            ps.setInt(3, newNumVisits);
            ps.setDouble(4, newRating);

            ps.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public void removeEvaluationRequest(String username, String restaurantId) {
        try {
            PreparedStatement ps;
            ps = connection.prepareStatement(removeEvaluationRequest);
            ps.setString(1, username);
            ps.setString(2, restaurantId);
            ps.setDouble(3, -1);

            ps.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
  
    public void acceptReservation(String username, String restaurantId) {
        try {
            PreparedStatement ps;
            ps = connection.prepareStatement(accept);
            ps.setString(1, username);
            ps.setString(2, restaurantId);
            ps.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public void endDinner(String username, String restaurantId) throws SQLException {
        removeReservation(username,restaurantId);
        PreparedStatement ps;
        ps = connection.prepareStatement(insertVisit);
        ps.setString(1,username);
        ps.setString(2,restaurantId);
        ps.setInt(3,1);
        ps.setDouble(4,-1);

        ps.executeUpdate();
    }


    //takes invitation on reservation for friend from database
    public String getReservationInvitations(String username, ProductsInMenu productsInMenu) {
        String res = "null";
        productsInMenu.clearMenu();
        ResultSet result = getResultSet("reservations");

        try {
            while (result.next()) {
                String friendName = result.getString("friendname");

                if (friendName.equals(username)){
                    res = result.getString("username");
                    addInCart(result, productsInMenu);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return res;
    }


    public void getAdminInvitation(String username, ProductsInMenu productsInMenu) {
        ResultSet result = getResultSet("reservations");
        productsInMenu.clearMenu();

        try {
            while (result.next()) {
                String friendName = result.getString("friendname");
                String currName = result.getString("username");

                if (friendName.equals("-1") && username.equals(currName)){
                    addInCart(result, productsInMenu);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    public void rejectReservation(String username, String restaurantId) {
        try {
            PreparedStatement ps;
            ps = connection.prepareStatement(reject);
            ps.setString(1, username);
            ps.setString(2, restaurantId);
            ps.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public List<String> getRestaurantToEvaluate(String username) {
        List<String> evaluations = new ArrayList<>();
        ResultSet result = getResultSet("visits");

        try {
            while (result.next()) {
                String currUsername = result.getString("username");
                if (currUsername.equals(username) && result.getDouble("rating") == -1) {
                   evaluations.add(result.getString("restaurantid"));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return evaluations;
    }


    public Integer nTablesAccepted(String restaurantId) throws SQLException {
        ResultSet result=getResultSet("reservations");
        Set<String> guests=new HashSet<>();
        while(result.next()){
            if(!guests.contains(result.getString("username"))&&result.getBoolean("reserved")
            && result.getString("restaurantid").equals(restaurantId)){
                guests.add(result.getString("username"));
            }
        }
        return guests.size();
    }

    public void addMessage(String username, String to, String message) {
        try {
            PreparedStatement ps = connection.prepareStatement(insertMessage);
            ps.setString(1, username);
            ps.setString(2, to);
            ps.setString(3, message);

            ps.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public List<String> getUsers() {
        List<String> users = new ArrayList<>();
        ResultSet result = getResultSet("users");

        try {
            while (result.next()) {

                String username = result.getString("username");
                users.add(username);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }
}
