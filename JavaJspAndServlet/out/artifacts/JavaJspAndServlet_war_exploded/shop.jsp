<%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/10/8
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>选择物品购买</title>
</head>
<body>
<form method="post" action="processBuy.jsp">
    书籍：<input type="checkbox" name="item" value="book" /> <br/>
    电脑：<input type="checkbox" name="item" value="compare" /> <br/>
    汽车：<input type="checkbox" name="item" value="car"/><br/>
    <input type="submit" name="购买">
</form>
</body>
</html>
