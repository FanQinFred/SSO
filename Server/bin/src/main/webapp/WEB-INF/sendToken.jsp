<%--
  Created by IntelliJ IDEA.
  User: surface
  Date: 2020/10/22
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript">
        function submitForms()
        {
            setTimeout("document.getElementById('form1').submit()",2000);

        }
    </script>
    <title>sendToken</title>
</head>
<body onload="submitForms()">
<form id="form1" action="http://localhost:8081/app01_dealWithToken" method="post">
    <label>
        <input name="token" type="hidden" value=<%=request.getAttribute("token")%>>
    </label>
    <label>
        <input name="username" type="hidden" value=<%=request.getAttribute("username")%>>
    </label>
    <textarea>发送token中......</textarea>
</form>
</body>
</html>
