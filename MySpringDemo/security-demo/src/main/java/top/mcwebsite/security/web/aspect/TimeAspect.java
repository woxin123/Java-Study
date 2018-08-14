package top.mcwebsite.security.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author mengchen
 * @time 18-7-25 下午3:11
 */
//@Aspect
//@Component
public class TimeAspect {

    /**
     *
     * @param joinPoint  包含所要拦截的那个方法的所有信息
     * @return
     */
    @Around("execution(* top.mcwebsite.security.web.controller.UserController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("time aspect start");
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("arg is " + arg);
        }
        Long start = System.currentTimeMillis();
        Object object = joinPoint.proceed();
        System.out.println("time aspect 耗时：" + (System.currentTimeMillis() - start));
        System.out.println("time aspect end");
        return object;
    }

}
