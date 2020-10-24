<%--
  Created by IntelliJ IDEA.
  User: surface
  Date: 2020/10/22
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <form method="post" action="http://localhost:8080/SourceOwner_sendCode">
        账号:<label>
        <input type="text" name="username">
    </label>
        <br>
        密码:<label>
        <input type="password" name="password">
    </label>
        <label>
            <p>来自域：<input type="text" name="LOCAL_SERVICE" value="http://localhost:8081/app01" readonly></p>
        </label>
        <br>
        <text><%=request.getAttribute("info")%></text>
        <br>
        <button type="submit">点击登录</button>
    </form>
    <a href="http://localhost:8081/app01_register?LOCAL_SERVICE=http://localhost:8081/app01">点击注册</a>
</body>
</html>
