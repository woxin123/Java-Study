<%--
  Created by IntelliJ IDEA.
  User: mengchen
  Date: 18-2-2
  Time: 下午8:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试JSON传输</title>
    <script type="text/javascript" src="/Js/jquery-3.3.1.min.js" ></script>
    <script type="text/javascript" src="Js/json2.js" ></script>
    <script type="text/javascript">
        function testRequestBody(){
            $.ajax("${pageContext.request.contextPath}/json/testRequestBody",// 发送请求的URL字符串。
                {
                    dataType : "json", // 预期服务器返回的数据类型。
                    type : "post", //  请求方式 POST或GET
                    contentType:"application/json", //  发送信息至服务器时的内容编码类型
                    // 发送到服务器的数据。
                    data:JSON.stringify({"id" : 1, "name" : "账单"}),
                    async:  true , // 默认设置下，所有请求均为异步请求。如果设置为false，则发送同步请求
                    // 请求成功后的回调函数。
                    success :function(data){
                        console.log(data);
                        $("#id").html(data.id);
                        $("#name").html(data.name);
                        $("#sex").html(data.sex);
                    },
                    // 请求出错时调用的函数
                    error:function(){
                        alert("数据发送失败");
                    }
                });
        }
    </script>
</head>
<body>

<p>
编号：<span id="id"></span><br>
书名：<span id="name"></span><br>
性别：<span id="sex"></span><br></p>
<button onclick="testRequestBody()" >发送</button>
</body>
</html>
