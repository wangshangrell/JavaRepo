package com.itcast.practise03_jdbcutil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RunDemo {
    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        assert connection != null;
        Statement statement = connection.createStatement();
        String sql = "select * from student;";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String age = resultSet.getString("age");
            System.out.printf("id = %s ,name = %s ,age = %s\r\n", id, name, age);
        }
        JDBCUtils.closeAll(resultSet, statement, connection);
    }
}
