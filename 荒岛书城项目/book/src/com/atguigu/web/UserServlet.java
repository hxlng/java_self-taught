package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.utils.WebUtils;
import com.google.code.kaptcha.servlet.KaptchaServlet;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author xfy
 * @create 2021-08-31 23:31
 */
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    protected void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数username
        String username=req.getParameter("username");
        //调用userService.existsUsername(username);
        boolean existsUsername = userService.existsUsername(username);
        //把返回的结果封装成map对象
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("existsUsername",existsUsername);
        Gson gson = new Gson();
        String json = gson.toJson(resultMap);
        resp.getWriter().write(json);
    }

    /**
     * 注销
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.销毁session中用户登录的信息（或者销毁session）
        req.getSession().invalidate();
        //2.重定向到首页（或登录页面）
        resp.sendRedirect(req.getContextPath());
    }


        /**
         * 处理登录的功能
         *
         * @param req
         * @param resp
         * @throws ServletException
         * @throws IOException
         */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //调用userService.login()登录处理业务
        User loginUser = userService.login(new User(null, username, password, null));
        if (loginUser == null) {
            //把错误信息，和回显的表单项信息，保存到request域中
            req.setAttribute("msg", "用户或密码错误！");
            req.setAttribute("username", username);
            //跳回登录页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            //登录成功
            //保存用户登录的信息到session域中
            req.getSession().setAttribute("user",loginUser);
            //跳到成功页面login_success.html
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }

    /**
     * 处理注册的功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取session中的验证码
        String token = (String)req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //删除Session中的验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        //1.获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());

        //2.检查 验证码是否正确 ====写死，验证码：abcde
        if (token!=null && token.equalsIgnoreCase(code)) {
            //正确
            //3.检查 用户名是否可用
            if (userService.existsUsername(username)) {
                System.out.println("用户名[" + username + "]已存在!");
                //把回显信息保存到request域中
                req.setAttribute("msg", "用户名已存在！");
                req.setAttribute("username", username);
                req.setAttribute("email", email);

                //不可用 跳回到注册页面
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {

                //可用 调用service保存到数据库
                //跳转到注册成功页面regist_success.html
                userService.registUser(new User(null, username, password, email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }

        } else {
            //把回显信息保存到request域中
            req.setAttribute("msg", "验证码错误！");
            req.setAttribute("username", username);
            req.setAttribute("email", email);
            System.out.println("验证码[" + code + "]错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }

    }
}
