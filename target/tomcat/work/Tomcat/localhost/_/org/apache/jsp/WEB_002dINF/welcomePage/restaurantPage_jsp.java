/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-08-13 15:39:00 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.welcomePage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import database.RestaurantsDao;
import javaClasses.MenuReader;
import javaClasses.Product;
import java.util.List;

public final class restaurantPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

    RestaurantsDao restaurantsDao = new RestaurantsDao();
    javaClasses.Restaurant currRestaurant = restaurantsDao.getRestaurantById(request.getParameter("restaurantId"));

    MenuReader menuReader = new MenuReader();
    List<Product> menuList = menuReader.readMenu(currRestaurant.getMenu());

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("    .Pageheader {\r\n");
      out.write("        padding: 10px;\r\n");
      out.write("        text-align: center;\r\n");
      out.write("        background: #1abc9c;\r\n");
      out.write("        color: white;\r\n");
      out.write("        font-size: 15px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    #restaurantPageInput {\r\n");
      out.write("        background-position: 10px 12px;\r\n");
      out.write("        width: 100%;\r\n");
      out.write("        font-size: 15px;\r\n");
      out.write("        padding: 11px 20px 11px 40px;\r\n");
      out.write("        border: 1px solid #ddd;\r\n");
      out.write("        margin-bottom: 11px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    #thisTable {\r\n");
      out.write("        border-collapse: collapse;\r\n");
      out.write("        width: 100%;\r\n");
      out.write("        border: 1px solid #ddd;\r\n");
      out.write("        font-size: 19px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    #thisTable th, #thisTable td {\r\n");
      out.write("        text-align: left;\r\n");
      out.write("        padding: 12px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    #thisTable tr {\r\n");
      out.write("        border-bottom: 1px solid #ddd;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    #thisTable tr.tableHeader, #thisTable tr:hover {\r\n");
      out.write("        background-color: #f1f1f1;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    /*now write links style*/\r\n");
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
      out.write("        width: 48%;\r\n");
      out.write("        text-align: center;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .links a:hover {\r\n");
      out.write("        background-color: #04AA6D;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    function search() {\r\n");
      out.write("        var inp = document.getElementById(\"restaurantPageInput\");\r\n");
      out.write("        var filter = inp.value.toUpperCase();\r\n");
      out.write("        var myTable = document.getElementById(\"thisTable\");\r\n");
      out.write("        var trVar = myTable.getElementsByTagName(\"tr\");\r\n");
      out.write("\r\n");
      out.write("        for (var i = 0; i < trVar.length; i++) {\r\n");
      out.write("            var tdVar = trVar[i].getElementsByTagName(\"td\")[0];\r\n");
      out.write("            if (tdVar) {\r\n");
      out.write("                var textValue = tdVar.textContent || tdVar.innerText;\r\n");
      out.write("                if (textValue.toUpperCase().indexOf(filter) > -1) {\r\n");
      out.write("                    trVar[i].style.display = \"\";\r\n");
      out.write("                } else {\r\n");
      out.write("                    trVar[i].style.display = \"none\";\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("    <title>");
      out.print(currRestaurant.getName());
      out.write("</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"links\">\r\n");
      out.write("        ");

            out.print("<a href=\"homePage?restaurantId=" + request.getParameter("restaurantId") +
                    "&username=" + request.getParameter("username") + "\">Home</a>");
            out.print("<a href=\"manageMenuServlet?restaurantId=" + request.getParameter("restaurantId") +
                    "&username=" + request.getParameter("username") + "\">Show Products in Menu</a>");
        
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"Pageheader\">\r\n");
      out.write("        <h1>");
      out.print(currRestaurant.getName());
      out.write("</h1>\r\n");
      out.write("        <p>Please, choose menu </p>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <input type=\"text\" id=\"restaurantPageInput\" onkeyup=\"search()\" placeholder=\"search for products...\">\r\n");
      out.write("    <table id=\"thisTable\">\r\n");
      out.write("        <tr class=\"tableHeader\">\r\n");
      out.write("            <th>Product</th>\r\n");
      out.write("            <th>Price</th>\r\n");
      out.write("            <th>choose product</th>\r\n");
      out.write("        </tr>\r\n");
      out.write("\r\n");
      out.write("       ");

           for(int i = 0; i < menuList.size(); i++){
               out.print("<tr><td>" + menuList.get(i).getProductName() + "</td>");
               out.print("<td>" +"$" + menuList.get(i).getProductPrice() + "</td>");
               out.print("<td>");
               out.print("<a href=\"menuServlet?productName=" + menuList.get(i).getProductName() +
                       "&productPrice=" + menuList.get(i).getProductPrice() +
                       "&restaurantId=" + request.getParameter("restaurantId") +
                       "&username=" + request.getParameter("username") +
                       "\">Add to Menu</a></td></tr>");
            }
        
      out.write("\r\n");
      out.write("    </table>\r\n");
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
