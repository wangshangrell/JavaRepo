package com.itcast.practise07_pool_util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RunDemo {
    public static void main(String[] args) throws SQLException {
        ConnPoolUtils.ConnectionBox box = new ConnPoolUtils.ConnectionBox();
        Statement statement = ConnPoolUtils.getStatement(box);
        String sql = "select * from student;";
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String age = resultSet.getString("age");
            System.out.printf("id = %s ,name = %s ,age = %s\r\n", id, name, age);
        }
        ConnPoolUtils.closeAll(resultSet,statement,box.conn);
    }
}
