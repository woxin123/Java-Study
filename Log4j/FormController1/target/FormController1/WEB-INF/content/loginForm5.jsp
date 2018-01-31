<%--
  Created by IntelliJ IDEA.
  User: mengchen
  Date: 18-1-31
  Time: 下午8:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="/login5" method="post">
    <table>
        <tr>
            <td><label>登录名：</label></td>
            <td><input type="text" name="loginname"></td>
        </tr>
        <tr>
            <td><label>密码：</label></td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td><input type="submit" value="登录"></td>
        </tr>
    </table>
</form>
</body>
</html>
