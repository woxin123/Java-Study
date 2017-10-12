<%@ page import="static jdk.nashorn.internal.runtime.regexp.joni.Syntax.Java" %><%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/10/7
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试Cookie</title>
</head>
<body>
<%
    // 以编码后的字符串为值，创建一个Cookie
    Cookie c = new Cookie("cnName", java.net.URLEncoder.encode("孙悟空", "UTF-8"));
    // 设置Cookie的生命周期
    c.setMaxAge(24 * 3600);
    // 向客户端增加Cookie
    response.addCookie(c);
    // 获取本站上保留的所有的Cookie
    Cookie[] cookies = request.getCookies();
    // 遍历获取客户端上的每个Cookie
    for (Cookie cookie : cookies) {
        if (cookie.getName().equals("cnName")) {
        out.println(java.net.URLDecoder.decode(cookie.getValue(), "UTF-8"));
        }
    }
%>
</body>
</html>
