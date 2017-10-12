package com.example.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "testServlet", urlPatterns = "/testServlet"
            , initParams = {
        @WebInitParam(name="driver", value = "com.mysql.jdbc.Driver"),
        @WebInitParam(name="url", value = "jdbc:mysql://localhost:3306/test"),
        @WebInitParam(name="user", value = "root"),
        @WebInitParam(name="pass", value = "mengchen0705")
})
public class TestServlet extends HttpServlet {
    // 重写init方法

    @Override
    public void init(ServletConfig config) throws ServletException {
        // 重写该方法，应该首先调用父类的init方法
        super.init(config);

    }
    // 响应客户请求的方法

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // 获取ServletConfig对象
            ServletConfig config = getServletConfig();
            // 通过ServletConfig获取配置参数
            String driver = config.getInitParameter("driver");
            String url = config.getInitParameter("url");
            String user = config.getInitParameter("user");
            String pass = config.getInitParameter("pass");
            // 注册驱动
            Class.forName(driver);
            // 获取数据库连接
            Connection conn = DriverManager.getConnection(url, user, pass);
            // 创建Statement
            Statement stmt = conn.createStatement();
            // 执行查询，获取ResultSet对象
            ResultSet rs = stmt.executeQuery("select * from test");
            resp.setContentType("text/html;charset=utf-8");
            // 获取页面输出流
            PrintWriter out = resp.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>访问Servlet初始化参数测试</title>");
            out.println("<table bgcolor=\"#9999dd\" border=\"1\"" +
                "width=\"480\">");
            // 遍历结果集
            while (rs.next()) {
                // 输出结果集
                out.println("<tr>");
                out.println("<td>" + rs.getString(1) + "</td>");
                out.println("<td>" + rs.getString(2) + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("<body>");
            out.println("</html>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
