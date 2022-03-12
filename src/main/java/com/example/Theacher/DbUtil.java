package com.example.Theacher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DbUtil {
    //读配置
    public static Connection getConnection() throws Exception {
        //第1步：注册驱动 (仅仅做一次)
        Class.forName("com.mysql.cj.jdbc.Driver");
        //第2步：建立连接(Connection)
        Properties properties=new Properties();
        properties.load(DbUtil.class.getClassLoader().getResourceAsStream("jdbc.properties"));
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        System.out.println(url);
        return DriverManager.getConnection(url,username,password);
    }
}
