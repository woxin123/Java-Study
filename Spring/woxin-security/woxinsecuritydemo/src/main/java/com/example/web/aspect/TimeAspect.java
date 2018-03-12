package com.example.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class TimeAspect {

    @Around("execution(* com.example.web.controller.UserController.*(..))")
    public Object handlerControllerMethod(ProceedingJoinPoint pip) throws Throwable {
        System.out.println("time aspect start");

        Object[] args = pip.getArgs();
        for (Object arg : args) {
            System.out.println("arg is: " + arg);
        }
        long start = new Date().getTime();
        Object object = pip.proceed();
        System.out.println("time aspect 耗时: " + new Date().getTime() + start);
        System.out.println("time aspect end");
        return null;
    }

}
