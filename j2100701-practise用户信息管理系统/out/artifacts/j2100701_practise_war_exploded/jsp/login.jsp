<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2021/9/3
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pintuer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
</head>
<body>
<div align="center">
    <div  class="margin" style="width: 300px">
        <form action="${pageContext.request.contextPath}/userController?method=login" method="post">
            <label class="control-label">用户账号</label>
            <input type="text" name="username" class="form-control" placeholder="请输入用户账号"/>
            <label class="control-label">用户密码</label>
            <input type="text" name="password" class="form-control" placeholder="请输入用户密码"/>
            <input type="submit" value="登录" class="button"/><br/>
            <span class="text-red margin">${requestScope.message}</span>
        </form>
    </div>
</div>
</body>
</html>
