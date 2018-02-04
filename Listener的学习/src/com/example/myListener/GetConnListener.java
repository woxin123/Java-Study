package com.example.myListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 检测应用启动关闭
 */
@WebListener
public class GetConnListener implements ServletContextListener {
    // 应用启动时，该方法被调用
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            // 取得该应用的ServletContext实例
            ServletContext application = servletContextEvent.getServletContext();
            // 从参数中获取数据库的驱动、
            String driver = application.getInitParameter("driver");
            String url = application.getInitParameter("url");
            String user = application.getInitParameter("user");
            String pass = application.getInitParameter("pass");
            // 注册驱动
            Class.forName(driver);
            // 获取数据库的连接
            Connection conn = DriverManager.getConnection(url, user, pass);
            // 将数据库连接设置成application范围内的属性
            application.setAttribute("conn", conn);
        } catch (Exception e) {
            System.out.println("数据库连接出现异常" + e.getMessage());
        }
    }
    // 应用被关闭时，该方法调用
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        // 取得该应用的ServletContext实例
        ServletContext application = servletContextEvent.getServletContext();
        Connection conn = (Connection) application.getAttribute("conn");
        // 关闭数据库
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
