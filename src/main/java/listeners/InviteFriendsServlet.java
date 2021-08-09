package listeners;

import database.RestaurantsDao;
import javaClasses.ProductsInMenu;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InviteFriendsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String restaurantId = req.getParameter("restaurantId");
        String friendName = req.getParameter("friendName");

        RestaurantsDao restaurantsDao = new RestaurantsDao();
        ProductsInMenu productsInMenu = (ProductsInMenu) req.getSession().getAttribute("products");
        restaurantsDao.addReservations(username, restaurantId, friendName, productsInMenu);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("currentReservations?restaurantId=" +
                restaurantId + "&username=" + username);
        requestDispatcher.forward(req, resp);
    }
}
