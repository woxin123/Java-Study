<%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/10/27
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<%request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="simple" scope="page" class="com.example.bean.SimpleBean" />
<jsp:setProperty name="simple" property="*"/>
<html>
<head>
    <title>处理</title>
</head>
<body>
<h3>姓名：<jsp:getProperty name="simple" property="name"/></h3>
<h3>年龄：<jsp:getProperty name="simple" property="age"/></h3>
</body>
</html>
