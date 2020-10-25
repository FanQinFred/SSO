<%--
  Created by IntelliJ IDEA.
  User: fanqi
  Date: 2020/10/25
  Time: 20:11
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
    <title>sendCode</title>
</head>
<body onload="submitForms()">
<%
    String LOCAL_SERVICE=(String) request.getAttribute("LOCAL_SERVICE");
    String uri=LOCAL_SERVICE+"_dealWithCode";
%>
<form id="form1" action=<%=uri%> method="post">
    <label>
        <input name="code" type="hidden" value=<%=request.getAttribute("code")%>>
    </label>
    <label>
        <input name="username" type="hidden" value=<%=request.getAttribute("username")%>>
    </label>
    <label>
        <input name="LOCAL_SERVICE" type="hidden" value=<%=request.getAttribute("LOCAL_SERVICE")%>>
    </label>
    <text>发送code中......</text>
</form>
</body>
</html>