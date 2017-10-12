package com.example.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbDao {
    private Connection conn;
    private String driver;
    private String url;
    private String user;
    private String pass;

    public DbDao() {
    }

    public DbDao(String driver, String url, String user, String pass) {
        this.driver = driver;
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    // 获取数据库的连接
    public Connection getConnection() throws Exception {
        if (conn == null) {
            Class.forName(this.driver);
            conn = DriverManager.getConnection(url, user, pass);
        }
        return conn;
    }

    // 插入记录
    public boolean insert(String sql, Object... args) throws Exception {
        PreparedStatement pstmt = getConnection().prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            pstmt.setObject(i + 1, args[i]);
        }
        if (pstmt.executeUpdate() != 1) {
            return false;
        }
        return true;
    }

    // 执行查询
    public ResultSet query(String sql, Object... args) throws Exception {
        PreparedStatement pstmt = getConnection().prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            pstmt.setObject(i + 1, args[i]);
        }
        return pstmt.executeQuery();
    }

    // 执行修改
    public void modify(String sql, Object...args) throws Exception {
        PreparedStatement pstmt = getConnection().prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            pstmt.setObject(i + 1, args[i]);
        }
        pstmt.executeUpdate();
        pstmt.close();
    }
    // 关闭数据库的连接
    public void closeConn() throws Exception {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }
}
