<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: mengchen
  Date: 2018/2/17
  Time: 23:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="title" /></title>
</head>
<body>
<form:form modelAttribute="user" method="post" action="/login" >
    <table>
        <tr>
            <td><spring:message code="loginname" /></td>
            <td><form:input path="loginname" /></td>
        </tr>
        <tr>
            <td><spring:message code="password" /> </td>
            <td><form:input path="password" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="<spring:message code="submit" />" /></td>
        </tr>
    </table>
</form:form>
</body>
</html>