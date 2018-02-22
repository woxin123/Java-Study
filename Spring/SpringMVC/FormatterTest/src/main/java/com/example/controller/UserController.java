package com.example.controller;

import com.example.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class UserController {

    @RequestMapping("/{formName}")
    public String loginForm(@PathVariable String formName) {
        return formName;
    }

    @RequestMapping(value = "/register", method = POST)
    public String register(User user, Model model) {
        System.out.println(user);
        model.addAttribute("user", user);
        return "success";
    }
}
