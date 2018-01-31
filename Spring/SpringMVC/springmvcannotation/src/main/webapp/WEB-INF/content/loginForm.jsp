<%--
  Created by IntelliJ IDEA.
  User: mengchen
  Date: 18-1-31
  Time: 下午2:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="/user/login" method="post">
    登录名：<input type="text" name="loginname"><br/>
    密码：<input type="password" name="password"><br/>
    <input type="submit" value="登录">
</form>
</body>
</html>
