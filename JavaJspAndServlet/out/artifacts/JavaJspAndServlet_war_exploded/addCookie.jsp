<%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/10/7
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加Cookie</title>
</head>
<body>
<%
    // 获取请求参数
    String name = request.getParameter("name");
    // 以获取到的请求参数的值，创建一个Cookie对象
    Cookie c = new Cookie("username", name);
    // 设置Cookie对象的生命期限
    c.setMaxAge(24*3600);
    // 向客户端增加Cookie对象
    response.addCookie(c);
%>
</body>
</html>
