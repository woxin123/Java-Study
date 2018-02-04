package com.example.myListener;

import com.example.Db.DbDao;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

@WebListener
public class OnlineListener implements ServletContextListener {
    // 如果用户超过10分钟没有访问，认为用户已经下线
    public final int MAX_MILLIS = 10 * 60 * 1000;
    // 应用启动时触发该方法
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        // 每5秒检查一次
        new javax.swing.Timer(1000 * 5, e -> {
            try {
                DbDao dd = new DbDao("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/javaee",
                        "root", "mengchen0705");
                ResultSet rs = dd.query("select * from online_inf", false);
                StringBuffer beRemove = new StringBuffer("(");
                while (rs.next()) {
                    // 如果距离上次访问超过了指定的时间
                    if ((System.currentTimeMillis() - rs.getLong(5)) > MAX_MILLIS) {
                        // 将需要删除的session Id 添加进来
                        beRemove.append("'");
                        beRemove.append(rs.getString(1));
                        beRemove.append("' , ");
                    }
                }
                // 如需要删除记录
                if (beRemove.length() > 3) {
                    beRemove.setLength(beRemove.length() - 3);
                    beRemove.append(")");
                    // 删除所有“超过时间为重新请求的记录”
                    dd.modify("delete from online_inf where session_id in " + beRemove.toString() + ";");
                }
                dd.closeConn();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
