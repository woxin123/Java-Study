<%--
  Created by IntelliJ IDEA.
  User: mengchen
  Date: 2018/2/22
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试表单数据格式化</title>
</head>
<body>
<h2>测试表单数据格式化</h2>
<form action="/test" method="post" >
    <table>
        <tr>
            <td>日期类型：</td>
            <td><input type="text" name="birthday"></td>
        </tr>
        <tr>
            <td>整数类型：</td>
            <td><input type="text" name="total"></td>
        </tr>
        <tr>
            <td>百分数类型：</td>
            <td><input type="text" name="discount"></td>
        </tr>
        <tr>
            <td>货币类型：</td>
            <td><input type="text" name="money"></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
