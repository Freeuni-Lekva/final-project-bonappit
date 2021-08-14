package listeners;

import database.RestaurantsDao;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EvaluateVisitServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("username");
        String restaurantId = req.getParameter("restaurantId");
        RestaurantsDao restaurantsDao = (RestaurantsDao) req.getServletContext().getAttribute(RestaurantsDao.daoString);
        String attribute = "";

        if(restaurantsDao.getEvaluationRequest(username, restaurantId) != -1){
            attribute = "You don't have visits to rate";
        }
        req.setAttribute("attribute", attribute);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/welcomePage/rateVisit.jsp?restaurantId=" +
                restaurantId + "&username=" + username);
        requestDispatcher.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String restaurantId = req.getParameter("restaurantId");
        double rating = Double.parseDouble(req.getParameter("rating"));
        RestaurantsDao restaurantsDao = new RestaurantsDao();

        restaurantsDao.removeEvaluationRequest(username, restaurantId);
        restaurantsDao.addRating(username, restaurantId, rating);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/welcomePage/rateReceived.jsp?restaurantId=" +
                restaurantId + "&username=" + username);
        requestDispatcher.forward(req, resp);
    }
}
