<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2021/8/31
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<a href="${pageContext.request.contextPath}/userController?method=getAll">展示用户列表</a><br/>
<a href="${pageContext.request.contextPath}/userController?method=getAllByPage">分页展示用户列表</a>


  </body>
</html>
