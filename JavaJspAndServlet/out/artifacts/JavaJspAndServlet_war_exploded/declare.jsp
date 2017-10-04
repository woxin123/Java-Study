<%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/9/30
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>声明示例</title>
</head>
<%!
    //声明整型变量
    public int count;
    // 声明一个方法
    public String info() {
        return "Hello";
    }
%>
<body>
<%
out.println(count++);
%>
<%
    // 输出info的值
    out.println(info());
%>
</body>
</html>
