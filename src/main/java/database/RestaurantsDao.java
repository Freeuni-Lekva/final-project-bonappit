package database;

import javaClasses.User;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RestaurantsDao {
    Statement statement;

    public RestaurantsDao(){

    }

    //connector code
    private ResultSet getResultSet(String str) {
        ResultSet result = null;
        DB_restaurants db_products = new DB_restaurants();
        BasicDataSource dataSource = db_products.getDataSoruce();

        Connection connection = null;
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
        String strForResultSet = "";
        User user = null;
        if (user.isAdmin()){
            strForResultSet = "restaurants";
        } else {
            strForResultSet = "users";
        }
        ResultSet result = getResultSet(strForResultSet);

        try {
            while (result.next()) {
                String currUserName = result.getString("username");
                if (currUserName.equals(thisUserName)) {
                    String username = result.getString("username");
                    String password = result.getString("password");
                    boolean isAdmin = result.getBoolean("type");
                    int restaurantId = result.getInt("restaurantid");

                    user = new User(username, password, isAdmin, restaurantId);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }



    public void updateStatement(User user) throws SQLException {

        String command = "INSERT INTO users VALUES (" + "\"" + user.getUsername() + "\"" + "," +
                "\"" + user.getPassword() + "\"" + "," + "\"" + user.isAdmin() + "\"" + "," +
                user.getRestaurantId() + ");";

        statement.executeUpdate(command);
    }

}
