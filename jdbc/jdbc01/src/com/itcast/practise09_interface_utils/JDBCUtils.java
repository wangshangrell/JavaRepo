package com.itcast.practise09_interface_utils;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public abstract class JDBCUtils {

    public abstract void run(Statement sta) throws Exception;

    public final String url;
    public final String username;
    public final String password;
    public final String driverpath;

    private Connection conn;

    public JDBCUtils() {
        Properties properties = new Properties();
        ClassLoader classLoader = com.itcast.practise03_jdbcutil.JDBCUtils.class.getClassLoader();
        try {
            properties.load(classLoader.getResourceAsStream("config/conf.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
        driverpath = properties.getProperty("driverPath");
        try {
            Class.forName(driverpath);
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            Statement statement = conn.createStatement();
            run(statement);
            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
