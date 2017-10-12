package com.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "firstServlet", urlPatterns = "/firstServlet")
public class FirstServlet  extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置解码方式
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        // 获取name请求的参数值
        String name = req.getParameter("name");
        // 获取gender的请求参数值
        String gender = req.getParameter("gender");
        // 获取color的请求参数的值
        String[] color = req.getParameterValues("color");
        // 获取country的请求参数的值
        String  national = req.getParameter("country");
        // 获取页面输出流
        PrintWriter out = resp.getWriter();
        // 输出HTML页面标签
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet测试</title>");
        out.println("</head>");
        out.println("<body>");
        // 输出请求参数
        out.println("您的名字：" + name + "<hr/>");
        out.println("您的性别：" + gender + "<hr/>");
        out.println("您喜欢的颜色：");
        for (String c : color) {
            out.println(c + " ");
        }
        out.println("<hr/>");
        out.println("您来自的国家：" + national + "<hr/>");
        out.println("</body>");
        out.println("</html>");
    }
}
