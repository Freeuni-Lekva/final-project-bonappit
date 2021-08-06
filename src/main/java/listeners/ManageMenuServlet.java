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
        req.getRequestDispatcher("WEB-INF/welcomePage/chosenMenu.jsp?restaurantId=" + req.getParameter("restaurantId")).forward(req,res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductsInMenu productsInMenu = (ProductsInMenu) req.getSession().getAttribute("products");
        productsInMenu.clearMenu();

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/welcomePage/chosenMenu.jsp?restaurantId=" + req.getParameter("restaurantId"));
        requestDispatcher.forward(req, resp);
    }
}
