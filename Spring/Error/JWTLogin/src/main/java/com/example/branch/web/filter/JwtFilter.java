package com.example.branch.web.filter;

import com.example.branch.util.JwtUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author: mengchen
 * Create by 18-4-23
 */
public class JwtFilter implements Filter {

    private JwtUtil jwtUtil;

    public JwtFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        System.out.println(req.getServletPath());
        String token = req.getHeader("token");
        if (token == null) {
            req.getRequestDispatcher("/loginNot").forward(req, response);
            return;
        }
        if (!jwtUtil.validateToken(token)) {
            req.getRequestDispatcher("/loginExpire").forward(req, response);
            return;
        }
        if (!jwtUtil.isJwtRight(token)) {
            req.getRequestDispatcher("/loginException").forward(req, response);
            return;
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
