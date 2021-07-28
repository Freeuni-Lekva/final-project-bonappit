package listeners;

import database.RestaurantsDao;
import javaClasses.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class CreateUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/login/userRegistration.jsp").forward(req,res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String passowrd = req.getParameter("password");
        boolean isAdmin = false;
        String restaurantId = "-1";

        User newUser = new User(username, passowrd, isAdmin, restaurantId);
        RestaurantsDao restaurantsDao = new RestaurantsDao();

        if (restaurantsDao.getUserByUsername(username) == null) {
            try {
                restaurantsDao.addUser(newUser);
                req.getRequestDispatcher("WEB-INF/welcomePage/homePage.jsp").forward(req, resp);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } else {
            req.getRequestDispatcher("WEB-INF/login/accountAlreadyExists.jsp").forward(req, resp);
        }
    }
}
