package com.atguigu.test;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import org.junit.Test;


/**
 * @author xfy
 * @create 2021-08-27 23:30
 */
public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {

        if (userDao.queryUserByUsername("wzg168") == null ){
            System.out.println("用户名可用！");
        } else {
            System.out.println("用户名已存在！");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if ( userDao.queryUserByUsernameAndPassword("admin","admin1234") == null) {
            System.out.println("用户名或密码错误，登录失败");
        } else {
            System.out.println("查询成功");
        }
    }

    @Test
    public void saveUser() {
        System.out.println( userDao.saveUser(new User(null,"wzg168", "123456", "wzg168@qq.com")) );
    }
}