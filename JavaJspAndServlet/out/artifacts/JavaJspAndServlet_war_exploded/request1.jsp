<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/10/6
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取请求头/请求参数</title>
</head>
<body>
<%
    Enumeration<String> headNames = request.getHeaderNames();
    while (headNames.hasMoreElements()) {
        String headName = headNames.nextElement();
        // 获取每个请求及其对应的值
        System.out.println(headName + "--->" + request.getHeader(headName));
    }
    out.println("<hr/>");
    // 设置解码方式
    request.setCharacterEncoding("UTF-8");
    // 下面依次获取每个表单域的值
    String name = request.getParameter("name");
    String gender = request.getParameter("gender");
    // 如果某个参数有多个值，将使用该方法获取多个值
    String[] color = request.getParameterValues("color");
    String national = request.getParameter("country");
%>
<!-- 下面依次输出表单域的值 -->
您的名字:<%=name%><hr/>
您的性别:<%=gender%><hr/>
<!-- 输出复选框的内容 -->
您喜欢的颜色:<%for(String c : color)
    out.println(c + " ");%><hr/>
您来自的国家:<%=national%><hr/>
</body>
</html>
