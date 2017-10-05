<%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/10/5
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>pageContext测试</title>
</head>
<body>
<%
    // 使用pageContext设置属性，该属性是默认在page范围内的
    pageContext.setAttribute("page", "hello");
    // 使用request设置属性，该属性默认是在request范围内的
    request.setAttribute("request", "hello");
    // 使用pageContext将属性设置在request范围内
    pageContext.setAttribute("request2", "hello", PageContext.REQUEST_SCOPE);
    // 使用session将属性设置在session范围内
    session.setAttribute("session", "hello");
    // 使用pageContext将属性设置在session范围内
    pageContext.setAttribute("session2", "hello", PageContext.SESSION_SCOPE);
    // 使用application将属性设置在application范围内
    application.setAttribute("application", "hello");
    // 使用pageContext将属性值设置在application范围内
    pageContext.setAttribute("application2", "hello", PageContext.APPLICATION_SCOPE);
    // 下面获取各属性所在的范围
    out.println("page变量所在的范围：" + pageContext.getAttributesScope("page") + "<br/>");
    out.println("request变量所在的范围：" + pageContext.getAttributesScope("request") + "<br/>");
    out.println("request2变量所在的范围：" + pageContext.getAttributesScope("request2") + "<br/>");
    out.println("session变量所在的范围：" + pageContext.getAttributesScope("session") + "<br/>");
    out.println("session2变量所在的范围：" + pageContext.getAttributesScope("session") + "<br/>");
    out.println("application变量所在的范围：" + pageContext.getAttributesScope("application") + "<br/>");
    out.println("application变量所在的范围：" + pageContext.getAttributesScope("application2") + "<br/>");
%>
</body>
</html>
