package com.example.controller;

import com.example.utils.JWTUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class UserController {
    @RequestMapping("/loginForm")
    public String loginForm() {
        return "login";
    }

    @RequestMapping(value = "/login", method = POST)
    public String login(String username, String password, Model model) throws Exception {
        if (username.equals("woxin123") && password.equals("123456")) {
            String token = JWTUtils.createToken(username, password);
            model.addAttribute("token");
            return "success";
        }
        return "error";
    }
}
