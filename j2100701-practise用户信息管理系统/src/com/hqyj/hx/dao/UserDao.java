package com.hqyj.hx.dao;

import com.hqyj.hx.pojo.User;

import java.util.List;

/**
 * @author xfy
 * @create 2021-08-31 16:13
 */
/*
该dao对象  做数据库user表中的数据增删改查
* */
public interface UserDao {
    /**
     * 查询所有用户信息
     * @return
     */
    List<User> queryAll();

    /**
     * 通过id查询用户信息
     * @param id
     * @return
     */
   User queryOneById(int id);

    /**
     * 添加一个用户的信息
     * @param user
     * @return 返回影响的行数
     */
    int insetOne(User user);

    /**
     * 删除一个用户
     * @param user
     * @return
     */
    int deleteOne(User user);

    /**
     * 分页查询全部用户的数据
     * @param startIndex 开始索引
     * @param pageSize 查询多少条
     * @return
     */
    List<User> queryByPage(int startIndex,int pageSize);

    /**
     *
     * @return 获取全部用户的记录数
     */
    int countAll();

    //更新一个用户的信息 ,使用useId来识别，其他属性来更新
    int updateOne(User user);

    //账户和密码查询用户
    User queryByUsernameAndPassword(String username,String password);

}
