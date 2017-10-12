package com.example.myFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "LogFilter", urlPatterns = {"/*"})
public class LogFilter implements javax.servlet.Filter {

    // FilterConfig可用于访问Filter的配置信息
    private FilterConfig config;
    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }

    // 实现销毁的方法
    public void destroy() {
    }

    // 执行过滤的方法
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 下面的代码用户对用户的请求执行预处理
        // 获取ServletContext对象，用于记录日志
        ServletContext context = this.config.getServletContext();
        long before = System.currentTimeMillis();
        System.out.println("开始过滤...");
        // 将请求转化成HttpServletRequest请求
        HttpServletRequest hrequest = (HttpServletRequest) req;
        // 输出提示信息
        System.out.println("Filter已经截获到用户的请求地址：" + hrequest.getServletPath());
        // Filter只是链式的处理，请求依旧放到目的地地址
        chain.doFilter(req, resp);
        // 下面的代码用于对服务器响应执行处理
        long after = System.currentTimeMillis();
        // 输出提示信息
        System.out.println("过滤结束");
        // 输出提示信息
        System.out.println("请求被定位到" + hrequest.getRequestURI() + "   所花的时间为：" + (after - before));
    }
}
