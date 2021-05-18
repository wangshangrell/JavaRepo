package com.itcast.practise02;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateDemo {
    public static void main(String[] args) throws Exception {
        DriverManager.registerDriver(new Driver());
        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.88.100:3306/DB1","root","123456");
        Statement statement = connection.createStatement();
        String sql = "update student set name = '王五' where id = 4";
        int i = statement.executeUpdate(sql);
        System.out.printf("共更新了%d条数据",i);
        statement.close();
        connection.close();
    }
}
