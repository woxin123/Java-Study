<%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/10/4
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>forward的原始网页</title>
</head>
<body>
<h3>forward的原始网页</h3>
<jsp:forward page="forward-result.jsp">
    <jsp:param name="age" value="20" />
</jsp:forward>
</body>
</html>
