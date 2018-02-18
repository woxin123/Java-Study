package com.example.interceptor;

import com.auth0.jwt.interfaces.Claim;
import com.example.utils.JWTUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.Map;

public class LoginInterceptor implements HandlerInterceptor {

    private static final String[] IGNORE_URL = {"/loginForm", "/login", "/hello"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag = false;
        System.out.println("aaaaaaaaaa");
        // 对获取的路径进行判断
        String servletPath = request.getServletPath();
        // 判断请求是否需要拦截
        for (String s : IGNORE_URL) {
            if (servletPath.contains(s)) {
                flag = true;
                System.out.println("请求通过。");
                break;
            }
        }
        if (flag == false) {
            System.out.println("尝试获取token");
            // 1. 获取头部的token
            String token = request.getHeader("token");
            System.out.println(token);
            if (token != null) {
                try {
                    Map<String, Claim> map = JWTUtils.verifyToken(token);
                    System.out.println(map.get("username").asString());
                    flag = true;
                } catch (Exception e) {
                    System.out.println("token失效");
                }
            } else {
                System.out.println("被拦截了");
            }
        }
        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
