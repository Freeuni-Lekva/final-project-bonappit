package listeners;

import javaClasses.ProductsInMenu;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;


@WebListener
public class ListenerClass implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        ProductsInMenu productsInMenu = new ProductsInMenu();
        HttpSession session = httpSessionEvent.getSession();
        session.setAttribute(productsInMenu.Products, productsInMenu);
    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        ProductsInMenu productsInMenu = new ProductsInMenu();
        session.removeAttribute(productsInMenu.Products);
    }
}
