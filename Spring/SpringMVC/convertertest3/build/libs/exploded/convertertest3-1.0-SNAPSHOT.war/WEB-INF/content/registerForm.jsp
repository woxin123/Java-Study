<%--
  Created by IntelliJ IDEA.
  User: mengchen
  Date: 2018/2/20
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试WebBindingInitializer</title>
</head>
<body>
<h3>测试WebBindingInitializer</h3>
<form action="register" method="post">
    <table>
        <tr>
            <td><label>登录名: </label></td>
            <td><input type="text" id="loginname" name="loginname" ></td>
        </tr>
        <tr>
            <td><label>生日: </label></td>
            <td><input type="text" id="birthday" name="birthday" ></td>
        </tr>
        <tr>
            <td><input id="submit" type="submit" value="登录"></td>
        </tr>
    </table>
</form>
</body>
</html>
