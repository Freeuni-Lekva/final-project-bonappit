package listeners;

import database.RestaurantsDao;
import javaClasses.Product;
import javaClasses.ProductsInMenu;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminReservedMenu extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("username");
        String restaurantId = req.getParameter("restaurantId");

        RestaurantsDao restaurantsDao = (RestaurantsDao) req.getServletContext().getAttribute(RestaurantsDao.daoString);
        ProductsInMenu productsInMenu = (ProductsInMenu) req.getSession().getAttribute("products");
        restaurantsDao.getChangedMenu(username, restaurantId, productsInMenu);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/welcomePage/chosenMenu.jsp?restaurantId=" +
                restaurantId + "&username=" + username);
        requestDispatcher.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
