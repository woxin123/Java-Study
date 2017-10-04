package com.example.myJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 1. 加载数据库驱动
 * 2. 通过DriverManager获取数据库连接
 * 3. 通过Connection对象创建Statement对象。
 * 4. 使用Statement执行MySQL语句。
 * 5. 操作结果集。
 * 6. 回收数据库资源，包括关闭ResultSet、Statement和Connection等资源。
 */
public class CoonMySQL {
    public static void main(String[] args) throws Exception {
        // 1. 加载数据库驱动
        Class.forName("com.mysql.jdbc.Driver");
        try (
                // 2. 通过DriverManager获取数据库连接
                Connection coon = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/select_test", "root", "mengchen0705");
                // 3. 通过Connection对象创建Statement对象。
                Statement stmt = coon.createStatement();
                // 4. 使用Statement执行MySQL语句。
                // 5. 操作结果集。
                ResultSet rs = stmt.executeQuery("select s.*, teacher_name"
                        + " from student_table s, teacher_table t"
                        + " where t.teacher_id = s.java_teacher")
        ) {
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "\t"
                        + rs.getString(2) + '\t'
                        + rs.getString(3) + "\t"
                        + rs.getString(4));

            }
        }
    }
}
