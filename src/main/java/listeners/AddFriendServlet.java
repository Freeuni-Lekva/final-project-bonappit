package listeners;

import database.RestaurantsDao;
import javaClasses.ProductsInMenu;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddFriendServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("username");
        String restaurantId = req.getParameter("restaurantId");

        req.getRequestDispatcher("WEB-INF/welcomePage/addFriendPage.jsp?restaurantId=" + restaurantId
                + "&username=" + username).forward(req,res);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //shevamowmeb tu arsebobs aseti user da davamateb mere
    }
}
