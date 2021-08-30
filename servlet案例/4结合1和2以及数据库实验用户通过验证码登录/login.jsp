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
<style>
    div{
        color:red;
    }
</style>
<!--显示随机验证码和a标签-->
<script>
    //点击回调方法
    function changeCheckCode() {
        //更换图片验证码
        var img = document.getElementById("checkCodeImg");
        //创建一个时间对象
        var now=new Date();
        //在url加一个请求参数，让浏览器每次点击重新发送请求
        img.setAttribute("src","/Servlet_war_exploded/checkCodeServlet?time="+now.getTime());
    }
</script>

    <form action="/Servlet_war_exploded/loginServlet" method="get">
        用户：<input type="text" name="username"/><br/>
        密码：<input type="password" name="password"/><br/>
        验证码：<input type="text" name="checkCode"/><br>
        <img src="/Servlet_war_exploded/checkCodeServlet" id="checkCodeImg"><a href="#" onclick="changeCheckCode()">看不清楚？换一张</a><br/>
        <input type="submit" value="提交">
        <div><%=request.getAttribute("cc_error")==null?"":request.getAttribute("cc_error")%></div>
    </form>
</body>
</html>
