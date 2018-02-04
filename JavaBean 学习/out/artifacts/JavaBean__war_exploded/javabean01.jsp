<%@ page import="com.example.bean.SimpleBean" %><%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/10/27
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<html>
<head>
    <title>JavaBean</title>
</head>
<body>
<%
    SimpleBean simpleBean = new SimpleBean();
    simpleBean.setName("孟晨");
    simpleBean.setAge(20);
%>
<h3>姓名：<%=simpleBean.getName()%></h3>
<h3><%=simpleBean.getAge()%></h3>
</body>
</html>
