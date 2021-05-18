package com.itcast.practise07_pool_util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.*;

public class ConnPoolUtils {
    private ConnPoolUtils() {
    }

    public static ComboPooledDataSource cpds = new ComboPooledDataSource();

    public static Connection getConnection() {
        try {
            return cpds.getConnection();
        } catch (Exception e) {
            return null;
        }
    }

    public static Statement getStatement(ConnectionBox box) {
        try {
            box.conn = getConnection();
            assert box.conn != null;
            return box.conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static PreparedStatement getPreparedStatement(String sql, ConnectionBox box) {
        try {
            box.conn = getConnection();
            assert box.conn != null;
            return box.conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    static class ConnectionBox {
        public Connection conn;
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
