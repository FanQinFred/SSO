<%@ page import="domain.Book" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: fanqi
  Date: 2020/10/23
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>source</title>
</head>
<body>

<table border="1" width="250">
    <tr>
        <td width="10%">序号</td><td width="20%">名称</td><td width="10%">价格（元）</td><td width="30%">介绍</td><td width="30%">图片</td>
    </tr>
    <%
        List<Book> Books= (List<Book>) request.getAttribute("Books");
    %>
    <%
        if(Books!=null){
            for(Integer i=0;i<Books.size();i++){
                Book book=Books.get(i);
    %>
    <tr>
        <td width="10%"><%=book.getId()%></td>
        <td width="20%"><%=book.getName()%></td>
        <td width="10%"><%=book.getPrice()%></td>
        <td width="30%"><%=book.getDes()%></td>
        <td width="30%"><img src=<%=book.getImage()%> width="100"></td>
    </tr>
    <%	}} %>
</table>

<br>
<a href="http://localhost:8082/app02_logout?info=PleaseInputYourUsernameAndPassword.">登出</a>
<br>
<a href="http://localhost:8080">回到主页</a>
</body>
</html>
