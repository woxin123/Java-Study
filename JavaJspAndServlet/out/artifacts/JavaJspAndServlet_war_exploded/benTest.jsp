<%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/10/5
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<br>
<head>
    <title>Java Bean测试</title>
</head>
<!-- 创建Person实例，该实例的名称为p1 -->
<jsp:useBean id="p1" class="com.example.forJsp.Person" scope="page" />
<!-- 设置p1的name属性 -->
<jsp:setProperty name="p1" property="name" value="wawa" />
<!-- 设置p1的age属性 -->
<jsp:setProperty name="p1" property="age" value="23" />
<!-- getp1的name属性 -->
<jsp:getProperty name="p1" property="name" /></br>
<!-- getp1的age属性 -->
<jsp:getProperty name="p1" property="age"/>
</body>
</html>
