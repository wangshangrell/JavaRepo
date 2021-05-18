package com.itcast.practise02;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class QueryDemo {
    public static void main(String[] args) throws Exception {
        DriverManager.registerDriver(new Driver());
        Connection root = DriverManager.getConnection("jdbc:mysql://192.168.88.100:3306/DB1", "root", "123456");
        Statement statement = root.createStatement();
        String sql = "select * from student";
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String age = resultSet.getString("age");
            System.out.printf("id = %s ,name = %s ,age = %s\r\n",id,name,age);
        }
        resultSet.close();
        statement.close();
        root.close();
    }
}
