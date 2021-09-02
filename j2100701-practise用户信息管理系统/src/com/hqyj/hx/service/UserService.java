package com.hqyj.hx.service;

import com.hqyj.hx.pojo.User;
import com.hqyj.hx.pojo.PageData;
import java.util.List;

/**
 * @author xfy
 * @create 2021-09-01 9:20
 */
public interface UserService {
    //获取全部用户数据
    List<User> getAll();

    //添加一个用户 true 成功
    boolean addOne(User user);

    //删除一个用户 true 成功
    boolean removeOne(User user);

    //分页查询所有的用户信息
    PageData<User> getAllByPage(int currentPage,int pageSize);

    //根据用户id查询信息
   User getOneById(int userId);
   //编辑一个用户的信息系
   boolean editOne(User user);
}
