package org.example.heighlight_spring.ch1.di.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        UseFuncationService useFuncationService =
                context.getBean(UseFuncationService.class);
        System.out.println(useFuncationService.SayHello("Java Config"));

        context.close();
    }
}
