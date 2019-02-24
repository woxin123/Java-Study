<%--
  Created by IntelliJ IDEA.
  User: mengchen
  Date: 19-2-23
  Time: 下午8:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试</title>
    <meta charset="UTF-8">
</head>
<body>
<h2>Hello World!</h2>
<h2>SpringMVC上传文件</h2>
<form name="form1" action="/manager/product/upload.do" method="post" enctype="multipart/form-data">
    <input type="file" name="upload_file">
    <input type="submit" value="springmvc上传文件">
</form>
<h2>富文本图片上传</h2>
<form name="form2" action="/manager/product/richtext_img_upload.do" method="post" enctype="multipart/form-data">
    <input type="file" name="upload_file">
    <input type="submit" value="富文本图片上传">
</form>
</body>
</html>
