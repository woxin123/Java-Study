package com.example.interceptor;

import com.auth0.jwt.interfaces.Claim;
import com.example.utils.JWTUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class LoginInterceptor implements HandlerInterceptor {

    private static final String[] IGNORE_URL = {"/loginForm", "/login"};
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag = false;
        // 对获取的路径进行判断
        String servletPath = request.getServletPath();
        // 判断请求是否需要拦截
        for (String s : IGNORE_URL) {
            if (servletPath.contains(s)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            // 1. 获取头部的token
            String token = request.getHeader("token");
            if (token != null) {
                try {
                    Map<String, Claim> map = JWTUtils.verifyToken(token);
                    System.out.println(map.get("username").asString());
                } catch (Exception e) {
                    System.out.println("token失效");
                }
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
