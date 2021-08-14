/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-08-14 16:54:38 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.welcomePage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import database.RestaurantsDao;
import javaClasses.Restaurant;
import java.util.List;
import javaClasses.MostVisitedRestaurant;
import javaClasses.ProductsInMenu;

public final class homePage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


        static int partition(ArrayList<Restaurant> array, int begin, int end) {
            int pivot = end;

            int counter = begin;
            for (int i = begin; i < end; i++) {
                if (array.get(i).getRating() > array.get(pivot).getRating()) {
                    Restaurant temp = array.get(counter);
                    array.set(counter, array.get(i));
                    array.set(i, temp);
                    counter++;
                }
            }
            Restaurant temp = array.get(pivot);
            array.set(pivot, array.get(counter));
            array.set(counter, temp);

            return counter;
        }

        public void quickSort(ArrayList<Restaurant> array, int begin, int end) {
            if (end <= begin) return;
            int pivot = partition(array, begin, end);
            quickSort(array, begin, pivot-1);
            quickSort(array, pivot+1, end);
        }
    
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
      out.write("    form {\r\n");
      out.write("        border: 1ch solid #f1f1f1;\r\n");
      out.write("        width: 100%;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    body {\r\n");
      out.write("        background-color: gray;\r\n");
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
      out.write("    #homePageInput {\r\n");
      out.write("        background-position: 10px 11px;\r\n");
      out.write("        width: 100%;\r\n");
      out.write("        font-size: 16px;\r\n");
      out.write("        padding: 12px 20px 12px 40px;\r\n");
      out.write("        border: 1px solid #ddd;\r\n");
      out.write("        margin-bottom: 11px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    #thisUl {\r\n");
      out.write("        list-style-type: none;\r\n");
      out.write("        padding: 0;\r\n");
      out.write("        margin: 0;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    #thisUl li a {\r\n");
      out.write("        border: 1px solid #ddd;\r\n");
      out.write("        margin-top: -1px;\r\n");
      out.write("        background-color: #f6f6f6;\r\n");
      out.write("        padding: 12px;\r\n");
      out.write("        text-decoration: none;\r\n");
      out.write("        font-size: 18px;\r\n");
      out.write("        color: black;\r\n");
      out.write("        display: block;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    #thisUl li a:hover:not(.header) {\r\n");
      out.write("        background-color: #eee;\r\n");
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
      out.write("        width: 18%;\r\n");
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
      out.write("        var inp = document.getElementById('homePageInput');\r\n");
      out.write("        var filterRestaurant = inp.value.toUpperCase();\r\n");
      out.write("        var UL = document.getElementById(\"thisUl\");\r\n");
      out.write("        var LItype = UL.getElementsByTagName('li');\r\n");
      out.write("\r\n");
      out.write("        for (var i = 0; i < LItype.length; i++) {\r\n");
      out.write("            var aVar = LItype[i].getElementsByTagName(\"a\")[0];\r\n");
      out.write("            var txtValue = aVar.textContent || aVar.innerText;\r\n");
      out.write("            if (txtValue.toUpperCase().indexOf(filterRestaurant) > -1) {\r\n");
      out.write("                LItype[i].style.display = \"\";\r\n");
      out.write("            } else {\r\n");
      out.write("                LItype[i].style.display = \"none\";\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Welcome ");
      out.print( request.getParameter("username"));
      out.write("</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div class=\"links\">\r\n");
      out.write("    ");

        out.println("<a href=\"chatPge\">Chat</a>");
        out.print("<a href=\"currentReservations?restaurantId=" + request.getParameter("restaurantId") +
                "&username=" + request.getParameter("username") + "\">My Reservations </a>");
        out.print("<a href=\"addFriendServlet?restaurantId=" + request.getParameter("restaurantId") +
                "&username=" + request.getParameter("username") + "\">Add Friends </a>");

        out.print("<a href=\"evaluateVisitServlet?restaurantId=" + request.getParameter("restaurantId") +
                "&username=" + request.getParameter("username") + "\">Visits Evaluation</a>");
        out.print("<a href=\"inviteOnReservationServlet?restaurantId=" + request.getParameter("restaurantId") +
                "&username=" + request.getParameter("username") + "\">Invites on Reservation</a>");
    
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"Pageheader\">\r\n");
      out.write("    <h1>Welcome ");
      out.print( request.getParameter("username"));
      out.write("</h1>\r\n");
      out.write("    <p>Please, choose restaurant ");
      out.print( request.getParameter("username"));
      out.write(" </p\r\n");
      out.write("    <p>Restaurants are sorted by rating </p><br>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<u1>\r\n");
      out.write("\r\n");
      out.write("    ");

        RestaurantsDao restaurantDao = (RestaurantsDao) request.getServletContext().getAttribute(RestaurantsDao.daoString);
        ArrayList<Restaurant> restaurants = (ArrayList<Restaurant>) restaurantDao.getRestaurants();
        ProductsInMenu productsInMenu = (ProductsInMenu) request.getSession().getAttribute("products");
        productsInMenu.clearMenu();
    
      out.write("\r\n");
      out.write("\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <input type=\"text\" id=\"homePageInput\" onkeyup=\"search()\" placeholder=\"search for restaurants...\">\r\n");
      out.write("    <ul id=\"thisUl\">\r\n");
      out.write("      ");

          quickSort(restaurants, 0, restaurants.size() - 1);
          for(javaClasses.Restaurant restaurant : restaurants) {
            out.print("<li><a href=\"restaurantPage?restaurantId=" + restaurant.getId() +
                    "&username=" + request.getParameter("username") + "\">"
                    + restaurant.getName() + " - Rating " + restaurant.getRating() + "</a></li>");
        }
    
      out.write("\r\n");
      out.write("    </ul>\r\n");
      out.write("\r\n");
      out.write("</u1><br>\r\n");
      out.write("\r\n");
      out.write("<br>\r\n");
      out.write("<h2>Most visited Restaurants</h2>\r\n");
      out.write("\r\n");


    MostVisitedRestaurant mostVisitedRestaurant = new MostVisitedRestaurant(request.getParameter("username"), restaurantDao);
    List<String> mostViwed = mostVisitedRestaurant.getMostVisitedRestaurants();

    for(String id : mostViwed) {
        Restaurant restaurant = restaurantDao.getRestaurantById(id);
        out.print("<li><a href=\"restaurantPage?restaurantId=" + restaurant.getId() +
                "&username=" + request.getParameter("username") + "\">"
                + restaurant.getName() + "</a></li>");
    }

      out.write("\r\n");
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
