/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.23
 * Generated at: 2017-06-21 06:51:12 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.content;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class json_005fdemo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Simpleton Demo | struts+ajax返回json类型数据</title>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"images/Icon.png\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"styles/base.css\" />\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body background=\"images/bg.gif\">\r\n");
      out.write("\t\r\n");
      out.write("\t<div id=\"div_json\">\r\n");
      out.write("\t\t<h5>录入数据</h5>\r\n");
      out.write("\t\t<br />\r\n");
      out.write("\t\t<form action=\"#\" method=\"post\">\r\n");
      out.write("\t\t\t<label for=\"name\">姓名：</label><input type=\"text\" name=\"name\" />\r\n");
      out.write("\t\t\t<label for=\"age\">年龄：</label><input type=\"text\" name=\"age\" />\r\n");
      out.write("\t\t\t<label for=\"position\">职务：</label><input type=\"text\" name=\"position\" />\r\n");
      out.write("\t\t\t<input type=\"button\" class=\"btn\" value=\"提交结果\"/>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t<br />\r\n");
      out.write("\t\t<h5>显示结果</h5>\r\n");
      out.write("\t\t<br />\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t\t<li>姓名：<span id=\"s_name\">赞无数据</span></li>\r\n");
      out.write("\t\t\t<li class=\"li_layout\">年龄：<span id=\"s_age\">暂无数据</span></li>\r\n");
      out.write("\t\t\t<li class=\"li_layout\">职务：<span id=\"s_position\">暂无数据</span></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div id=\"authorgraph\"><img alt=\"\" src=\"images/autograph.gif\"></div>\r\n");
      out.write("\t\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"scripts/jquery-1.8.2.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t/* 提交结果，执行ajax */\r\n");
      out.write("\t\tfunction btn(){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar $btn = $(\"input.btn\");//获取按钮元素\r\n");
      out.write("\t\t\t//给按钮绑定点击事件\r\n");
      out.write("\t\t\t$btn.bind(\"click\",function(){\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\ttype:\"post\",\r\n");
      out.write("\t\t\t\t\turl:\"excuteAjaxJsonAction\",//需要用来处理ajax请求的action,excuteAjax为处理的方法名，JsonAction为action名\r\n");
      out.write("\t\t\t\t\tdata:{//设置数据源\r\n");
      out.write("\t\t\t\t\t\tname:$(\"input[name=name]\").val(),\r\n");
      out.write("\t\t\t\t\t\tage:$(\"input[name=age]\").val(),\r\n");
      out.write("\t\t\t\t\t\tposition:$(\"input[name=position]\").val()//这里不要加\",\"  不然会报错，而且根本不会提示错误地方\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\tdataType:\"json\",//设置需要返回的数据类型\r\n");
      out.write("\t\t\t\t\tsuccess:function(data){\r\n");
      out.write("\t\t\t\t\t\tvar d = eval(\"(\"+data+\")\");//将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构\r\n");
      out.write("\t\t\t\t\t\t//得到的d是一个形如{\"key\":\"value\",\"key1\":\"value1\"}的数据类型，然后取值出来\r\n");
      out.write("\t\t\t\t\t\talert(data.name);\r\n");
      out.write("\t\t\t\t\t\t$(\"#s_name\").text(\"\"+d.name+\"\");\r\n");
      out.write("\t\t\t\t\t\t$(\"#s_age\").text(\"\"+d.age+\"\");\r\n");
      out.write("\t\t\t\t\t\t$(\"#s_position\").text(\"\"+d.position+\"\");\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\terror:function(){\r\n");
      out.write("\t\t\t\t\t\talert(\"系统异常，请稍后重试！\");\r\n");
      out.write("\t\t\t\t\t}//这里不要加\",\"\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\t/* 页面加载完成，绑定事件 */\r\n");
      out.write("\t\t$(document).ready(function(){\t\t\t\r\n");
      out.write("\t\t\tbtn();//点击提交，执行ajax\r\n");
      out.write("\t\t});\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
