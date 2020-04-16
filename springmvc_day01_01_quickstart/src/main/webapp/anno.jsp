<%--
  Created by IntelliJ IDEA.
  User: zhengwen
  Date: 2020/4/15
  Time: 8:49 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>常用的注解</h3>

    <a href="anno/testRequestParam?name=哈哈">RequestParam</a>

    <br>

    <form action="anno/testRequestBody" method="post">
        用户姓名：<input type="text" name="username"><br>
        用户年龄：<input type="text" name="age"><br>
        <input type="submit" value="提交"><br>
    </form>

    <br>

    <a href="anno/testPathVariable/29">PathVariable注解</a>

    <hr>

    <a href="anno/testRequestHeader">RequestHeader注解</a>

    <br>

    <a href="anno/testCookieValue">CookieValue注解</a>

    <br>

    <form action="anno/testModelAttribute" method="post">
        用户姓名：<input type="text" name="uname"><br>
        用户年龄：<input type="text" name="age"><br>
        <input type="submit" value="提交"><br>
    </form>

    <br>

    <a href="anno/testSessionAttributes">SessionAttributes注解</a>
    <br>

    <a href="anno/getSessionAttributes">getSessionAttributes注解</a>
    <br>

    <a href="anno/delSessionAttributes">delSessionAttributes注解</a>
</body>
</html>
