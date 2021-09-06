package com.hqyj.hx.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;

/**
 * @author xfy
 * @create 2021-09-03 10:53
 */

/*
* 自定义过滤器来对登录用户的访问做控制
* url拦截策略：拦截所有，放过特点
*       放过的：
*               登录页面：登录操作本身（验证码）、所有静态资源
*
*
* */
@WebFilter("/*") //拦截所有url
public class loginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //浏览器要访问那个uri
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        String requestURI = request.getRequestURI();
        System.out.println(requestURI+"URI123456");
        //获取请求url种的queryString
        String queryString = request.getQueryString();
        System.out.println(queryString+"URL123456");
        //登录页面要放行
        if(requestURI.contains("/jsp/login.jsp") ||
        //静态资源放行
                requestURI.contains("/css/")||requestURI.contains("/js/")||
                //放行登录操作本身
                (requestURI.contains("/userController")&&queryString.contains("method=login"))

        ){
            //放行
            filterChain.doFilter(servletRequest,servletResponse);

        }else {
            //进一步判断用户是否登录 采用session共享的信息
            HttpSession session = request.getSession();
            Object loginUser = session.getAttribute("loginUser");
            if(loginUser!=null){
                //已经登录过了 放行
                filterChain.doFilter(servletRequest,servletResponse);
            }else {
                //没有登录过 请求转发到login.jsp 附上提示信息
                request.setAttribute("message","请先登录");
                request.getRequestDispatcher("/jsp/login.jsp").forward(servletRequest,servletResponse);

            }
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
