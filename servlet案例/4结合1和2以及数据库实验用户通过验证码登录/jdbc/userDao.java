package com.hqyj.hx.jdbc;

import com.hqyj.hx.Bean.User;
import org.junit.Test;

import java.sql.*;

/**
 * @author xfy
 * @create 2021-08-30 19:38
 */
public class userDao {
    /**
     * 用户存在返回turn
     * @param conn
     * @param args
     * @return
     */
    public static boolean queryByUsername(Connection conn,Object ...args){
        String sql="SELECT username,`password` FROM `user` WHERE username=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

//    @Test
//    public void t(){
//        Connection conn = jdbcUtils.getConnection();
//        boolean w = queryByUsername(conn, "zhangsan");
//        System.out.println(w);
//    }

public static User queryByUsernameAndPassword(Connection conn,Object ...args){
    String sql="SELECT username,`password` FROM `user` WHERE username=? and password=?";
    String username = null;
    String password = null;
    try {
        PreparedStatement ps = conn.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            ps.setObject(i+1,args[i]);
        }
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            username = rs.getString(1);
            password = rs.getString(2);
        }
    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }
    User user = new User(username,password);
    return user;
    }

}
