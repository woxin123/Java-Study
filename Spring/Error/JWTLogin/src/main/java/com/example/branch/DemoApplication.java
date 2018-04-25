package com.example.branch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@RestController
@MapperScan("com.example.branch.dao")
public class DemoApplication {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @RequestMapping("/hello")
    public String hello() {
        redisTemplate.opsForValue().set("123", "HelloWorld!", 1, TimeUnit.DAYS);
        String aa = redisTemplate.opsForValue().get("123");
        System.out.println(aa);
        return aa;

    }

    @RequestMapping("/world")
    public String world() {
        redisTemplate.opsForValue().set("123", "HelloWorld!", 1, TimeUnit.DAYS);
        String aa = redisTemplate.opsForValue().get("123");
        System.out.println(aa);
        return aa;

    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
