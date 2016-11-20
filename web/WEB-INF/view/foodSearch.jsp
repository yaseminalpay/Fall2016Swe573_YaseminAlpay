<%--
  Created by IntelliJ IDEA.
  User: Yase
  Date: 20.11.2016
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

    <form method="POST" action="/foodSearch" modelAttribute="keyword">
        Name:<input type="text" name="keyword"><br>
        <input type="submit" value="Search">
    </form>
</body>
</html>
