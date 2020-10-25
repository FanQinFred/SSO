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
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>OAuth2.0-SSO Signin</title>

    <!-- Bootstrap core CSS -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="signin.css" rel="stylesheet">

</head>

<body>

    <div class="container">

        <form class="form-signin" method="post" action="http://localhost:8080/SourceOwner_register">
            <h2 class="form-signin-heading">Please sign in</h2>
            <label for="User Name" class="sr-only">User Name</label>
            <input name="username" id="User Name" class="form-control" placeholder="Email address" required autofocus>
            <label for="inputPassword" class="sr-only">Password</label>
            <input name="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required>
            <input name="conf_password" type="password" id="inputconfPassword" class="form-control" placeholder="Confirm Password" required>
            <input name="phone_num" id="Phone" class="form-control" placeholder="Phone number" required>
            <label>
                <p>来自域：<input type="text" name="LOCAL_SERVICE" value="http://localhost:8081/app01" readonly></p>
            </label>
            <br>
            <text><%=request.getAttribute("info")%></text>
            <br>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
        </form>

    </div> <!-- /container -->

</body>

</html>
