<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: mengchen
  Date: 2018/2/22
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试表单格式化数据</title>
</head>
<body>
<table style="border: 1px;">
    <tr>
        <th>日期格式数据</th>
        <td>${user.birthday}</td>
    </tr>
    <tr>
        <th>整数格式数据</th>
        <td>${user.total}</td>
    </tr>
    <tr>
        <td>百分数格式数据</td>
        <td>${user.discount}</td>
    </tr>
    <tr>
        <th>货币类型的数据</th>
        <td>${user.money}</td>
    </tr>
</table>
<form:form modelAttribute="user" method="post" action="" >
    <table>
        <tr>
            <td>日期类型:</td>
            <td><form:input path="birthday"/></td>
        </tr>
        <tr>
            <td>整数类型:</td>
            <td><form:input path="total"/></td>
        </tr>
        <tr>
            <td>百分数类型:</td>
            <td><form:input path="discount"/></td>
        </tr>
        <tr>
            <td>货币类型:</td>
            <td><form:input path="money"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
