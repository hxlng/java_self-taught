<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2021/8/27
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
<h1><%=request.getSession().getAttribute("user")%>,欢迎您</h1>
</body>
</html>
