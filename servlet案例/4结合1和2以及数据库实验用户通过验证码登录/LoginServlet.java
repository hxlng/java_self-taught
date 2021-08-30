package com.hqyj.hx.exe;
import com.hqyj.hx.Bean.User;
import com.hqyj.hx.jdbc.jdbcUtils;
import com.hqyj.hx.jdbc.userDao;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.JDBCType;

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
        //获取验证码
        String checkCode = request.getParameter("checkCode");
        HttpSession session = request.getSession();
        String checkcode_session = (String)session.getAttribute("checkCode");
        //删除session中储存的验证码
        session.removeAttribute("checkCode");

        if(checkcode_session!=null && checkcode_session.equalsIgnoreCase(checkCode)){
            //验证码正确
            //在数据库里面查找是否有
            Connection conn = jdbcUtils.getConnection();
            boolean isexist = userDao.queryByUsername(conn, username);
            request.setAttribute("isexist",isexist);
            if(isexist){
                User user = userDao.queryByUsernameAndPassword(conn, username, password);
                if(user.getUsername()!=null&&user.getUsername().equals(username) && user.getPassword().equals(password)){
                    //登录成功
                    //存储用户信息
                    session.setAttribute("user",username);
                    //重定向到登录成功页面
                    response.sendRedirect(request.getContextPath()+"/success.jsp");
                }else {
                    //登录失败
                    //储存提示信息
                    request.setAttribute("login_error","密码错误！");
                    //转发到登录失败页面
                    request.getRequestDispatcher("/fail.jsp").forward(request,response);
                }
            }else{
                //登录失败
                //储存提示信息
                request.setAttribute("not_user","无该用户,请去注册！");
                //转发到登录失败页面
                request.getRequestDispatcher("/fail.jsp").forward(request,response);
            }
            //关闭数据库
         jdbcUtils.closeConnection(conn);

        }else{
            //验证码错误
            request.setAttribute("cc_error","验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }

    }
}
