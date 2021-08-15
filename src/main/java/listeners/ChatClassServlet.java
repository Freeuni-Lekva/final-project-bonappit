//package listeners;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//
//public class ChatClassServlet extends HttpServlet {
//
//    public void doPost(HttpServletRequest var1, HttpServletResponse var2) throws ServletException, IOException {
//        PrintWriter var3 = var2.getWriter();
//
//        try {
//            var2.setContentType("text/html");
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            Connection var4 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "akhil");
//            Statement var5 = var4.createStatement();
//            String var6 = var1.getParameter("uname");
//            System.out.println(var6);
//            String var7 = var1.getParameter("pw");
//            System.out.println(var7);
//            String var8 = "select*from chatting where username='" + var6 + "' AND password='" + var7 + "'";
//            ResultSet var9 = var5.executeQuery(var8);
//            if (var9.next()) {
//                String var10 = var9.getString("username");
//                HttpSession var11 = var1.getSession();
//                var11.setAttribute("name", var10);
//                var3.println("Welcome, " + var10.toUpperCase());
//                var3.println("<a href='startchat.jsp'>let's Enter the Chat Room</a>");
//                var3.println("<a href='logout.jsp' class='logout-chat'>Logout</a>");
//            } else {
//                var3.println("Incorrect Username or Password.");
//            }
//
//            var4.close();
//        } catch (Exception var12) {
//            var12.printStackTrace();
//            System.out.println("Invalid User");
//        }
//
//    }
//
//    public void doGet(HttpServletRequest var1, HttpServletResponse var2) throws ServletException, IOException {
//        this.doGet(var1, var2);
//    }
//}
