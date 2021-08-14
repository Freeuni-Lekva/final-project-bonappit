package listeners;

import database.RestaurantsDao;
import javaClasses.ProductsInMenu;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class ListenerClass implements ServletContextListener, HttpSessionListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        RestaurantsDao restaurantsDao = new RestaurantsDao();
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute(RestaurantsDao.daoString, restaurantsDao);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        ProductsInMenu productsInMenu = new ProductsInMenu();
        HttpSession session = httpSessionEvent.getSession();
        session.setAttribute(productsInMenu.Products, productsInMenu);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        session.removeAttribute("products");
    }
}
