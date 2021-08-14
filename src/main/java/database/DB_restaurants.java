package database;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class DB_restaurants {
    private BasicDataSource dataSource;
    private Connection connection;


    public DB_restaurants() {
        dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/DB_restaurants");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Connection getConnection(){
        return connection;
    }

}
