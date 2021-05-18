package com.itcast.practise08_pool_util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class RunDemo {
    public static void main(String[] args) throws Exception {
        Connection connection = ConnPoolUtils.getConnection();
        assert connection != null;
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();
        String sql = "insert into student values(0,'赵六',21)";
        statement.execute(sql);
        connection.commit();
        sql = "select * from student";
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String age = resultSet.getString("age");
            System.out.printf("id = %s ,name = %s ,age = %s\r\n", id, name, age);
        }
        ConnPoolUtils.closeAll(resultSet,statement,connection);
    }
}
