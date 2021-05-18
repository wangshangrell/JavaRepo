package com.itcast.practise06_connection_pool;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo01 {
    public static void main(String[] args) throws SQLException {
        ComboPooledDataSource cpds = new ComboPooledDataSource(false);
        Connection connection = cpds.getConnection();
        String sql = "select * from student";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String age = resultSet.getString("age");
            System.out.printf("id = %s ,name = %s ,age = %s\r\n", id, name, age);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
