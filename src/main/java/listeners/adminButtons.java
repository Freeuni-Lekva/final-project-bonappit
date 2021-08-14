package listeners;

import database.RestaurantsDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/adminButtons")
public class adminButtons extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String button = request.getParameter("button");
        String username=request.getParameter("username");
        String restaurantId=request.getParameter("restaurantId");
        String status=request.getParameter("status");
        RestaurantsDao restaurantsDao = (RestaurantsDao) request.getServletContext().getAttribute(RestaurantsDao.daoString);

        if ("accept".equals(button)&&"AWAITING".equals(status)) {
           restaurantsDao.acceptReservation(username,restaurantId);
        } else if("accept".equals(button)&&"ACCEPTED".equals(status)){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/welcomePage/messageAlertsForAdmin.jsp?username=" +
                    request.getParameter("admin")+"&status=0");
            requestDispatcher.forward(request, response);
        } else if ("reject".equals(button)&&"AWAITING".equals(status)) {
            restaurantsDao.rejectReservation(username,restaurantId);
        } else if ("reject".equals(button)&&"ACCEPTED".equals(status)) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/welcomePage/messageAlertsForAdmin.jsp?username=" +
                    request.getParameter("admin")+"&status=1");
            requestDispatcher.forward(request, response);
        } else if ("end".equals(button)&&"ACCEPTED".equals(status)) {
            try {
                restaurantsDao.endDinner(username,restaurantId);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } else if ("end".equals(button)&&"AWAITING".equals(status)) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/welcomePage/messageAlertsForAdmin.jsp?username=" +
                    request.getParameter("admin")+"&status=2");
            requestDispatcher.forward(request, response);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/welcomePage/adminHomePage.jsp?username=" +
                request.getParameter("admin"));
        requestDispatcher.forward(request, response);
    }

}
