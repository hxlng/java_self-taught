package com.hqyj.hx.test;

import com.hqyj.hx.dao.UserDao;
import com.hqyj.hx.dao.impl.UserDaoImpl;
import com.hqyj.hx.pojo.PageData;
import com.hqyj.hx.pojo.User;
import com.hqyj.hx.service.UserService;
import com.hqyj.hx.service.impl.UserServiceImpl;
import org.junit.Test;

import java.util.List;

/**
 * @author xfy
 * @create 2021-09-01 9:25
 */
public class UserTest {
    @Test
    public void getAllTest(){
        UserDao userDao=new UserDaoImpl();
        UserServiceImpl userService = new UserServiceImpl(userDao);
        List<User> all = userService.getAll();
        for (User user : all) {
            System.out.println(user);
        }
    }

    @Test
    public void addOneTest(){
        UserDao userDao=new UserDaoImpl();
        UserServiceImpl userService = new UserServiceImpl(userDao);
        User user = new User();
        user.setName("翠花");
        user.setSex(1);
        user.setAddress("山东省");
        user.setPhone("189999999");
        user.setUsername("cuihua");
        user.setPassword("123456");
        boolean result = userService.addOne(user);
        System.out.println(result);

    }

    @Test
    public void removeOneTest(){
        UserDao userDao=new UserDaoImpl();
        UserServiceImpl userService = new UserServiceImpl(userDao);
        User user = new User();
        user.setId(8);
        boolean b = userService.removeOne(user);
        System.out.println(b);
    }

    @Test
    public void GetAllbyByPageTest(){
        UserDao userDao=new UserDaoImpl();
        UserServiceImpl userService = new UserServiceImpl(userDao);
        PageData<User> allByPage = userService.getAllByPage(0, 0);
        System.out.println(allByPage);
    }
    @Test
    public void getOneByIdTest(){
        UserDao userDao=new UserDaoImpl();
        UserServiceImpl userService = new UserServiceImpl(userDao);
        User oneById = userService.getOneById(6);
        System.out.println(oneById);
    }
    @Test
    public void editOneTest(){
        UserDao userDao=new UserDaoImpl();
        UserServiceImpl userService = new UserServiceImpl(userDao);
        User editUser = userService.getOneById(1);
        editUser.setName("张三111");
        editUser.setSex(1);
        boolean b = userService.editOne(editUser);
        System.out.println(b);


    }
}
