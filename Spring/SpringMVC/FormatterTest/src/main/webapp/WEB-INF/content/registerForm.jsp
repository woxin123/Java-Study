<%--
  Created by IntelliJ IDEA.
  User: mengchen
  Date: 2018/2/21
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<form action="/register" method="post">
    <table>
        <tr>
            <td>登录名：</td>
            <td><input type="text" name="loginname"></td>
        </tr>
        <tr>
            <td>生日：</td>
            <td><input type="text" name="birthday"></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
