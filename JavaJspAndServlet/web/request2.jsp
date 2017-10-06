<%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/10/6
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取GET请求参数</title>
</head>
<body>
<%
    // 获取name请求参数的值
    String name = request.getParameter("name");
    // 获取gender请求参数
    String gender = request.getParameter("gender");
%>
<!-- 输出name变量的值 -->
您的名字：<%=name%><hr/>
<!-- 输出gender变量的值 -->
您的性别：<%=gender%><hr/>
</body>
</html>
