/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-08-14 13:57:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.welcomePage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javaClasses.ProductsInMenu;
import javaClasses.Product;
import java.util.List;
import database.RestaurantsDao;
import javaClasses.MenuReader;

public final class chosenMenuFriend_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("    .btn-group button {\r\n");
      out.write("        background-color: #04AA6D;\r\n");
      out.write("        border: 1px solid green;\r\n");
      out.write("        color: white;\r\n");
      out.write("        padding: 10px 24px;\r\n");
      out.write("        cursor: pointer;\r\n");
      out.write("        float: left;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .btn-group button:not(:last-child) {\r\n");
      out.write("        border-right: none;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .btn-group:after {\r\n");
      out.write("        content: \"\";\r\n");
      out.write("        clear: both;\r\n");
      out.write("        display: table;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .btn-group button:hover {\r\n");
      out.write("        background-color: #3e8e41;\r\n");
      out.write("    }\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Products in Menu</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<h1>Current Menu</h1>\r\n");
      out.write("\r\n");
      out.write("<form action=\"menuServlet\" method=\"post\">\r\n");
      out.write("    <ul>\r\n");
      out.write("\r\n");
      out.write("        ");

            ProductsInMenu productsInMenu = new ProductsInMenu();
            productsInMenu = (ProductsInMenu) session.getAttribute(productsInMenu.Products);
            productsInMenu.removeZeroQuantities();

            for(Product currProduct : productsInMenu.getProductsInMenu().keySet()){
                out.println("<li> <input type ='number' value='" + productsInMenu.getProductsInMenu().get(currProduct)
                        + "' name='" + currProduct.getProductName() + "'>" +
                        "<input type ='hidden' value='" + request.getParameter("username")
                        + "' name='" + "username" + "'>"
                        + currProduct.getProductName() + ", " + currProduct.getProductPrice() + "</li>");
            }
        
      out.write("\r\n");
      out.write("    </ul>\r\n");
      out.write("\r\n");
      out.write("    <input type=\"hidden\" name=\"restaurantId\" value=\"");
      out.print(request.getParameter("restaurantId"));
      out.write("\">\r\n");
      out.write("    <input type=\"hidden\" name=\"username\" value=\"");
      out.print(request.getParameter("username"));
      out.write("\">\r\n");
      out.write("    <input type=\"hidden\" name=\"invitation\" value=\"");
      out.print(request.getParameter("invitation"));
      out.write("\">\r\n");
      out.write("    Total: $");
      out.print(productsInMenu.getTotalPrice());
      out.write("\r\n");
      out.write("    <div class=\"btn-group\"><button type=\"submit\">Update Menu</button></div>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<form action=\"manageMenuServlet\" method=\"post\">\r\n");
      out.write("    <input type=\"hidden\" name=\"restaurantId\" value=\"");
      out.print(request.getParameter("restaurantId"));
      out.write("\">\r\n");
      out.write("    <input type=\"hidden\" name=\"username\" value=\"");
      out.print(request.getParameter("username"));
      out.write("\">\r\n");
      out.write("    <input type=\"hidden\" name=\"invitation\" value=\"");
      out.print(request.getParameter("invitation"));
      out.write("\">\r\n");
      out.write("    <div class=\"btn-group\"><button type=\"submit\">Clear Menu</button></div>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<form action=\"inviteOnReservationServlet\" method=\"post\">\r\n");
      out.write("    <input type=\"hidden\" name=\"restaurantId\" value=\"");
      out.print(request.getParameter("restaurantId"));
      out.write("\">\r\n");
      out.write("    <input type=\"hidden\" name=\"username\" value=\"");
      out.print(request.getParameter("username"));
      out.write("\">\r\n");
      out.write("    <input type=\"hidden\" name=\"invitation\" value=\"");
      out.print(request.getParameter("invitation"));
      out.write("\">\r\n");
      out.write("    <div class=\"btn-group\"><button type=\"submit\">Change Reservation</button></div>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");

    out.print("<a href=\"restaurantPage?restaurantId=" + request.getParameter("restaurantId") +
            "&username=" + request.getParameter("username") + "&invitation=" + request.getParameter("invitation") +
            "\">add more products</a>");


      out.write("\r\n");
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
