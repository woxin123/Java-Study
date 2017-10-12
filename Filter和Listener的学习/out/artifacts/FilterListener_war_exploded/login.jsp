<%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/10/12
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<h2>登录页面</h2>
<%
    if (request.getAttribute("tip") != null) {
        out.println("<font color='red'>" + request.getAttribute("tip") + "</font>");
    }
%>
<form action="proLogin.jsp" method="post" >
    用户名：<input type="text" name="name" /> <br/>
    <input type="submit" value="登录" />
</form>
</body>
</html>
