package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>Monster Mash Login</title>\r\n");
      out.write("        <link href=\"resources/template/css/bootstrap.min.css\" rel=\"stylesheet\" media=\"screen\">\r\n");
      out.write("            <!-- jQuery files -->\r\n");
      out.write("            <script type=\"text/javascript\" src=\"../css/menu/jquery/jquery.js\"></script>\r\n");
      out.write("            <script type=\"text/javascript\" src=\"../css/menu/jquery/jquery-ui.js\"></script>\r\n");
      out.write("\r\n");
      out.write("            <script type=\"text/javascript\"> \r\n");
      out.write("                $(document).ready(function(){\r\n");
      out.write("                    $(\".login\").click(function(){\r\n");
      out.write("                        $(\".registerDiv\").slideToggle(\"slow\");\r\n");
      out.write("                        $(\".forgotDiv\").slideUp(\"slow\");\r\n");
      out.write("                    });\r\n");
      out.write("                });\r\n");
      out.write("            </script> \r\n");
      out.write("            <script type=\"text/javascript\"> \r\n");
      out.write("                $(document).ready(function(){\r\n");
      out.write("                    $(\".forgotPassword\").click(function(){\r\n");
      out.write("                        $(\".forgotDiv\").slideToggle(\"slow\");\r\n");
      out.write("                        $(\".registerDiv\").slideUp(\"slow\");\r\n");
      out.write("                    });\r\n");
      out.write("                });\r\n");
      out.write("            </script> \r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div id=\"header\">\r\n");
      out.write("            <img src=\"resources/template/img/indexheader2.png\" width=\"930px\" class=\"img-polaroid\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"mainbody\" align=\"center\">\r\n");
      out.write("            <FORM METHOD=POST ACTION=\"SaveName.jsp.jsp\">\r\n");
      out.write("                UserName: <INPUT TYPE=TEXT NAME=username SIZE=20 required=\"true\"><BR>\r\n");
      out.write("                Password? <INPUT TYPE=TEXT NAME=password SIZE=20 required =\"true\"><BR>\r\n");
      out.write("                                    <P><INPUT TYPE=SUBMIT>\r\n");
      out.write("                                            <div class=\"login\"><input type=\"submit\" name=\"register\"value=\"Register\"></div>\r\n");
      out.write("                                            <div class=\"forgotPassword\"><input type=\"submit\" name=\"forgotPassword\" value=\"Forgot Password\"></div>\r\n");
      out.write("\r\n");
      out.write("                                            </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                            <div class=\"registerDiv\" align=\"center\" style=\"display:none\">\r\n");
      out.write("                                                <h1> Register </h1>\r\n");
      out.write("                                                <p> Username : <input type=\"text\"> </p>\r\n");
      out.write("                                                <p> Password: <input type=\"text\"></p>\r\n");
      out.write("                                                <p> e-mail : <input type=\"text\"> </p> \r\n");
      out.write("                                                <input type=\"submit\" value=\"Register\" name=\"finishRegistration\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("\r\n");
      out.write("                                            <div class=\"forgotDiv\" align=\"center\" style=\"display:none\">\r\n");
      out.write("\r\n");
      out.write("                                                <p> Your username : <input type=\"text\"> </p>\r\n");
      out.write("                                                <p> Your e-mail : <input type=\"text\"> </p> \r\n");
      out.write("                                                <input type=\"button\" name=\"requestButton\" value=\"Request Password\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            </body>\r\n");
      out.write("                                            </html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
