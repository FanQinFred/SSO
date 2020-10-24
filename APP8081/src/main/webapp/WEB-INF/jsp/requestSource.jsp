<%--
  Created by IntelliJ IDEA.
  User: fanqi
  Date: 2020/10/23
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>requestSource</title>
    <script>
        function submitForms()
        {
            setTimeout("document.getElementById('form2').submit()",500);

        }
    </script>
</head>
<body onload="submitForms()">
<form id="form2" action="http://localhost:8084/SourceOwner_sendSource" method="post">
    <label>
        <input name="token" type="hidden" value=<%=request.getAttribute("token")%>>
    </label>
    <label>
        <input name="username" type="hidden" value=<%=request.getAttribute("username")%>>
    </label>
    <text>
        获取资源中...
    </text>
</form>
</body>
</html>
