/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-08-30 04:18:56 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import jp.co.mtrx.hms.service.*;
import jp.co.mtrx.hms.model.*;

public final class patientCreateConfirm_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset = Shift_JIS;charset=Shift_JIS");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write(" \r\n");
      out.write("\t\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>????????????</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<h1>????????????</h1>\r\n");
      out.write("<br />\r\n");
      out.write("\r\n");

		//String name = (String)request.getAttribute("name");
		//String bloodType = (String)request.getAttribute("bloodType");
		//String height = (String)request.getAttribute("height");
		
		String name = (String)session.getAttribute("name");
		String bloodType = (String)session.getAttribute("bloodType");
		String height = (String)session.getAttribute("height");
		System.out.println("JSP :" + getClass().getName());

      out.write("\r\n");
      out.write("<table border=\"1\" width=\"400\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td width=\"50%\">ID</td>\r\n");
      out.write("\t\t<td width=\"50%\"></td>\r\n");
      out.write("\t\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td width=\"50%\">??????</td>\r\n");
      out.write("\t\t<td width=\"50%\">");
      out.print( name );
      out.write("</td>\r\n");
      out.write("\t\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td width=\"50%\">?????????</td>\r\n");
      out.write("\t\t<td width=\"50%\">");
      out.print( bloodType );
      out.write("</td>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td width=\"50%\">??????</td>\r\n");
      out.write("\t\t<td width=\"50%\">");
      out.print( height );
      out.write("</td>\r\n");
      out.write("\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\t\t\r\n");
      out.write("<br/>\r\n");
      out.write("<form name=\"patientCreateForml\" method=\"POST\" action=\"submitPatientCreate\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"name\" value=\"");
      out.print( name );
      out.write("\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"bloodType\" value=\"");
      out.print( bloodType );
      out.write("\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"height\" value=\"");
      out.print( height );
      out.write("\">\r\n");
      out.write("\t<input type=\"submit\" name=\"submit\" value=\" ????????????\">\r\n");
      out.write("</form>\r\n");
      out.write("<br />\r\n");
      out.write("\r\n");
      out.write("<br/>\r\n");
      out.write("<form name=\"patientCreateForm2\" method=\"POST\" action=\"submitPatientCreate\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"name\" value=\"");
      out.print( name );
      out.write("\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"bloodType\" value=\"");
      out.print( bloodType );
      out.write("\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"height\" value=\"");
      out.print( height );
      out.write("\">\r\n");
      out.write("\t<input type=\"submit\" name=\"submit\" value=\"??????????????????\">\r\n");
      out.write("</form>\r\n");
      out.write("<br /><br />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<a href = \"displaypatientList\">?????????????????????</a>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\t");
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
