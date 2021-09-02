<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2021/9/1
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%--${pageContext.request.contextPath}获取虚拟路径--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pintuer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
</head>
<body>
<div class="margin" style="width: 400px">
    <form action="${pageContext.request.contextPath}/userController?method=addOne" method="post">
        <label class="control-label">姓名</label>
        <input type="text" name="name" class="form-control" placeholder="请输入用户姓名"/>

        <label class="control-label">性别</label>
        <select name="sex" class="form-control">
            <option value="0">男</option>
            <option value="1">女</option>
        </select>

        <label class="control-label">住址</label>
        <input type="text" name="address" class="form-control" placeholder="请输入用户住址"/>
        <label class="control-label">电话</label>
        <input type="text" name="phone" class="form-control" placeholder="请输入用户电话"/>
        <label class="control-label">邮件</label>
        <input type="text" name="email" class="form-control" placeholder="请输入用户邮件"/>
        <label class="control-label">账号名</label>
        <input type="text" name="username" class="form-control" placeholder="请输入用户账号名"/>
        <label class="control-label">密码</label>
        <input type="text" name="password" class="form-control" placeholder="请输入用户密码"/>
        <br/>
        <input type="submit" value="添加" class="button"/>
        <span class="text-red">${requestScope.message}</span>
    </form>
</div>
</body>
</html>
