package database;

import javaClasses.User;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RestaurantsDao {

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
            Statement statement = connection.createStatement();
            String tempString = "select * from " + str + ";";
            result = statement.executeQuery(tempString);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
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
