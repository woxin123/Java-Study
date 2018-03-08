<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mengchen
  Date: 2018/3/7
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>论坛首页</title>
</head>
<body>
<%--<%@ include file="includeTop.jsp" %>--%>
<table border="1px" width="100%">
    <tr>
        <td clospan="3" bgcolor="#EEEEEE">所有论坛板块</td>
    </tr>
    <tr>
        <c:if test="${USER_CONTEXT.userType == 2}">
            <td>
                <script>
                    function switchSelectBox() {
                        var selectBoxs = document.all("boardIds");
                        if (!selectBoxs)
                            return;
                        if (typeof (selectBoxs.length) == "undefined") {
                            selectBoxs.checked = event.srcElement.checked;
                        } else {
                            for (var i = 0; i < selectBoxs.length; i++) {
                                selectBoxs[i].checked = event.srcElement.checked;
                            }
                        }
                    }

                </script>
                <input type="checkbox" onclick="switchSelectBox()" />
            </td>
        </c:if>
    </tr>
</table>
</body>
</html>
