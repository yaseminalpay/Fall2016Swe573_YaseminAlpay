<%--
  Created by IntelliJ IDEA.
  User: Yase
  Date: 23.10.2016
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GetFit, Stay Fit</title>
</head>
<body>
    <h1>Welcome to GetFit!</h1>


    <form method="POST" action="/newProfile" modelAttribute="login">
        Name:<input type="text" name="userName"><br>
        Password:<input type="password" name="password"><br>
        <input type="submit" value="login">
    </form>

    </body>
</html>
