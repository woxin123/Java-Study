package com.map.controller;

import com.map.domain.User;
import com.map.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @Autowired
    UserMapper userMapper;
    @RequestMapping("/hello")
    public String hello() {
        User user = userMapper.findUserByAccountAndPassword("13572011907", "mengchen");
        System.out.println(user);
        return "hello";
    }
}
