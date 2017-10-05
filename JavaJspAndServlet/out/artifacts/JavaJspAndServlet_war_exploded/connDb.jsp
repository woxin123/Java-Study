<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/10/4
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>小脚本测试</title>
</head>
<body>
<%
    // 获取数据库驱动
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
            "root", "mengchen0705");
    // 创建Statement
    Statement stat = conn.createStatement();
    // 执行查询，获得结果
    ResultSet rs = stat.executeQuery("select * from test");
%>
<table style="background-color: darkturquoise" border="1" width="300">
    <%
        // 遍历输出结果集
        while (rs.next()) {
    %>
        <tr>
            <td><%=rs.getString(1)%></td>
            <td><%=rs.getString(2)%></td>
        </tr>
    <%
        }
    %>
</table>
</body>
</html>
