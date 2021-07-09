package database;

import javaClasses.Restaurant;
import javaClasses.User;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;

public class RestaurantsDao {
private Connection connection;
private static final String insertSt = "insert into restaurants values (?, ?, ?,?);";
    public RestaurantsDao(Connection connection){
        this.connection = connection;
        try {
            PreparedStatement st = connection.prepareStatement("USE DB_restaurants");
            st.execute();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    //connector code
    private ResultSet getResultSet(String str) {
        ResultSet result = null;
        DB_restaurants db_products = new DB_restaurants();
        BasicDataSource dataSource = db_products.getDataSoruce();

        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            String tempString = "select * from " + str + ";";
            result = statement.executeQuery(tempString);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    public void addRestaurant(Restaurant res) {
        try {
            PreparedStatement ps = connection.prepareStatement(insertSt);
            ps.setString(1, res.getId());
            ps.setString(2, res.getName());
            ps.setString(3, res.getMenu());

            ps.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
//    public void updateStatement(User user) throws SQLException {
//
//        String command = "INSERT INTO metropolises VALUES (" + "\"" + metropolis.getMetropolis() + "\"" + "," +
//                "\"" + metropolis.getContinent() + "\"" + "," +
//                metropolis.getPopulation() + ");";
//
//        statement.executeUpdate(command);
//    }

}
