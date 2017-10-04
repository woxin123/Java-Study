package com.example.myJDBC;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class LoginFrame {
    private final String PROT_FILE = "mysql.ini";
    private String driver;
    private String url;
    private String user;
    private String pass;
    // 登录的GUI组件
    private JFrame jf = new JFrame("登录");
    private JTextField userField = new JTextField(20);
    private JTextField passField = new JTextField(20);
    private JButton loginButton = new JButton("登录");

    public void init() throws Exception {
        // 使用Properties类加载属性文件
        Properties props = new Properties();
        props.load(new FileInputStream(PROT_FILE));
        driver = props.getProperty("driver");
        url = props.getProperty("url");
        user = props.getProperty("user");
        pass = props.getProperty("pass");
        // 加载驱动
        Class.forName(driver);
        // 为登录按钮添加监听事件
        loginButton.addActionListener(e->{
            // 登录成功则显示登录成功
            if (validate(userField.getText(), passField.getText())) {
                JOptionPane.showMessageDialog(jf, "登陆成功");
            } else {
                JOptionPane.showMessageDialog(jf, "登陆失败");

            }
        });
        jf.add(userField, BorderLayout.NORTH);
        jf.add(passField);
        jf.add(loginButton, BorderLayout.SOUTH);
        jf.pack();
        jf.setVisible(true);
    }

    private boolean validate(String userName, String userPass) {
        // 执行SQL查询
        String sql = "select * from jdbc_test " +
                "where jdbc_name='" + userName +
                "' and jdbc_desc='" + userPass + "'";
        System.out.println(sql);
        try (
                Connection conn = DriverManager.getConnection(url, user, pass);
                Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)
                ) {
            // 如果查询的ResultSet里有超过一条的记录，则显示登陆成功
            if (rs.next()) {
                return true;
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public static void main(String[] args) throws Exception {
        new LoginFrame().init();
    }
}
