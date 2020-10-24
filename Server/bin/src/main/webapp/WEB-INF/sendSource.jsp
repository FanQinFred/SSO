<%--
  Created by IntelliJ IDEA.
  User: fanqi
  Date: 2020/10/23
  Time: 11:22
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
<form id="form1" action="http://localhost:8081/app01_dealWithSource" method="post">
    <label>
        <input name="source" type="hidden" value=<%=request.getAttribute("source")%>>
    </label>
    <text>
        发送source中......
    </text>
</form>
</body>
</html>
