package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("    <head>\n");
      out.write("        <title>Monster Mash Logon</title>\n");
      out.write("        <link href=\"resources/template/css/bootstrap.min.css\" rel=\"stylesheet\" media=\"screen\">\n");
      out.write("            <!-- jQuery files -->\n");
      out.write("            <script type=\"text/javascript\" src=\"../css/menu/jquery/jquery.js\"></script>\n");
      out.write("            <script type=\"text/javascript\" src=\"../css/menu/jquery/jquery-ui.js\"></script>\n");
      out.write("\n");
      out.write("            <script type=\"text/javascript\"> \n");
      out.write("                $(document).ready(function(){\n");
      out.write("                    $(\".login\").click(function(){\n");
      out.write("                        $(\".registerDiv\").slideToggle(\"slow\");\n");
      out.write("                        $(\".forgotDiv\").slideUp(\"slow\");\n");
      out.write("                    });\n");
      out.write("                });\n");
      out.write("            </script> \n");
      out.write("            <script type=\"text/javascript\"> \n");
      out.write("                $(document).ready(function(){\n");
      out.write("                    $(\".forgotPassword\").click(function(){\n");
      out.write("                        $(\".forgotDiv\").slideToggle(\"slow\");\n");
      out.write("                        $(\".registerDiv\").slideUp(\"slow\");\n");
      out.write("                    });\n");
      out.write("                });\n");
      out.write("            </script> \n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"header\">\n");
      out.write("            <img src=\"resources/template/img/indexheader2.png\" width=\"930px\" class=\"img-polaroid\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"mainbody\" align=\"center\">\n");
      out.write("            <!--form action = post, name = bla bla-->\n");
      out.write("            <p> Username : <input type=\"text\" size=\"15\"> </p>\n");
      out.write("            <p> Password : <input type=\"text\" size=\"15\"> </p>\n");
      out.write("\n");
      out.write("            <a href=\"welcome.jsp\"><input type=\"submit\" name=\"login\" value=\"Log In\"></a>\n");
      out.write("            <div class=\"login\"><input type=\"submit\" name=\"register\"value=\"Register\"></div>\n");
      out.write("            <div class=\"forgotPassword\"><input type=\"submit\" name=\"forgotPassword\" value=\"Forgot Password\"></div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"registerDiv\" align=\"center\" style=\"display:none\">\n");
      out.write("            <h1> Register </h1>\n");
      out.write("            <p> Username : <input type=\"text\"> </p>\n");
      out.write("            <p> Password: <input type=\"text\"></p>\n");
      out.write("            <p> e-mail : <input type=\"text\"> </p> \n");
      out.write("            <input type=\"submit\" value=\"Register\" name=\"finishRegistration\">\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"forgotDiv\" align=\"center\" style=\"display:none\">\n");
      out.write("\n");
      out.write("            <p> Your username : <input type=\"text\"> </p>\n");
      out.write("            <p> Your e-mail : <input type=\"text\"> </p> \n");
      out.write("            <input type=\"button\" name=\"requestButton\" value=\"Request Password\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
