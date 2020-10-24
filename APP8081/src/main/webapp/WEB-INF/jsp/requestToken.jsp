<%--
  Created by IntelliJ IDEA.
  User: surface
  Date: 2020/10/22
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>requestToken</title>
    <script>
        function submitForms()
        {
            setTimeout("document.getElementById('form2').submit()",500);

        }
    </script>
</head>
<body onload="submitForms()">
    <form id="form2" action="http://localhost:8080/AuthorizationServer_sendToken" method="post">
        <label>
            <input name="code" type="hidden" value=<%=request.getAttribute("code")%>>
        </label>
        <label>
            <input name="username" type="hidden" value=<%=request.getAttribute("username")%>>
        </label>
        <label>
            <input name="LOCAL_SERVICE" type="hidden" value=<%=request.getAttribute("LOCAL_SERVICE")%>>
        </label>
        <text>
            使用code获取token中...
        </text>
    </form>
</body>
</html>
