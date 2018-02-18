package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

@Controller
public class HelloController {
    @Autowired
    RedisTemplate<String, Object> redisTemplate;
    @RequestMapping("/{name}")
    public String name(@PathVariable String name, Model model) {
        ValueOperations<String, Object> aa = redisTemplate.opsForValue();
        aa.set("name", "孟晨", 10, TimeUnit.SECONDS);
        return name;
    }
}
