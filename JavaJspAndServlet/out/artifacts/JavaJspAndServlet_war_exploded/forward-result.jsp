<%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/10/4
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>forward的结果页</title>
</head>
<body>
<!-- 使用request的内置对象获取age的值 -->
<%=request.getParameter("age")%>
<%=request.getParameter("username")%>
</body>
</html>
