<%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/10/5
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试config内置对象</title>
</head>
<body>
<!-- 输出该JSP为name的配置参数 -->
name的配置参数的值是:<%=config.getInitParameter("name")%><br/>
age的配置参数的值是:<%=config.getInitParameter("age")%>
</body>
</html>
