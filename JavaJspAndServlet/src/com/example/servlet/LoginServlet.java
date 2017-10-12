package com.example.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;

@WebServlet(name = "login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    // 响应客户端的请求的方法

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String errMsg = "";
        // Servlet本身并不输出响应到客户端，因此将请求转发到视图页面
        RequestDispatcher rd;
        // 获取请求参数
        String username = req.getParameter("username");
        String pass = req.getParameter("pass");
        try {
            // Servlet本身并不执行任何的业务逻辑处理，它调用JavaBean处理用户请求
            DbDao dd = new DbDao("com.mysql.jdbc.Driver",
                    "jdbc:mysql://localhost:3306/test", "root", "mengchen0705");
            // 查询结果集
            ResultSet rs = dd.query("select pass from user_inf where username = ?", username);
            if (rs.next()) {
                // 用户名和密码匹配
                if (rs.getString("pass").equals(pass)) {
                    // 获取session对象
                    HttpSession session = req.getSession(true);
                    // 设置session属性，跟踪用户会话状态
                    session.setAttribute("name", username);
                    // 获取转发对象
                    rd = req.getRequestDispatcher("/welcome.jsp");
                    // 转发请求
                    rd.forward(req, resp);
                }
                else {
                    // 用户名和密码不匹配时
                    errMsg += "您的用户名密码不符合，请重新输入";
                }
            }
            else {
                // 用户名不存在时
                errMsg += "您的用户名不存在，请先注册";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 如果出错了，转发重新登录
        if (errMsg != null && !errMsg.equals("")) {
            rd = req.getRequestDispatcher("login.jsp");
            rd.forward(req, resp);
        }
    }
}
