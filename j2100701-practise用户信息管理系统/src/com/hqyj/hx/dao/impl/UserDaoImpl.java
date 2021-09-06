package com.hqyj.hx.dao.impl;

import com.hqyj.hx.dao.UserDao;
import com.hqyj.hx.pojo.User;
import com.hqyj.hx.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xfy
 * @create 2021-08-31 16:18
 */
/*
* 使用jdbc实现user数据的增删改查
* */
public class UserDaoImpl implements UserDao {

    @Override
    public List<User> queryAll() {
        ArrayList<User> userList = new ArrayList<>();

        String sql="select id ,`name`,sex,address,phone,email,`username`,`password`,`deleted`,`updatetime` from `user`";
        //通过JdbcUtil获取数据库连接
        try(Connection conn = JdbcUtil.getConnection(); //需要关闭可以放在try()里面
            PreparedStatement ps = conn.prepareStatement(sql);
            //获得结果集
           ResultSet rs=ps.executeQuery()){
            //遍历结果集
            while(rs.next()){
                User user=new User(rs.getInt("id"),rs.getString("name"),
                        rs.getInt("sex"),rs.getString("address"),rs.getString("phone"),rs.getString("email"),
                        rs.getString("username"),rs.getString("password"),
                        rs.getInt("deleted"),rs.getTimestamp("updatetime"));
                userList.add(user);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return userList;
    }

    @Override
    public User queryOneById(int id) {
        String sql = "select id,name,sex,address,phone,email,username,password,deleted,updatetime from user where id=?";
        //通过JdbcUtil获取数据库连接
        try(Connection connection = JdbcUtil.getConnection();
            //获取PreparedStatement对象
            PreparedStatement ps = connection.prepareStatement(sql);){
            //填充占位符
            ps.setInt(1,id);
            //执行结果集
            try(ResultSet rs = ps.executeQuery()) {
                //遍历结果集
                if(rs.next()) {
                    //将user表的数据，封装成User对象
                    User user = new User(rs.getInt("id"), rs.getString("name"),
                            rs.getInt("sex"), rs.getString("address"),
                            rs.getString("phone"), rs.getString("email"),
                            rs.getString("username"), rs.getString("password"),
                            rs.getInt("deleted"), rs.getTimestamp("updatetime"));
                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public int insetOne(User user) {
        String sql="insert into user (`name`,sex,address,phone,email,`username`,`password`) values(?,?,?,?,?,?,?)";
        try(Connection connection = JdbcUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);){
            //设置占位符
            ps.setString(1,user.getName());
            ps.setInt(2,user.getSex());
            ps.setString(3,user.getAddress());
            ps.setString(4,user.getPhone());
            ps.setString(5,user.getEmail());
            ps.setString(6,user.getUsername());
            ps.setString(7,user.getPassword());

            int affectedRows = ps.executeUpdate();
            return affectedRows;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteOne(User user) {
        String sql="delete from user where id=?";
        try(Connection connection = JdbcUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);){
            //设置占位符
            ps.setInt(1,user.getId());
            int affectedRows = ps.executeUpdate();
            return affectedRows;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<User> queryByPage(int startIndex, int pageSize) {
        List<User> userList = new ArrayList<>();
        //limit分页查询
        String sql = "select id,name,sex,address,phone,email,username,password,deleted,updatetime from user limit ?,?";
        //通过JdbcUtil获取数据库连接
        try(Connection connection = JdbcUtil.getConnection();
            //获取PreparedStatement对象
            PreparedStatement ps = connection.prepareStatement(sql);){
            //填充占位符
            ps.setInt(1,startIndex);
            ps.setInt(2,pageSize);
            //执行结果集
            try(ResultSet rs = ps.executeQuery()) {
                //遍历结果集
                while (rs.next()) {
                    //将user表的数据，封装成User对象
                    User user = new User(rs.getInt("id"), rs.getString("name"),
                            rs.getInt("sex"), rs.getString("address"),
                            rs.getString("phone"), rs.getString("email"),
                            rs.getString("username"), rs.getString("password"),
                            rs.getInt("deleted"), rs.getTimestamp("updatetime"));
                    //添加到user对象到集合
                    userList.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //返回用户列表
        return userList;
    }

    @Override
    public int countAll() {
        String sql="select count(id) cnt from user";
        try(Connection connection=JdbcUtil.getConnection();
        PreparedStatement ps=connection.prepareStatement(sql);
        ResultSet rs=ps.executeQuery()){
            if(rs.next()){
                int count=rs.getInt("cnt");
                return  count;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateOne(User user) {
        String sql="update user set name=?,sex=?,address=?,phone=?,email=?,password=? where id=?";
        try(Connection connection=JdbcUtil.getConnection();
        PreparedStatement ps=connection.prepareStatement(sql)){
            ps.setString(1,user.getName());
            ps.setInt(2,user.getSex());
            ps.setString(3,user.getAddress());
            ps.setString(4,user.getPhone());
            ps.setString(5,user.getEmail());
            ps.setString(6,user.getPassword());
            ps.setInt(7,user.getId());
            int affectedRows = ps.executeUpdate();
            return affectedRows;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public User queryByUsernameAndPassword(String username, String password) {
        //limit分页查询
        String sql = "select id,name,sex,address,phone,email,username,password,deleted,updatetime from user where username=? and password=?";
        //通过JdbcUtil获取数据库连接
        try(Connection connection = JdbcUtil.getConnection();
            //获取PreparedStatement对象
            PreparedStatement ps = connection.prepareStatement(sql);){
            //填充占位符
            ps.setString(1,username);
            ps.setString(2,password);
            //执行结果集
            try(ResultSet rs = ps.executeQuery()) {
                //遍历结果集
                    if(rs.next()) {
                    //将user表的数据，封装成User对象
                    User user = new User(rs.getInt("id"), rs.getString("name"),
                            rs.getInt("sex"), rs.getString("address"),
                            rs.getString("phone"), rs.getString("email"),
                            rs.getString("username"), rs.getString("password"),
                            rs.getInt("deleted"), rs.getTimestamp("updatetime"));
                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //返回用户列表
        return null;
    }
}
