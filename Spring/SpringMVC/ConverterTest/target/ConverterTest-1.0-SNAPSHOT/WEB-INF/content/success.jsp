<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: mengchen
  Date: 18-2-3
  Time: 下午4:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册成功</title>
</head>
<body>
用户名:${user.loginname}<br/>
生日:<fmt:formatDate value="${user.birthday}" pattern="yyyy年MM月dd日" />
</body>
</html>
