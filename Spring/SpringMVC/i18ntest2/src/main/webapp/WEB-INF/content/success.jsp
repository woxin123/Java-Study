<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: mengchen
  Date: 2018/2/18
  Time: 23:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试ConversionService</title>
</head>
<body>
<spring:message code="welcome" arguments="${user.username}" />
</body>
</html>
