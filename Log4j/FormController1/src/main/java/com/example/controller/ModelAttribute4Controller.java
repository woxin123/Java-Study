package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ModelAttribute4Controller {

    // 相当于在model中封装了username=admin
    // 它所对应的视图应该是login4
    @RequestMapping("/login4")
    @ModelAttribute(value = "username")
    public String login4() {
        return "admin";
    }
}
