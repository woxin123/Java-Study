<%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/10/6
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取包含非西欧字符的GET请求参数</title>
</head>
<body>
<%
    // 获取请求里面包含的查询字符
    String rawQueryStr = request.getQueryString();
    out.println("原始的查询字符串为：" + rawQueryStr + "<hr/>");
    // 使用URLDecoder解码字符串
    String queryStr = java.net.URLDecoder.decode(rawQueryStr, "UTF-8");
    out.println("解码后的查询字符串为：" + queryStr + "<hr/>");
    // 以&符号分解查询字符串
    String[] paramPairs = queryStr.split("&");
    for (String paramPair : paramPairs) {
        out.println("每个请求参数名、值对象为：" + paramPair + "<br/>");
        // 以=来分解参数名和值
        String[] nameValue = paramPair.split("=");
        out.println(nameValue[0] + "参数的值是：" + nameValue[1] + "<hr/>");
    }
%>
</body>
</html>
