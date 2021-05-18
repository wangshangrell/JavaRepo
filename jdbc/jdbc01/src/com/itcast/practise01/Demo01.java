package com.itcast.practise01;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class Demo01 {
    public static void main(String[] args) throws SQLException {
        DriverManager.registerDriver(new Driver());

        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.88.100:3306/DB1","root","123456");
        Statement statement = connection.createStatement();
//        String sql = "insert into student values(3,'张三',18),(4,'李四',19)";
        String sql = "select * from student";
        statement.execute(sql);
//        connection.commit();
        ResultSet resultSet = statement.getResultSet();
        while(resultSet.next()){
            System.out.print("id:"+resultSet.getInt("id")+" ");
            System.out.print("name:"+resultSet.getString("name")+" ");
            System.out.print("age:"+resultSet.getInt("age")+" ");
            System.out.println();
        }
    }
}
