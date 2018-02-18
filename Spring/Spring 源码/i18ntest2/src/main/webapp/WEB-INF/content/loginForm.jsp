<%@ taglib prefix="sping" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: mengchen
  Date: 2018/2/18
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试基于SessionLocaleResolver的国际化</title>
</head>
<body>
<!-- 用户选择语言环境 -->
<a href="loginForm?request_locale=zh_CN">中文</a> | <a href="loginForm?request_locale=en_US">英文</a>
<h3><sping:message code="title"/> </h3>
<form:form modelAttribute="user" method="post" action="/login" >
    <table>
        <tr>
            <td><spring:message code="loginname"/></td>
            <td><form:input path="loginname"/></td>
        </tr>
        <tr>
            <td><spring:message code="password"/></td>
            <td><form:input path="password"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="<spring:message code="submit"/>"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
