<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%--
  Created by IntelliJ IDEA.
  User: mengchen
  Date: 2018/2/4
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎</title>
</head>
<body>
登录名：${user.loginname}<br/>
生日：<fmt:formatDate value="${user.birthday}" pattern="yyyy年MM月dd日" />
</body>
</html>
