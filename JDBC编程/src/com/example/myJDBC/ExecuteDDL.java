package com.example.myJDBC;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class ExecuteDDL {
    private String driver;
    private String url;
    private String user;
    private String pass;

    public void initParam(String paramFile) throws IOException {
        // 使用Properties类加载属性文件
        Properties props = new Properties();
        props.load(new FileInputStream(paramFile));
        driver = props.getProperty("driver");
        url = props.getProperty("url");
        user = props.getProperty("user");
        pass = props.getProperty("pass");
    }

    public void createTable(String sql) throws Exception {
        // 加载驱动
        Class.forName(driver);
        try (
                // 获取数据连接
                Connection coon = DriverManager.getConnection(url, user, pass);
                // 使用Connection创建一个Statement对象
                Statement stmt = coon.createStatement()
        ) {
            // 执行DDL语句，创建数据表
            stmt.executeUpdate(sql);
        }
    }
    public static void main(String[] args) throws Exception{
        ExecuteDDL ed = new ExecuteDDL();
        ed.initParam("mysql.ini");
        ed.createTable("create table jdbc_test " +
                "( jdbc_id int auto_increment primary key, " +
                "jdbc_name varchar(255), " +
                "jdbc_desc text);");
        System.out.println("-----建表成功-----");
    }
}
