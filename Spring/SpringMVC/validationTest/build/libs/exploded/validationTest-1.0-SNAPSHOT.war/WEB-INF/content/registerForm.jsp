<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: mengchen
  Date: 2018/2/25
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<h3>注册</h3>
<form:form action="/register" method="post" modelAttribute="user">
    <table>
        <tr>
            <td>登录名：</td>
            <td><form:input path="loginname"/></td>
            <td><form:errors path="loginname" cssClass="error"/></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><form:input path="password" type="password"/></td>
            <td><form:errors path="password" cssClass="error"/></td>
        </tr>
        <tr>
            <td>用户名：</td>
            <td><form:input path="username"/></td>
            <td><form:errors path="username" cssClass="error"/></td>
        </tr>
        <tr>
            <td>年龄：</td>
            <td><form:input path="age"/></td>
            <td><form:errors path="age" cssClass="error"/></td>
        </tr>
        <tr>
            <td>邮箱：</td>
            <td><form:input path="emial"/></td>
            <td><form:errors path="emial" cssClass="error"/></td>
        </tr>
        <tr>
            <td>生日：</td>
            <td><form:input path="birthday"/></td>
            <td><form:errors path="birthday" cssClass="error"/></td>
        </tr>
        <tr>
            <td>电话：</td>
            <td><form:input path="phone"/></td>
            <td><form:errors path="phone" cssClass="error"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="注册"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
