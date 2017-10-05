<%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/10/5
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>异常处理页面</title>
</head>
<body>
异常的类型是：<%=exception.getClass()%><br/>
异常的信息是：<%=exception.getMessage()%>
</body>
</html>
