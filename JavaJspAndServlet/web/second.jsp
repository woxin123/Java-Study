<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/10/6
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>request处理</title>
</head>
<body>
<%
    // 取出钱数的请求
    String bal = request.getParameter("balance");
    double qian = Double.parseDouble(bal);
    // 取出request范围内的info属性
    List<String> info = (List<String>) request.getAttribute("info");
    for (String temp : info) {
        out.println(temp + "<br/>");
    }
    out.println("取钱" + qian + "块<br/>");
    out.println("账户减少" + qian);
%>
</body>
</html>
