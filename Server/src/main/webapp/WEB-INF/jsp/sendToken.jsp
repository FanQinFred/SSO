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
            setTimeout("document.getElementById('form1').submit()",500);

        }
    </script>
    <title>sendToken</title>
</head>
<body onload="submitForms()">
<%
    String LOCAL_SERVICE=(String) request.getAttribute("LOCAL_SERVICE");
    String uri=LOCAL_SERVICE+"_dealWithToken";
%>
<form id="form1" action=<%=uri%> method="post">
    <label>
        <input name="token" type="hidden" value=<%=request.getAttribute("token")%>>
    </label>
    <label>
        <input name="username" type="hidden" value=<%=request.getAttribute("username")%>>
    </label>
    <label>
        <input name="LOCAL_SERVICE" type="hidden" value=<%=request.getAttribute("LOCAL_SERVICE")%>>
    </label>
    <text>发送token中......</text>
</form>
</body>
</html>
