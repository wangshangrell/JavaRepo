package com.itcast.practise05_prepare_util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RunDemo {
    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCPreUtils.getConnection();
        String sql = "select * from student where age = ? and name = ?";
        assert connection != null;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "18");
        preparedStatement.setString(2, "张三");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String age = resultSet.getString("age");
            System.out.printf("id = %s ,name = %s ,age = %s\r\n", id, name, age);
        }
        JDBCPreUtils.closeAll(resultSet, preparedStatement, connection);
    }
}
