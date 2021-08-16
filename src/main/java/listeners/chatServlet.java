package listeners;

import database.RestaurantsDao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet(name = "chatServlet", urlPatterns = {"/chatServlet"})
public class chatServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String to = request.getParameter("to");
        String message = request.getParameter("txtMsg");

        RestaurantsDao restaurantsDao = (RestaurantsDao) request.getServletContext().getAttribute(RestaurantsDao.daoString);
        restaurantsDao.addMessage(username, to, message);


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/welcomePage/chat.jsp?username="
                + username + "&to=" + to);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String to = request.getParameter("to");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/welcomePage/chat.jsp?username="
                + username + "&to=" + to);
        requestDispatcher.forward(request, response);
    }
}
