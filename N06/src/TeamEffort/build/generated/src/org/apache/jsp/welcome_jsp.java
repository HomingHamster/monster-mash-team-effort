package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class welcome_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("\t<title>Monster Mash- Main Page</title>\n");
      out.write("    <link href=\"resources/template/css/bootstrap.min.css\" rel=\"stylesheet\" media=\"screen\">\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\t<div class=\"container\">\n");
      out.write("\t\t<div id=\"header\">\n");
      out.write("\t\t\t<img src=\"resources/template/img/indexheader2.png\" width=\"930px\" class=\"img-polaroid\">\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"navigation\">\n");
      out.write("\t\t\t<div class=\"navbar\">\n");
      out.write("\t\t\t  <div class=\"navbar-inner\">\n");
      out.write("\t\t\t    <a class=\"brand\" href=\"#\">Monster Mash</a>\n");
      out.write("\t\t\t    <ul class=\"nav\">\n");
      out.write("\t\t\t      <li class=\"active\"><a href=\"#\">Home</a></li>\n");
      out.write("\t\t\t      <li><a href=\"#\">Login</a></li>\n");
      out.write("\t\t\t      <li><a href=\"#\">Register</a></li>\n");
      out.write("\t\t\t    </ul>\n");
      out.write("\t\t\t  </div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("\t\t<div class=\"row\">\n");
      out.write("\n");
      out.write("\t\t\t<div class=\"span2\">\n");
      out.write("\t\t\t\t<ul class=\"nav nav-list\">\n");
      out.write("\t\t\t\t\t<li><a href=\"#\"><img width=\"120px\" src=\"resources/template/img/farm.png\"></a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"#\"><img width=\"120px\" src=\"resources/template/img/shop.png\"></a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"#\"><img width=\"120px\" src=\"resources/template/img/friends.png\"></a></li>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t<div class=\"span10\">\n");
      out.write("\t\t\t\t<h1>The Monster Mash - page with no content..</h1>\n");
      out.write("\n");
      out.write("\t\t\t\t<p>Placeholder placeholder placeholder placeholder. Placeholder placeholder placeholder placeholder. Placeholder placeholder placeholder placeholder. Placeholder placeholder placeholder placeholder. Placeholder placeholder placeholder placeholder. Placeholder placeholder placeholder placeholder. Placeholder placeholder placeholder placeholder. Placeholder placeholder placeholder placeholder. Placeholder placeholder placeholder placeholder. </p>\n");
      out.write("\n");
      out.write("\t\t\t\t<p>Placeholder placeholder placeholder placeholder. Placeholder placeholder placeholder placeholder. Placeholder placeholder placeholder placeholder. Placeholder placeholder placeholder placeholder. </p>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<script src=\"http://code.jquery.com/jquery-latest.js\"></script>\n");
      out.write("\t<script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>");
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
