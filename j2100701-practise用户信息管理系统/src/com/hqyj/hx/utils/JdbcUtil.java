package com.hqyj.hx.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author xfy
 * @create 2021-09-01 8:56
 */
public class JdbcUtil {
    //创建一个properties集合
    private static Properties properties=new Properties();
    static {
        try {
            InputStream is = JdbcUtil.class.getResourceAsStream("jdbc.properties");
            //从文件中读取配置信息
            properties.load(is);
            //加载jdbc的驱动
            Class.forName(properties.getProperty("driver"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /*获取数据库连接对象*/
    public static Connection getConnection() throws SQLException {
       return DriverManager.getConnection(properties.getProperty("url"),
                properties.getProperty("username"),
                properties.getProperty("password"));
    }
}
