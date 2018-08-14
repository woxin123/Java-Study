package top.mcwebsite.security.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author mengchen
 * @time 18-7-25 下午2:49
 */
@Component
public class TimeInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("preHandler");
        request.setAttribute("startTime", System.currentTimeMillis());
        System.out.println(((HandlerMethod)handler).getBean().getClass().getName());
        System.out.println(((HandlerMethod)handler).getMethod().getName());
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        System.out.println("postHandler");
        Long start = (Long) request.getAttribute("startTime");
        System.out.println("time interceptor 耗时：" + (System.currentTimeMillis() - start));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println("postHandler");
        Long start = (Long) request.getAttribute("startTime");
        System.out.println("time interceptor 耗时：" + (System.currentTimeMillis() - start));

        System.out.println("ex:" + ex);
    }
}
