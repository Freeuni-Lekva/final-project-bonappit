//package listeners;
//
//import database.RestaurantsDao;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//public class chatServlet extends HttpServlet {
//
//    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
////        PrintWriter pw = res.getWriter();
////        String username = req.getParameter("username");
////        String to = req.getParameter("to");
////        String message = req.getParameter("msg");
////        System.out.println(username);
////        System.out.println(to);
////        System.out.println(message);
////
////        SimpleDateFormat temp1 = new SimpleDateFormat("dd-MMM-yyyy");
////        SimpleDateFormat temp2 = new SimpleDateFormat("hh:mm:ss a");
////
////        RestaurantsDao restaurantsDao = (RestaurantsDao) req.getServletContext().getAttribute(RestaurantsDao.daoString);
////
////        Date date = new Date();
////        String date1 = temp1.format(date);
////        String date2 = temp2.format(date);
//
//        PrintWriter var3 = res.getWriter();
//
//        try {
//            res.setContentType("text/html");
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            Connection var4 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "akhil");
//            Statement var5 = var4.createStatement();
//            String var6 = req.getParameter("uname");
//            String var7 = req.getParameter("msg");
//            System.out.println(var6);
//            System.out.println(var7);
//
//            SimpleDateFormat var8 = new SimpleDateFormat("dd-MMM-yyyy");
//            SimpleDateFormat var9 = new SimpleDateFormat("hh:mm:ss a");
//            Date var10 = new Date();
//            String var11 = var8.format(var10);
//            String var12 = var9.format(var10);
//            String var13 = "insert into chatting_data values('" + var6 + "','" + var7 + "','" + var11 + "','" + var12 + "',seq_chatting_data.nextval)";
//            ResultSet var14 = var5.executeQuery(var13);
//            var14.next();
//            var4.close();
//        } catch (Exception var15) {
//            var15.printStackTrace();
//            System.out.println("Invalid User");
//        }
//
//    }
//
//    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        this.doGet(req, res);
//    }
//}
