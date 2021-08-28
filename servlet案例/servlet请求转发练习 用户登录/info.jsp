<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2021/8/27
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/Servlet_war_exploded/loginServlet" method="get">
        用户：<input type="text" name="username"/><br/>
        密码：<input type="password" name="password"/><br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
