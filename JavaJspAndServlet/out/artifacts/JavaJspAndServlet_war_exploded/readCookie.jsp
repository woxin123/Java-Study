<%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/10/7
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>读取Cookie</title>
</head>
<body>
<%
    // 获取在本客户端上保留的所有的Cookie
    Cookie[] cookies = request.getCookies();
    // 遍历所有客户端上的每个Cookie
    for (Cookie c : cookies) {
        // 如果Cookie的名为username，表明该Cookie是需要访问的Cookie
        if (c.getName().equals("uername")) {
            out.println(c.getValue());
        }
    }
%>
</body>
</html>
