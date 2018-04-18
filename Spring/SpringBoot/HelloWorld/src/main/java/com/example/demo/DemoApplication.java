package com.example.demo;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        // 第一种方式关闭Banner
//        SpringApplication app = new SpringApplication(DemoApplication.class);
//        app.setBannerMode(Banner.Mode.OFF);
//        app.run(args);
        // 第二种方式关闭Banner
//        new SpringApplicationBuilder(DemoApplication.class)
//                .bannerMode(Banner.Mode.OFF)
//                .run(args);

        SpringApplication.run(DemoApplication.class, args);

    }
}
