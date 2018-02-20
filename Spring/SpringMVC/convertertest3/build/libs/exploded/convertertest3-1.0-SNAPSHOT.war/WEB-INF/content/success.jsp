<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
登录名：${requestScope.user.loginname }<br>
生日：<fmt:formatDate value="${user.birthday}"
                   pattern="yyyy年MM月dd日"/><br>
</body>
</html>
