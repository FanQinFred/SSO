<%--
  Created by IntelliJ IDEA.
  User: fanqi
  Date: 2020/10/24
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
<form method="post" action="http://localhost:8080/SourceOwner_register">
    账号:<label>
    <input type="text" name="username">
</label>
    <br>
    密码:<label>
    <input type="password" name="password">
</label>
    <br>
    确认密码:<label>
    <input type="password" name="conf_password">
</label>
    <br>
    (选填)电话号码:<label>
    <input type="text" name="phone_num">
    <input type="hidden" name="LOCAL_SERVICE" value="http://localhost:8081/app01">
</label>
    <br>
    <text><%=request.getAttribute("info")%></text>
    <br>
    <button type="submit">点击注册</button>
</form>


</body>
</html>
