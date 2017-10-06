<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/9/30
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>request处理</title>
</head>
<body>
<%
    // 获取请求的钱数
    String bal = request.getParameter("balance");
    // 将钱数的字符串转换成双精度的浮点数
    double qian = Double.parseDouble(bal);
    // 对取钱数进行判断
    if (qian < 500) {
        out.println("给你" + qian + "块");
        out.println("账户减少" + qian);
    } else {
        // 创建一个List对象
        List<String> info = new ArrayList<String>();
        info.add("1111111");
        info.add("2222222");
        info.add("3333333");
        // 将info对象放入到request范围内
        request.setAttribute("info", info);
%>
<!-- 实现转发 -->
<jsp:forward page="second.jsp"/>
<%}%>
</body>
</html>
