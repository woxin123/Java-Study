package org.example.heighlight_spring.ch1.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DiConfig.class);
        UseFuncationService useFuncationService = context.getBean(UseFuncationService.class);
        System.out.println(useFuncationService.SayHello("di"));
        context.close();
    }
}
