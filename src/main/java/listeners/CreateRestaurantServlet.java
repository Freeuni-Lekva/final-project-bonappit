package listeners;

import database.RestaurantsDao;
import javaClasses.Restaurant;
import javaClasses.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class CreateRestaurantServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/login/adminRegistration.jsp").forward(req,res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String restaurantName = req.getParameter("restaurantName");
        String username = req.getParameter("username");
        String passowrd = req.getParameter("password");
        boolean isAdmin = true;

        RestaurantsDao restaurantsDao = new RestaurantsDao();
        int restaurantId = Integer.parseInt(restaurantsDao.getLastId()) + 1;
        String menuFile = req.getParameter("menu");
        String numTables = req.getParameter("numberTable");

        User newUser = new User(username, passowrd, isAdmin, String.valueOf(restaurantId));
        Restaurant newRestaurant = new Restaurant(restaurantName, String.valueOf(restaurantId),
                menuFile, Integer.parseInt(numTables), 0);

        if (restaurantsDao.getUserByUsername(username) == null){
            try {
                restaurantsDao.addRestaurant(newRestaurant);
                restaurantsDao.addUser(newUser);
                req.getRequestDispatcher("WEB-INF/welcomePage/adminHomePage.jsp").forward(req, resp);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } else {
            req.getRequestDispatcher("WEB-INF/login/adminAlreadyExists.jsp").forward(req, resp);
        }
    }
}
