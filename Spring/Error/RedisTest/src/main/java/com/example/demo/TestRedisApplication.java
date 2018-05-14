package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TestRedisApplication {

    public static void main(String[] args) {

        SpringApplication.run(TestRedisApplication.class, args);
    }

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping("/hello")
    public String hello() {
        System.out.println(redisTemplate.opsForValue().get("1"));
        return redisTemplate.opsForValue().get("1");
    }
}
