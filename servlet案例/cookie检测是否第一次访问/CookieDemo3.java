package com.hqyj.hx.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

/**
 * @author xfy
 * @create 2021-08-30 9:13
 */

/*
* 显示上次访问时间
* */
@WebServlet("/cookieDemo3")
public class CookieDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应消息的编码
        response.setContentType("text/html;Charset=utf-8");
        //创建变量，假定用户第一次访问
        boolean isFirstVisit=true;
        //获取全部cookie
        Cookie[] cookies = request.getCookies();

        //判断是否为空
        if(cookies!=null){
            //遍历数组，找名叫lastVisit的cookie
            for (Cookie one : cookies) {
                String name = one.getName();
                if("lastVisit".equals(name)){
                    //不是第一次访问
                    isFirstVisit=false;
                    //获取该cookie的值，就是上次访问的时间
                    String value=one.getValue();
                    //对之前编码的字符串解码
                    String decodeString = URLDecoder.decode(value, "utf-8");
                    response.getWriter().write("欢迎回来，您上次访问的时间"+decodeString);
                }
            }
            //代码走到这来  做判断是否第一次访问
            if(isFirstVisit){
                response.getWriter().write("欢迎您，这是您第一次访问！");
            }
            //无论是否是第一访问，都要记录当前访问时间
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            //格式化当前时间
            String now = simpleDateFormat.format(new Date());

            //由于该字符串中有不合法的字符(空格)，我们对时间字符串使用url编码
                    //parm1 要编码的字符串  parm2  编码格式
            String encodeString = URLEncoder.encode(now, "utf-8");
            //创建一个记录当前时间的cookie
            Cookie cookie = new Cookie("lastVisit",encodeString);

            //保存cookie为一个月
            cookie.setMaxAge(3600*24*30);
            response.addCookie(cookie);
        }
    }
}
