<%@ page import="java.util.Map" %>
<%@ page import="com.example.Db.DbDao" %>
<%@ page import="jdk.nashorn.internal.ir.RuntimeNode" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/10/14
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户在线信息</title>
</head>
<body>
在线用户：
<table width="400" border="1">
    <%
        DbDao dd = new DbDao("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/javaee",
                "root", "mengchen0705");
        ResultSet rs = dd.query("select * from online_inf", false);
        while (rs.next()) {
    %>
    <tr>
        <td><%=rs.getString(1)%>
        </td>
        <td><%=rs.getString(2)%>
        </td>
        <td><%=rs.getString(3)%>
        </td>
        <td><%=rs.getString(4)%>
        </td>
    </tr>
    <%
        }

    %>
</table>
</body>
</html>
