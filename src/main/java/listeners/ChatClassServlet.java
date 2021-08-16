package listeners;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "chatClassServlet", urlPatterns = {"/chatClassServlet"})
public class ChatClassServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String to = request.getParameter("to");


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/welcomePage/chat.jsp?username="
                + username + "&to=" + to);
        requestDispatcher.forward(request, response);
    }
}
