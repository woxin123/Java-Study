package com.example.branch.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: mengchen
 * Create by 18-4-23
 */
@RestController
public class UserController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @RequestMapping("/logout")
    public String logout() {

        redisTemplate.delete("");
        return null;
    }
}
