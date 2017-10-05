<%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/10/4
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<html>
<head>
    <title>Error测试</title>
</head>
<body>
<%
    // 下面的代码将出现异常
    int a = 4;
    int b = 0;
    int c = a / b;
%>
</body>
</html>
