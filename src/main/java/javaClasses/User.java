package javaClasses;

public class User {
    private String username;
    private String password;
    private boolean admin;
    private String restaurantId;

    public User(String username, String password, boolean admin, String restaurantId) {
        this.username = username;
        this.password = password;
        this.admin = admin;
        this.restaurantId = restaurantId;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public boolean isAdmin() {
        return admin;
    }

    public String getRestaurantId() {
        return restaurantId;
    }
}
