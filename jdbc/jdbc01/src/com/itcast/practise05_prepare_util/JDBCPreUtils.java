package com.itcast.practise05_prepare_util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCPreUtils {
    private JDBCPreUtils() {
    }

    public static String url;
    public static String user;
    public static String passwd;
    public static String driverPath;

    static {
        ClassLoader classLoader = JDBCPreUtils.class.getClassLoader();
        InputStream resourceStream = classLoader.getResourceAsStream("config/conf.properties");
        Properties properties = new Properties();
        try {
            properties.load(resourceStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        url = properties.getProperty("url");
        user = properties.getProperty("username");
        passwd = properties.getProperty("password");
        driverPath = properties.getProperty("driverPath");
        try {
            Class.forName(driverPath);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, passwd);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void closeAll(ResultSet rs, Statement sta, Connection conn) {
        try {
            close(rs, sta, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeAll(Statement sta, Connection conn) {
        try {
            close(sta, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void close(ResultSet rs, Statement sta, Connection conn) throws SQLException {
        rs.close();
        sta.close();
        conn.close();
    }

    private static void close(Statement sta, Connection conn) throws SQLException {
        sta.close();
        conn.close();
    }
}
