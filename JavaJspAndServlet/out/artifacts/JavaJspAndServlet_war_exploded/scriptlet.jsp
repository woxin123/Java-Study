<%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/10/4
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>小脚本测试</title>
</head>
<body>
<table style="background-color: #9999dd" border = "1" width="300px">
    <!-- Java脚本，这些脚本将会对HTML产生作用 -->
    <%
        for (int i = 0; i < 10; i++) {
    %>
            <!-- 上面的循环将控制<tr>标签 -->
            <tr>
                <td>循环值：</td>
                <td><%=i%></td>
            </tr>
    <%}%>
</table>
</body>
</html>
