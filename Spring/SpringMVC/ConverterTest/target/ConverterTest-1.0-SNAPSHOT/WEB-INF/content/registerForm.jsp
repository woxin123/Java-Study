<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: mengchen
  Date: 18-2-3
  Time: 下午2:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<h3>注册页面</h3>
<form action="/register" method="post">
    <table>
        <tr>
            <td><label>登录名:</label></td>
            <td><input name="loginname" type="text" /></td>
        </tr>
        <tr>
            <td><label>生日</label></td>
            <td><input type="text" name="birthday" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="注册" /></td>
        </tr>
    </table>
</form>
</body>
</html>
