<%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/10/14
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 获取请求参数
    String user = request.getParameter("username");
%>
<html>
<head>
    <title><%=user%>的个人信息</title>
</head>
<body>
<%
    out.println("现在的时间是：" + new java.util.Date() + "<br/>");
    out.println("用户名：" + user);
%>
</body>
</html>
