package com.itcast.practise02;

import java.sql.*;

public class DeleteDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.88.100:3306/DB1", "root", "123456");
        Statement statement = connection.createStatement();
        statement.execute("delete from student where id = 1");
        statement.close();
        connection.close();
    }
}
