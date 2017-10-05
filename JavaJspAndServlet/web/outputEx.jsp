<%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/10/3
  Time: 23:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>输出表达式</title>
</head>
<%!
    public int count;
    public String info() {
        return "Hello";
    }
%>
<body>
<!-- 使用表达式输出变量的值 -->
<%=count++%>
<!-- 使用表达式输出方法的返回值 -->
<%=info()%>
</body>
</html>
