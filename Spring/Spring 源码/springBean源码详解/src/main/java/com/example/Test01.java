package com.example;


import com.example.spring.bean.factory.Car;
import org.apache.log4j.Logger;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class Test01 {
    private Logger logger = Logger.getLogger(Test01.class);
    public static void main(String[] args) {

        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("E:\\project\\Java Study\\Spring\\Spring 源码\\springBean源码详解\\src\\main\\resources\\mySpringConfig");
        // 通过FactoryBean配置
        Car car1 = (Car) context.getBean("car1");
        System.out.println(car1);
        // 通过静态工厂获取bean
        Car car2 = (Car) context.getBean("car2");
        System.out.println(car2);
        // 通过实例工厂来获取bean
         Car car3 = (Car) context.getBean("car3");
        System.out.println(car3);
    }
}
