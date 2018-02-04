package com.example.myListener;

import com.example.Db.DbDao;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * ServletRequestListener:用于监听用户请求的到达与结束        application范围内的
 * ServletRequestAttributeListener：用于检测用户请求属性值的变化       request范围内的
 */
@WebListener
public class RequestListener implements ServletRequestListener {


    // 当用户请求到达是触发该方法
    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
        HttpSession session = request.getSession();
        // 获取session ID
        String sessionId = session.getId();
        // 获取访问的IP和正在访问的页面
        String ip = request.getRemoteAddr();
        String page = request.getRequestURI();
        String user = (String)session.getAttribute("user");
        // 为登录的用户当游客处理
        user = (user == null) ? "游客" : user;
        try {
            DbDao dd = new DbDao("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/javaee",
                    "root", "mengchen0705");
            ResultSet rs = dd.query("select * from online_inf where session_id=?", true, sessionId);
            // 如果该用户的ID存在，表明是旧的会话
            if (rs.next()) {
                // 更新记录
                Statement stmt = dd.getConnection().createStatement();
                stmt.executeUpdate("update online_inf set page='" + page + "' where session_id='" + sessionId + "';");
                stmt.executeUpdate("update online_inf set online_time=" + System.currentTimeMillis() + " where session_id='" + sessionId + "';");
                rs.close();
            } else {
                // 插入该用户的信息
                dd.insert("insert into online_inf value(?, ?, ?, ?, ?)",
                        sessionId, user, ip, page, System.currentTimeMillis());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 当用户请求被结束、被销毁是触发该方法
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

    }


}
