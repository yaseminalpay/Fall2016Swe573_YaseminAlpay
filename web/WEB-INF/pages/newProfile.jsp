<%--
  Created by IntelliJ IDEA.
  User: Yase
  Date: 23.10.2016
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello, $(username)!</title>
</head>
<body>
    <h1>username: ${user}</h1>
    <h1>pass: ${pass}</h1>


    <form method="POST" action="/newProfile" modelAttribute="profile">
        Name:<input type="text" name="userName"><br>
        Password:<input type="password" name="password"><br>
        <input type="submit" value="login">
    </form>

</body>
</html>
