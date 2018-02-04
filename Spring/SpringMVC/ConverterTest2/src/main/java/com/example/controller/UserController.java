package com.example.controller;

import com.example.converter.DateEditer;
import com.example.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class UserController {
    // 在控制器初始化时注册属性编辑器
//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        // 注册自定义编辑器
//        binder.registerCustomEditor(Date.class, new DateEditer());
//    }

    @RequestMapping(value="/{formName}")
    public String loginForm(@PathVariable String formName){
        // 动态跳转页面
        return formName;
    }

    @RequestMapping(value = "/register", method = POST)
    public String register(@ModelAttribute User user, Model model) {
        System.out.println(user);
        model.addAttribute("user", user);
        return "success";
    }
}
