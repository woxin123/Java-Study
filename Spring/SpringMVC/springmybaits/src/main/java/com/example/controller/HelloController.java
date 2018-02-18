package com.example.controller;

import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {
    @Autowired
    UserMapper userMapper;
    @RequestMapping("/hello")
    public String hello() {
        System.out.println(userMapper.isExist(1));
        return "Hello World!";
    }
}
