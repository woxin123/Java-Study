<%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/10/7
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    out.println("========");
    // 重定向到forward-result页面
    response.sendRedirect("redirect-result.jsp");
%>
</body>
</html>
