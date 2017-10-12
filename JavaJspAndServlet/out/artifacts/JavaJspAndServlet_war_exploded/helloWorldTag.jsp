<%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/10/11
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="mytag" uri="http://www.crazyit.org/mytaglib" %>
<html>
<head>
    <title>自定义标签示范</title>
</head>
<body bgcolor="#ffffc0">
<h2>下面显示的是自定义标签示范</h2>
<%-- 使用标签，其中的mytag是标签的前缀，根据taglib的编译指令，mytag前缀将由URI为。。。的标签库处理 --%>
<mytag:helloworld/><br/>
</body>
</html>
