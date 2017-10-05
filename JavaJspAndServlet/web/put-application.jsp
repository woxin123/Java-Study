<%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/10/5
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>applaction测试</title>
</head>
<body>
<!-- JSP声明 -->
<%!
    int i;
%>
<!-- 将i值自加后放入applaction的变量内 -->
<%
    application.setAttribute("counter", String.valueOf(++i));%>
<!-- 输出i值 -->
<%=i%>
</body>
</html>
