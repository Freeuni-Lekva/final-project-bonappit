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

public class InviteOnReservationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("username");
        String restaurantId = req.getParameter("restaurantId");
        RestaurantsDao restaurantsDao = (RestaurantsDao) req.getServletContext().getAttribute(RestaurantsDao.daoString);
        String attribute = "";

        ProductsInMenu productsInMenu = (ProductsInMenu) req.getSession().getAttribute("products");
        String invitation = req.getParameter("invitation");
        if (invitation == null || !invitation.equals("-1"))
            invitation = restaurantsDao.getReservationInvitations(username, productsInMenu);
        else if (invitation.equals("-1"))
            restaurantsDao.getAdminInvitation(username, productsInMenu);

        if(invitation.equals("null")){
            attribute = "You don't have any invitations on reservation";
        } else
            restaurantId = productsInMenu.getRestaurantId();

        req.setAttribute("attribute", attribute);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/welcomePage/chosenMenuFriend.jsp?restaurantId=" +
                restaurantId + "&username=" + username + "&invitation=" + invitation);
        requestDispatcher.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String restaurantId = req.getParameter("restaurantId");
        String invitation = req.getParameter("invitation");
        RestaurantsDao restaurantsDao = (RestaurantsDao) req.getServletContext().getAttribute(RestaurantsDao.daoString);
        ProductsInMenu productsInMenu = (ProductsInMenu) req.getSession().getAttribute(ProductsInMenu.Products);

        if (invitation.equals("-1")){
            restaurantsDao.changeReservation(username, restaurantId, invitation, productsInMenu);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/welcomePage/adminHomePage.jsp?&username="
                    + restaurantsDao.getUserById(restaurantId).getUsername());
            requestDispatcher.forward(req, resp);
        }else {
            if (!restaurantsDao.reserved(invitation, restaurantId)) {
                restaurantsDao.changeReservation(invitation, restaurantId, username, productsInMenu);
            }

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/welcomePage/homePage.jsp?restaurantId=" +
                    restaurantId + "&username=" + username);
            requestDispatcher.forward(req, resp);
        }
    }
}
