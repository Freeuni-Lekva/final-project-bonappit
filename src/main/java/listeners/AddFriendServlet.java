package listeners;

import database.RestaurantsDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

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
        String username = req.getParameter("username");
        String restaurantId = req.getParameter("restaurantId");
        String friendName = req.getParameter("friendName");
        RestaurantsDao restaurantsDao = new RestaurantsDao();
        String attribute = "";


        if (restaurantsDao.getUserByUsername(friendName) == null)
            attribute = "Invalid Username, pls try another name";
        else if (!restaurantsDao.getFriends(username).contains(friendName)){

            if (!restaurantsDao.friendRequestsReceived(username).contains(friendName) &&
            !restaurantsDao.friendRequestsReceived(friendName).contains(username)) {
                try {
                    restaurantsDao.addFriend(username, friendName, false);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                attribute = "Friend request is sent to " + friendName;

                //if user has already sent request to friend
            } else if (restaurantsDao.friendRequestsReceived(friendName).contains(username)){
                attribute = "friend request is already sent to " + friendName;

                //if we have already received friend request from him, so we must add him in friends
            } else {
                try {
                    restaurantsDao.addFriend(username, friendName, true);
                    restaurantsDao.changeFriendStatus(username, friendName);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                attribute = "Friend is added " + friendName;
            }
        } else {
            attribute = friendName + " is already added to your friends ";
        }

        req.setAttribute("attribute", attribute);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/welcomePage/friendStatus.jsp?restaurantId=" +
                restaurantId + "&username=" + username);
        requestDispatcher.forward(req, resp);
    }
}
