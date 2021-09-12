package com.atguigu.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author xfy
 * @create 2021-09-01 12:51
 */
public abstract class BaseServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决post请求中文乱码问题
        //一定要在获取请求参数之前调用才有效
        req.setCharacterEncoding("UTF-8");
        //解决响应的中文乱码
        resp.setContentType("text/html;charset=UTF-8");
        String action = req.getParameter("action");
        /*if ("login".equals(action)) {
            login(req, resp);
        } else if ("regist".equals(action)) {
            regist(req,resp);
        }
*/
        //通过反射优化大量else if语句

        try {
            //获取action业务鉴别字符串，获取相应的业务 方法反射对象
            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            //调用目标业务 方法
            method.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);//把异常抛给Filter过滤器
        }
    }
}
