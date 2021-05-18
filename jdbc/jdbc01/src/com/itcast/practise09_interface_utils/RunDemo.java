package com.itcast.practise09_interface_utils;


import java.sql.ResultSet;
import java.sql.Statement;

public class RunDemo {
    public static void main(String[] args) {
        new JDBCUtils(){
            @Override
            public void run(Statement sta) throws Exception {
                ResultSet resultSet = sta.executeQuery("select * from student");
                while (resultSet.next()) {
                    String id = resultSet.getString("id");
                    String name = resultSet.getString("name");
                    String age = resultSet.getString("age");
                    System.out.printf("id = %s ,name = %s ,age = %s\r\n", id, name, age);
                }
                resultSet.close();
            }
        }.start();
    }
}
