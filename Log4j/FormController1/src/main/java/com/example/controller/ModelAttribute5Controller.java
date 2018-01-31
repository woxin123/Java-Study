package com.example.controller;

import com.example.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedList;
import java.util.List;

@Controller
public class ModelAttribute5Controller {
    @ModelAttribute("user")
    public User userModel5(@RequestParam("loginname") String loginname,
                           @RequestParam("password") String password) {
        User user = new User();
        user.setLoginname(loginname);
        user.setPassword(password);
        return user;
    }

    @RequestMapping("/login5")
    public String login3(@ModelAttribute("user") User user) {
        user.setUsername("小三");
        return "return5";
    }
}
