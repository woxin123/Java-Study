package com.example.demo.web.controller;

import com.example.demo.mapper.UserMapper;
import com.example.demo.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("index.html")
    public List<User> hello() {
        List users = userMapper.getUser();
        return users;
    }
}
