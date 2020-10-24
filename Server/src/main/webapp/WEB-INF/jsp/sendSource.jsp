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
            setTimeout("document.getElementById('form1').submit()",500);

        }
    </script>
    <title>sendToken</title>
</head>
<body onload="submitForms()">
<%
    String LOCAL_SERVICE=(String)request.getAttribute("LOCAL_SERVICE");
    String uri=LOCAL_SERVICE+"_dealWithSource";

%>
<form id="form1" action=<%=uri%> method="post">
    <label>
        <input name="source" type="hidden" value=<%=request.getAttribute("source")%>>
        <input name="BooksJson" type="hidden" value=<%=request.getAttribute("BooksJson")%>>
    </label>
    <text>
        发送source中......
    </text>
</form>
</body>
</html>
