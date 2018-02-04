<%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/10/27
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<jsp:useBean id="simple" scope="page" class="com.example.bean.SimpleBean" />
<html>
<head>
    <title>JavaBean</title>
</head>
<body>
<%
    simple.setName("孟晨");
    simple.setAge(20);
%>
<h3>姓名：<%=simple.getName()%></h3>
<h3>年龄：<%=simple.getAge()%></h3>
</body>
</html>
