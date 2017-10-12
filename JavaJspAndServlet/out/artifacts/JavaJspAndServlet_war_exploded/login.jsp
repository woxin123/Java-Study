<%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/10/11
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>new document</title>
</head>
<body>
<!-- 输出错误提示 -->
<span style="color:red;font-weight:bold">
    <%
        // getAttribute获取request属性范围
        if(request.getAttribute("err") != null) {
            out.println(request.getAttribute("err") + "<br/>");
        }
    %>
</span>
请输入用户名和密码：
<!-- 登录表单，该表单提交到一个Servlet -->
<form id="login" method="post" action="login">
    用户名: <input type="text" name="username" /><br/>
    密&nbsp;&nbsp;码: <input type="password" name="pass" /> <br/>
    <input type="submit" value="登录" /> <br/>
</form>
</body>
</html>
