package com.example.gmall.service;

import com.example.gmall.bean.UserAddress;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

/**
 * @author mengchen
 * @time 18-12-16 下午10:40
 */
public class MainApplication {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:consumer.xml");
        context.start();

        OrderService orderService = context.getBean(OrderService.class);

        List<UserAddress> userAddresses = orderService.initOrder("1");

        System.out.println(userAddresses);

        System.in.read();

    }
}
