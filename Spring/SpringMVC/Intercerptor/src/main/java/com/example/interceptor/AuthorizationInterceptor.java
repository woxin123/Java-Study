package com.example.interceptor;

import com.example.domain.User;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthorizationInterceptor implements HandlerInterceptor {

    // 不拦截"/loginForm"和"/login"请求
    private static final String[] IGNORE_URI = {"/loginForm", "/login"};

    private static final Logger logger =  Logger.getLogger(AuthorizationInterceptor.class);

    /**
     * preHandle是进行处理拦截的方法，该方法在Controller处理请求之前执行
     * 该方法的返回值为true，拦截器才会继续执行下去，该方法的返回值为false时请求就结束了
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("AuthorizationInterceptor preHandle -->");
        // 设置一个变量为flag
        boolean flag = false;
        String servletPath = request.getServletPath();
        // 判断是否需要拦截
        for(String s : IGNORE_URI) {
            if (servletPath.contains(s)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            // 获取session中的用户
            User user = (User) request.getSession().getAttribute("user");
            if (user == null) {
                // 如果没有用户信息，则设置提示信息，跳转到登录界面
                logger.info("AuthorizationInterceptor拦截请求");
                request.setAttribute("message", "请先登录！！");
                request.getRequestDispatcher("/loginForm").forward(request, response);
            } else {
                // 如果用户已经登录，则验证通过，放行
                logger.info("AuthorizationInterceptor放行请求");
                flag = true;
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
