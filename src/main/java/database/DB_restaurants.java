package database;

import org.apache.commons.dbcp2.BasicDataSource;


public class DB_restaurants {
    private BasicDataSource dataSource;


    public DB_restaurants() {
        dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/DB_restaurants");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
    }

    public BasicDataSource getDataSoruce(){
        return dataSource;
    }

}
