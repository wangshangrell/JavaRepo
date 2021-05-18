package com.itcast.practise02;


import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class InsertDemo {
    public static void main(String[] args) throws SQLException {
        DriverManager.registerDriver(new Driver());
        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.88.100:3306/DB1","root","123456");
        Statement statement = connection.createStatement();
        String sql = "insert into student values(1,'刘亦菲',17)";
        statement.execute(sql);
        statement.close();
        connection.close();
    }
}
