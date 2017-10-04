<%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/9/30
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>第二个jsp页面</title>
</head>
<body>
<!--下面的是一个Java脚本-->
<%for (int i = 0; i < 7; i++) {
    out.println("<font size='" + i + "'>");
%>
这是我的世界</font>
</br>
</body>
<%}%>
</html>
