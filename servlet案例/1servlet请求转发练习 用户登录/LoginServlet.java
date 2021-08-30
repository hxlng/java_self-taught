package com.hqyj.hx.exe;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求转发练习
 * @author xfy
 * @create 2021-08-27 16:02
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if("张三".equals(username) && "123456".equals(password)){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/success.jsp");
            requestDispatcher.forward(request,response);
        }else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/fail.jsp");
            requestDispatcher.forward(request,response);
        }
    }
}
