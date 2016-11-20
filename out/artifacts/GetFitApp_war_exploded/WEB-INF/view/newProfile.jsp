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
    <form method="POST" action="/profile" modelAttribute="profile">
        Username:<input type="email" name="userName">${user}<br>
        Password:<input type="password" name="password">${pass}<br>
        Name:<input type="text" name="name"><br>
        Surname:<input type="text" name="surname"><br>
        Birthday:<input type="datetime" name="birthday"><br>
        Gender:<input type="radio" name="gender"><br>
        Height:<input type="number" name="height"><br>
        Weight:<input type="number" name="weight"><br>
        Desired Weight:<input type="number" name="desired_weight"><br>
        BMI:<input type="number" name="bmi"><br>
        Notes:<input type="text" name="notes"><br>
        <input type="submit" value="Save">
    </form>

</body>
</html>
