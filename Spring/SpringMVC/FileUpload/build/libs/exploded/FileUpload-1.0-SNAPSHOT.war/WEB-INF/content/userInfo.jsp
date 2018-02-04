<%--
  Created by IntelliJ IDEA.
  User: mengchen
  Date: 2018/2/4
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件下载</title>
</head>
<body>
<h2>文件下载</h2>
<a href="/download?fileName=${user.image.originalFilename}">
    ${user.image.originalFilename}
</a>
</body>
</html>
