//package listeners;
//import database.RestaurantsDao;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//
//public class openChat extends HttpServlet {
//
//    public void doGet(HttpServletRequest req, HttpServletResponse var2) throws ServletException, IOException {
//        String username = req.getParameter("uname");
//        System.out.println(username);
//
//        RestaurantsDao restaurantsDao = (RestaurantsDao) req.getServletContext().getAttribute(RestaurantsDao.daoString);
//        List<Message> messages = new ArrayList<>();
////        messages = restaurantsDao.getMessages(username, to);
//
//
//        try {
//            var2.setContentType("text/html");
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            Connection var3 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "akhil");
//            String var4 = "select*from chatting_data";
//            PreparedStatement var5 = var3.prepareStatement(var4);
//            ResultSet var6 = var5.executeQuery();
//
//            while(var6.next()) {
//                String var7 = var6.getString(1);
//                String var8 = var6.getString(2);
//                String var9 = var6.getString(3);
//                String var10 = var6.getString(4);
//                PrintWriter var11 = var2.getWriter();
//                var11.print("<p>" + var7 + "-<g>" + var8 + "</g><br><small>" + var9 + " " + var10 + "</small></p>");
//            }
//
//            var3.close();
//        } catch (Exception var12) {
//            var12.printStackTrace();
//            System.out.println("Something went wrong");
//        }
//
//    }
//
//    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        this.doGet(req, res);
//    }
//}
