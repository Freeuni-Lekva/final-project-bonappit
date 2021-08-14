package listeners;

import javaClasses.ProductsInMenu;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ManageMenuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if (req.getParameter("invitation") == null || req.getParameter("invitation").equals("null"))
        req.getRequestDispatcher("WEB-INF/welcomePage/chosenMenu.jsp?restaurantId=" + req.getParameter("restaurantId")
                + "&username=" + req.getParameter("username")).forward(req,res);
        else
            req.getRequestDispatcher("WEB-INF/welcomePage/chosenMenuFriend.jsp?restaurantId=" +
                    req.getParameter("restaurantId") + "&username=" + req.getParameter("username")
                    + "&invitation=" + req.getParameter("invitation")).forward(req,res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductsInMenu productsInMenu = (ProductsInMenu) req.getSession().getAttribute("products");
        productsInMenu.clearMenu();

        if (req.getParameter("invitation") == null || req.getParameter("invitation").equals("null")) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/welcomePage/chosenMenu.jsp?restaurantId=" +
                    req.getParameter("restaurantId") + "&username=" + req.getParameter("username"));
            requestDispatcher.forward(req, resp);
        } else {
            req.getRequestDispatcher("WEB-INF/welcomePage/chosenMenuFriend.jsp?restaurantId=" +
                    req.getParameter("restaurantId") + "&username=" + req.getParameter("username")
                    + "&invitation=" + req.getParameter("invitation")).forward(req,resp);
        }
    }
}
