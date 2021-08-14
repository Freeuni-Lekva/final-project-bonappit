/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-08-14 21:09:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.welcomePage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import database.RestaurantsDao;
import javaClasses.ProductsInMenu;
import java.util.Map;
import javaClasses.Restaurant;
import javaClasses.Product;

public final class currentReservations_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("    * {\r\n");
      out.write("        box-sizing: border-box;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    table {\r\n");
      out.write("        width: 100%;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    tr:nth-child(even) {\r\n");
      out.write("        background-color: #f2f2f2;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .Pageheader {\r\n");
      out.write("        padding: 10px;\r\n");
      out.write("        text-align: center;\r\n");
      out.write("        background: #1abc9c;\r\n");
      out.write("        color: white;\r\n");
      out.write("        font-size: 15px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .links {\r\n");
      out.write("        width: 100%;\r\n");
      out.write("        background-color: #555;\r\n");
      out.write("        overflow: auto;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .links a {\r\n");
      out.write("        float: left;\r\n");
      out.write("        padding: 12px;\r\n");
      out.write("        color: white;\r\n");
      out.write("        text-decoration: none;\r\n");
      out.write("        font-size: 17px;\r\n");
      out.write("        width: 100%;\r\n");
      out.write("        text-align: center;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .links a:hover {\r\n");
      out.write("        background-color: #04AA6D;\r\n");
      out.write("    }\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Your Reservations</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"Pageheader\">\r\n");
      out.write("    <h1>Your Reservations</h1>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");

    RestaurantsDao restaurantDao = (RestaurantsDao) request.getServletContext().getAttribute(RestaurantsDao.daoString);
  Map<String, ProductsInMenu> reservations = restaurantDao.getUserReservations(request.getParameter("username"));
  String username = request.getParameter("username");

  if (reservations.isEmpty())
      out.println("you don't have any reservations");
  else {
      for (String id : reservations.keySet()) {
          Restaurant restaurant = restaurantDao.getRestaurantById(id);
          out.println("<table><tr><th>" + restaurant.getName() + " products</th>");
          out.println("<th> Price per </th>");
          out.println("<th> Quantity </th>");
          out.println("<th> Status </th></tr>");


          ProductsInMenu productsInMenu = reservations.get(id);
          for (Product product : productsInMenu.getProductsInMenu().keySet()) {

              out.print("<tr><td>" + product.getProductName() + "</td>");
              out.print("<td>" + "$" + product.getProductPrice() + "</td>");
              out.print("<td>" + productsInMenu.getProductsInMenu().get(product) + "</td>");
              if (restaurantDao.rejected(username, productsInMenu.getRestaurantId()))
                  out.print("<td>rejected</td></tr>");
              else if(restaurantDao.reserved(username, productsInMenu.getRestaurantId()))
                  out.print("<td>reservation approved by administrator</td></tr>");
              else
                  out.print("<td>waiting for administrators' approval</td></tr>");
          }
          out.println("</table><br>");
          out.println("<div class=\"links\">");
          out.print("<a href=\"reservationServlet?restaurantId=" + id +
                  "&username=" + username + "\">cancel reservation in " +
                  restaurant.getName() + "</a><br>");

          out.print("<a href=\"friendsPage?restaurantId=" + id +
                  "&username=" + username + "\">invite friends on reservation</a><br><br>");
          out.println("</div>");
      }
  }
  
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <br><br>\r\n");
      out.write("    <div class=\"links\">\r\n");
      out.write("        ");

    out.print("<a href=\"homePage?restaurantId=" + request.getParameter("restaurantId") +
            "&username=" + username + "\">return to home page</a>");
    
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
