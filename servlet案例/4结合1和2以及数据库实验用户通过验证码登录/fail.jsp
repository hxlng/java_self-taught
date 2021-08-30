<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2021/8/27
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录失败</title>
</head>
<body>
<h1><%=(boolean)request.getAttribute("isexist")==true?"":request.getAttribute("not_user")%></h1>
<h1><%=request.getAttribute("login_error")==null?"":request.getAttribute("login_error")%></h1>
</body>
</html>
