package com.example.controller;

import com.example.domain.User;
import com.example.validation.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class UserController {
    @Autowired
    @Qualifier("userValidator")
    private UserValidation userValidation;
    @RequestMapping("/loginForm")
    public String loginName(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "loginForm";
    }

    @RequestMapping(value = "/login", method = POST)
    public String login(User user, Model  model, Errors errors) {
        System.out.println(user);
        model.addAttribute("user", user);
        // 调用userValidator的验证方法
        userValidation.validate(user, errors);
        // 如果验证不通过跳转到loginForm视图
        if (errors.hasErrors()) {
            return "loginForm";
        }
        return "success";
    }
}
