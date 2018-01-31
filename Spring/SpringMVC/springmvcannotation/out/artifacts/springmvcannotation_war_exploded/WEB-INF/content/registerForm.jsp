<%--
  Created by IntelliJ IDEA.
  User: mengchen
  Date: 18-1-31
  Time: 下午2:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form action="/user/register" method="post" >
    登录名：<input type="text" name="loginname" /><br/>
    密 &nbsp;码：<input type="password" name="password" /><br/>
    真实姓名：<input type="text" name="username" /><br/>
    <input type="submit" value="注册">
</form>
</body>
</html>
