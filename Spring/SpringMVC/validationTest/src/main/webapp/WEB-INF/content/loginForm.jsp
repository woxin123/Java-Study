<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: mengchen
  Date: 2018/2/25
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试Validator接口验证</title>
</head>
<body>
<h3>登录页面</h3>
<form:form action="/login" method="post" modelAttribute="user" >
    <table>
        <tr>
            <td>登录名:</td>
            <td><form:input path="loginname" /></td>
            <!-- 显示loginname的错误信息 -->
            <td><form:errors path="loginname" cssStyle="color: red" /></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><form:input path="password" type="password" /></td>
            <td><form:errors path="password" cssStyle="color: red" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="登录"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
