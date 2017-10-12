package com.example.myFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuthorityFilter"
    , urlPatterns = {"/*"}
    , initParams = {
        @WebInitParam(name="encoding", value = "UTF-8"),
        @WebInitParam(name="loginPage", value = "/login.jsp"),
        @WebInitParam(name="proLogin", value = "/proLogin.jsp")
})
public class AuthorityFilter implements Filter {
    private FilterConfig config;
    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }
    // 实现销毁的方法
    public void destroy() {
        config = null;
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 获取Filter的配置参数
        String encoding = config.getInitParameter("encoding");
        String loginPage = config.getInitParameter("loginPage");
        String proLogin = config.getInitParameter("proLogin");
        // 设置request编码用的字符集
        req.setCharacterEncoding(encoding);
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        // 获取请求的页面
        String requestPath = request.getServletPath();
        // 如果session范围的user为null，级表明没有登录
        // 且用户如果请求的既不是登录页面，也不是处理登录的页面
        if (session.getAttribute("user") == null
                && !requestPath.endsWith(loginPage)
                && !requestPath.endsWith(proLogin)) {
            // forward到登录页面
            request.setAttribute("tip", "您还没有登录");
            request.getRequestDispatcher(loginPage).forward(req, resp);
        }
        // "放行"请求
        else {
            chain.doFilter(req, resp);
        }
    }



}
