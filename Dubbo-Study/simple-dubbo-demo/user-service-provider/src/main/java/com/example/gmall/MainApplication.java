package com.example.gmall;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author mengchen
 * @time 18-12-16 下午9:46
 */
public class MainApplication {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:provider.xml");
        applicationContext.start();

        System.in.read();
    }
}
