package listeners;

import database.RestaurantsDao;
import javaClasses.MostVisitedRestaurant;
import javaClasses.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class LoginServlet extends HttpServlet {

    //to return to login.jsp page from restaurant registration
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/login/login.jsp").forward(req,res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        RestaurantsDao restaurantsDao = (RestaurantsDao) req.getServletContext().getAttribute(RestaurantsDao.daoString);
        User currUser = restaurantsDao.getUserByUsername(username);

        if (currUser == null){
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/login/illegalAccount.jsp");
            requestDispatcher.forward(req, resp);
            return;
        }
        if (currUser.getPassword().equals(password)) {
            RequestDispatcher requestDispatcher;
            if(currUser.isAdmin()) {
                requestDispatcher = req.getRequestDispatcher("WEB-INF/welcomePage/adminHomePage.jsp?username=" + username);
            } else {
                requestDispatcher = req.getRequestDispatcher("WEB-INF/welcomePage/homePage.jsp?username=" + username);
            }
            requestDispatcher.forward(req, resp);
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/login/illegalAccount.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
