/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-08-14 16:41:40 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class adminRegistration_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("    form {\r\n");
      out.write("        border: 1ch solid #f1f1f1;\r\n");
      out.write("        width: 50%;\r\n");
      out.write("    }\r\n");
      out.write("    input[type=text], input[type=password] {\r\n");
      out.write("        width: 40%;\r\n");
      out.write("        padding: 15px;\r\n");
      out.write("        margin: 5px 0 22px 0;\r\n");
      out.write("        display: inline-block;\r\n");
      out.write("        border: none;\r\n");
      out.write("        background: #f1f1f1;\r\n");
      out.write("    }\r\n");
      out.write("    input[type=text]:focus, input[type=password]:focus {\r\n");
      out.write("        background-color: #ddd;\r\n");
      out.write("        outline: none;\r\n");
      out.write("    }\r\n");
      out.write("    hr {\r\n");
      out.write("        border: 1px solid #f1f1f1;\r\n");
      out.write("        margin-bottom: 25px;\r\n");
      out.write("    }\r\n");
      out.write("    button {\r\n");
      out.write("        background-color: #04AA6D;\r\n");
      out.write("        color: white;\r\n");
      out.write("        padding: 14px 20px;\r\n");
      out.write("        margin: 8px 0;\r\n");
      out.write("        border: none;\r\n");
      out.write("        cursor: pointer;\r\n");
      out.write("        width: 40%;\r\n");
      out.write("        opacity: 0.9;\r\n");
      out.write("    }\r\n");
      out.write("    button:hover {\r\n");
      out.write("        opacity:1;\r\n");
      out.write("    }\r\n");
      out.write("    .container {\r\n");
      out.write("        padding: 16px;\r\n");
      out.write("    }\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Admin Registration</title>\r\n");
      out.write("</head>\r\n");
      out.write("<div align=\"center\">\r\n");
      out.write("    <h1>Admin Registration</h1>\r\n");
      out.write("    <p>Please enter requested data</p><br>\r\n");
      out.write("    <form action=\"createAdmin\" method=\"post\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <label for=\"restaurantName\">Restaurant Name:</label><br>\r\n");
      out.write("            <input type=\"text\" id=\"restaurantName\" name=\"restaurantName\"><br>\r\n");
      out.write("            <label for=\"username\">User Name:</label><br>\r\n");
      out.write("            <input type=\"text\" id=\"username\" name=\"username\"><br>\r\n");
      out.write("            <label for=\"password\">Password:</label><br>\r\n");
      out.write("            <input type=\"text\" id=\"password\" name=\"password\"><br>\r\n");
      out.write("            <label for=\"numberTable\">Number Table:</label><br>\r\n");
      out.write("            <input type=\"text\" id=\"numberTable\" name=\"numberTable\"><br>\r\n");
      out.write("            <label for=\"menu\">Menu:</label><br>\r\n");
      out.write("            <input type=\"text\" id=\"menu\" name=\"menu\"><br>\r\n");
      out.write("            <input type=\"submit\" value=\"Register\">\r\n");
      out.write("        </div>\r\n");
      out.write("    </form>\r\n");
      out.write("\r\n");
      out.write("    <a href=\"loginServlet\" style=\"color:dodgerblue\">return to login </a>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
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
