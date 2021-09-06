package com.hqyj.hx.controller;

import com.hqyj.hx.pojo.PageData;
import com.hqyj.hx.pojo.User;
import com.hqyj.hx.service.UserService;
import com.sun.org.apache.regexp.internal.RE;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.util.List;

/**
 *写多个控制器方法，每个控制器方法实现一个请求响应的业务
 * @author xfy
 * @create 2021-09-01 10:38
 */
@WebServlet("/userController")
public class UserController extends BaseController {
    //获取全部用户
    public String getAll(HttpServletRequest request, HttpServletResponse response){
        //1.获取请求参数
        //2.调用业务层去实现业务功能，拿到模型数据
        List<User> allUsers =userService.getAll();
        request.setAttribute("userLsit",allUsers);
        //3.将数据交给JSP(视图)做展示
        return "/jsp/userList.jsp";
    }
    //删除一个用户
    public String delete(HttpServletRequest request, HttpServletResponse response){
        //1.获取请求参数
        //2.调用业务层去实现业务功能，拿到模型数据
        //3.将数据交给JSP(视图)做展示
        System.out.println("delete...");
        return "redirect:http://www.baidu.com";
    }


    //获取一个用户
    public String getOne(HttpServletRequest request, HttpServletResponse response){
        //1.获取请求参数
        //2.调用业务层去实现业务功能，拿到模型数据
        //3.将数据交给JSP(视图)做展示
        System.out.println("getOne...");
        return "forward:/index.jsp";
    }
     //添加一个用户
    public String addOne(HttpServletRequest request, HttpServletResponse response){
        System.out.println("addOne...");
        //1.获取请求参数 封装对象
        User user = createUser(request);
        //2.调用业务层去实现业务功能，拿到模型数据
        boolean result = userService.addOne(user);
        if(result){
            //3.将数据交给JSP(视图)做展示
            String contextPath = request.getContextPath();
            return "redirect:"+contextPath+"/userController?method=getAll";

        }else {

            //添加失败 跳转到添加页面
            request.setAttribute("message","用户添加失败");
            return "forward:/jsp/userAdd.jsp";
        }

    }

    //删除一个用户
    public String removeOne(HttpServletRequest request, HttpServletResponse response){
        System.out.println("removeOne...");
        //1.获取请求参数 封装对象
        User user = new User();
        String idString = request.getParameter("id");
        int id=0;
        try {
            id = Integer.valueOf(idString);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        user.setId(id);
        //2.调用业务层去实现业务功能，拿到模型数据
        boolean result = userService.removeOne(user);
        if(result){
            //3.将数据交给JSP(视图)做展示
            String contextPath = request.getContextPath();
            return "redirect:"+contextPath+"/userController?method=getAll";

        }else {
            //删除失败
            return "forward:/index.jsp";
        }

    }
  private User createUser(HttpServletRequest request){
     //从请求对象中获取浏览器发来的所有的参数
     int id=0;
      String idString = request.getParameter("id");
      try {
          id = Integer.valueOf(idString);
      } catch (NumberFormatException e) {
          e.printStackTrace();
      }
      String name = request.getParameter("name");
      String sexString = request.getParameter("sex");
      //sex参数转型
      int sex=0;
      try {
          sex = Integer.valueOf(sexString);
      } catch (NumberFormatException e) {
          e.printStackTrace();
      }
      String address = request.getParameter("address");
      String phone = request.getParameter("phone");
      String email = request.getParameter("email");
      String username = request.getParameter("username");
      String password = request.getParameter("password");
      User user = new User(id,name,sex,address,phone,email,username,password,
              0,null);
      return user;
  }

  public String getAllByPage(HttpServletRequest request,HttpServletResponse response){
      //1.获取请求参数
      int currentPage=0;
      String currentPageString = request.getParameter("currentPage");
      try {
          currentPage = Integer.valueOf(currentPageString);
      } catch (NumberFormatException e) {
          e.printStackTrace();
      }
      int pageSize=0;
      String pageSizeString = request.getParameter("pageSize");
      try {
          pageSize = Integer.valueOf(pageSizeString);
      } catch (NumberFormatException e) {
          e.printStackTrace();
      }
      //2.调用业务层去实现业务功能，拿到模型数据
      PageData<User> allByPage = userService.getAllByPage(currentPage, pageSize);
      //使用session对象来共享 页码和每页记录数
      HttpSession session = request.getSession();
      session.setAttribute("currentPage",allByPage.getCurrentPage());
      session.setAttribute("pageSize",allByPage.getPageSize());
      //3.将数据交给JSP(视图)做展示
      request.setAttribute("pageData",allByPage);
      return "/jsp/userListByPage.jsp";
  }

  //用户点击编辑按钮后进入编辑界面的控制器方法
    public String editView(HttpServletRequest request,HttpServletResponse response){
        //1.获取请求参数
        String idString = request.getParameter("id");
        int id=0;
        try {
            id = Integer.valueOf(idString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //2.调用服务层执行用户信息的查询
        User one = userService.getOneById(id);

        //3.跳转到用户编辑的页面，同时共享该用户的信息
        request.setAttribute("editUser",one);
        if(one==null){
            request.setAttribute("message","编辑信息获取失败");
        }
        return "/jsp/userEdit.jsp";
    }

    //执行用户编辑操作，跳转到用户的列表页面
    public String editDone(HttpServletRequest request,HttpServletResponse response){
        //1、获取请求参数,封装对象
        User editUser = createUser(request);
        //2、调用业务层，执行更新操作，拿到结果
        boolean result = userService.editOne(editUser);
        //3、根据结果跳转页面
        if(result){
            //从session域中获取进入用户分页时共享的页码和每页记录数
            HttpSession session = request.getSession();
            int currentPage = (int)session.getAttribute("currentPage");
            int pageSize = (int)session.getAttribute("pageSize");
            //如果成功，重定向到用户列表页面
            String contextPath = request.getContextPath();
            return "redirect:" + contextPath + "/userController?method=getAllByPage&currentPage="+currentPage + "&pageSize=" + pageSize;
        }else{
            //如果失败，请求转发到用户编辑页面
            request.setAttribute("editUser",editUser);
            request.setAttribute("message", "用户编辑失败");
            return "/jsp/userEdit.jsp";
        }
    }

    public String login(HttpServletRequest request,HttpServletResponse response){
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User loginUser = userService.login(username, password);

        if(loginUser!=null){
            //在session域共享登录用户信息
            HttpSession session = request.getSession();
            session.setAttribute("loginUser",loginUser);
            //重定向到首页

            String contextPath=request.getContextPath();
            return "redirect:"+contextPath+"/index.jsp";
        }else {
            //登录失败
            //请求转发
            request.setAttribute("message","用户名或密码错误");
            return "/jsp/login.jsp";
        }

    }

}
