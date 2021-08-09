package listeners;

import database.RestaurantsDao;
import javaClasses.ProductsInMenu;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReservationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RestaurantsDao restaurantsDao = new RestaurantsDao();
        ProductsInMenu productsInMenu = (ProductsInMenu) req.getSession().getAttribute("products");
        String restaurantId = req.getParameter("restaurantId");
        String username = req.getParameter("username");
        String reserved = "1";

        if (!restaurantsDao.hasreservation(username, restaurantId)){
            reserved = "0";
        } else {
            productsInMenu.clearMenu();
            restaurantsDao.removeReservation(username, restaurantId);
        }
        req.setAttribute("reserved", reserved);
        req.getRequestDispatcher("WEB-INF/welcomePage/reservationRemovePage.jsp?restaurantId=" +
                restaurantId + "&username=" + username).forward(req, res);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RestaurantsDao restaurantsDao = new RestaurantsDao();
        ProductsInMenu productsInMenu = (ProductsInMenu) req.getSession().getAttribute("products");
        String restaurantId = req.getParameter("restaurantId");
        String username = req.getParameter("username");
        String reserved = "0";

        //check if user already has reservation
        if (restaurantsDao.hasreservation(username, restaurantId)){
            req.getRequestDispatcher("WEB-INF/welcomePage/checkReservation.jsp?restaurantId=" +
                    restaurantId + "&username=" + username).forward(req, resp);
        } else {
            req.setAttribute("reserved", reserved);
            req.getRequestDispatcher("WEB-INF/welcomePage/reservationPage.jsp?restaurantId=" +
                    restaurantId + "&username=" + username).forward(req, resp);
            if (!productsInMenu.getProductsInMenu().isEmpty())
                restaurantsDao.addReservations(username, restaurantId, "-1", productsInMenu);
        }
    }
}
