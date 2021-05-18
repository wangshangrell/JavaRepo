package com.itcast.practise03_jdbcutil;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private JDBCUtils() {
    }

    public static String url;
    public static String username;
    public static String password;
    public static String driverpath;

    static {
        Properties properties = new Properties();
        ClassLoader classLoader = JDBCUtils.class.getClassLoader();
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
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void closeAll(ResultSet rs, Statement sta, Connection conn) {
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            sta.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeAll(Statement sta, Connection conn) {
        try {
            sta.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
