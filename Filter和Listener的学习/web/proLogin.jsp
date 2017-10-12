<%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/10/12
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<%
    session.setAttribute("user", request.getParameter("name"));
%>
登陆成功。可以访问其他的页面
</body>
</html>
