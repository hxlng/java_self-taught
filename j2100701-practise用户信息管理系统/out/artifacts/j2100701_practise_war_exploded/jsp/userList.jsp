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
<div>
    <a class="button" href="${pageContext.request.contextPath}/jsp/userAdd.jsp">添加用户</a>
</div>

    <div class="margin">
        <table class="table">
            <thead>
            <tr>
                <td>编号</td>
                <td>姓名</td>
                <td>性别</td>
                <td>住址</td>
                <td>电话</td>
                <td>账户名</td>
                <td>操作</td>
            </tr>
            </thead>
            <tbody>
            <%--jstl的forEach标签做循环--%>
            <c:forEach items="${userLsit}" var="one">
                <tr>
                    <td>${one.id}</td>
                    <td>${one.name}</td>
                    <c:if test="${one.sex==0}"><td>男</td></c:if>
                    <c:if test="${one.sex==1}"><td>女</td></c:if>
                    <td>${one.address}</td>
                    <td>${one.phone}</td>
                    <td>${one.username}</td>
                    <td>
                        <a class="button" href="${pageContext.request.contextPath}/userController?method=removeOne&id=${one.id}">删除</a>
                        <a class="button" href="${pageContext.request.contextPath}/userController?method=editView&id=${one.id}">编辑</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
