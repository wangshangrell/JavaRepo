package com.itcast.practise10;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class RunDemo {
    public static void main(String[] args) {
        String sql = "select * from student where id > ? and age = ?";
        new JDBCUtils() {
            @Override
            public void run(Statement sta) throws Exception {
                ResultSet resultSet = ((PreparedStatement) sta).executeQuery();
                while (resultSet.next()) {
                    String id = resultSet.getString("id");
                    String name = resultSet.getString("name");
                    String age = resultSet.getString("age");
                    System.out.printf("id = %s ,name = %s ,age = %s\r\n", id, name, age);
                }
                resultSet.close();
            }
        }.start(sql,"1","21");
    }
}
