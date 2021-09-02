package com.hqyj.hx.controller;

import com.hqyj.hx.dao.UserDao;
import com.hqyj.hx.dao.impl.UserDaoImpl;
import com.hqyj.hx.pojo.User;
import com.hqyj.hx.service.UserService;
import com.hqyj.hx.service.impl.UserServiceImpl;
import com.sun.xml.internal.ws.server.sei.TieHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * @author xfy
 * @create 2021-09-01 11:01
 */
/*
* 接收请求参数method ,使用method的值识别它的子类中的方法
* 有，就调用该方法，获取到返回值 返回值，类型为字符串，定义为资源跳转的方法
* 1.forward:资源路径
* 2.redirect：资源路径
* 3.资源路径
* */
public class BaseController  extends HttpServlet {
    private static UserDao userDao=new UserDaoImpl();
    protected UserService userService=new UserServiceImpl(userDao);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //请求参数编码
        req.setCharacterEncoding("utf-8");
        //获取method参数 就是子类方法的名称
        String method = req.getParameter("method");

        //判空
        if(method==null||method.isEmpty()){
            throw new ServletException("请求的method参数不正确");
        }

        //拿到当前类对象
        Class aClass = this.getClass();
        Method controllerMethod=null;
        try {
            //通过类对象获取方法对象
            controllerMethod = aClass.getDeclaredMethod(method, HttpServletRequest.class, HttpServletResponse.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw new ServletException("请求的控制器方法不存在");
        }
        //执行控制器方法
            String result=null;
        try {
            result = (String)controllerMethod.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("控制器方法执行异常");
        }

        //result字符串判空
        if(result==null||result.isEmpty()){
            throw new ServletException("控制方法返回值有误");
        }
        System.out.println(result);

        //查找冒号
        int index=result.indexOf(":");
        if(index>-1){
            //找到冒号了
            //获取forward还是redirect
            String option = result.substring(0, index);
            String path=result.substring(index+1);
            //简单处理字符串
            if(option.toLowerCase().startsWith("f")){
                //请求转发
                req.getRequestDispatcher(path).forward(req,resp);
            }else if(option.toLowerCase().startsWith("r")){
                //重定向
                resp.sendRedirect(path);
            }else {
                //写错了
                throw new ServletException("该资源跳转方式目前不支持");
            }
        }else {
            //没有冒号
            //使用请求转发。处理result表示的资源路径
            req.getRequestDispatcher(result).forward(req,resp);
        }

    }
}
