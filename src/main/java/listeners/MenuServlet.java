package listeners;

import javaClasses.Product;
import javaClasses.ProductsInMenu;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MenuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ProductsInMenu productsInMenu = (ProductsInMenu) req.getSession().getAttribute("products");

        String productName = req.getParameter("productName");
        String productPrice = req.getParameter("productPrice");
        String restaurantId = req.getParameter("restaurantId");

        if (productsInMenu.getRestaurantId() != null && !req.getParameter("invitation").equals("null"))
            if (!productsInMenu.getRestaurantId().equals(restaurantId))
                productsInMenu.clearMenu();

        productsInMenu.addProduct(new Product(productName, Double.parseDouble(productPrice)), restaurantId);

        if (req.getParameter("invitation") == null || req.getParameter("invitation").equals("null"))
            req.getRequestDispatcher("WEB-INF/welcomePage/chosenMenu.jsp?restaurantId=" + restaurantId
            + "&username=" + req.getParameter("username")).forward(req,res);
        else
            req.getRequestDispatcher("WEB-INF/welcomePage/chosenMenuFriend.jsp?restaurantId=" + restaurantId
                    + "&username=" + req.getParameter("username")
                    + "&invitation=" + req.getParameter("invitation")).forward(req,res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductsInMenu productsInMenu = (ProductsInMenu) req.getSession().getAttribute("products");

        //if just product count in menu is updated and no new product is added
        for (Product currProduct : productsInMenu.getProductsInMenu().keySet()){
            int newQuantity = Integer.parseInt(req.getParameter(currProduct.getProductName()));
            if (newQuantity < 0)
                newQuantity = 0;
            productsInMenu.setProductsInCart(currProduct, newQuantity);
        }

        if (req.getParameter("invitation") == null || req.getParameter("invitation").equals("null")) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/welcomePage/chosenMenu.jsp?restaurantId=" +
                    req.getParameter("restaurantId") + "&username=" + req.getParameter("username"));
            requestDispatcher.forward(req, resp);
        } else {
            req.getRequestDispatcher("WEB-INF/welcomePage/chosenMenuFriend.jsp?restaurantId=" +
                    req.getParameter("restaurantId") + "&username=" + req.getParameter("username")
                    + "&invitation=" + req.getParameter("invitation")).forward(req, resp);
        }
    }
}
