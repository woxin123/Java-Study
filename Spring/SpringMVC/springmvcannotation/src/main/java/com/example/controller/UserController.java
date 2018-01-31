package com.example.controller;

import com.example.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/user")
public class UserController {
    // 静态的List集合，此处用来代替数据库保存用户注册的信息
    private static List<User> userList;
    public UserController() {
        userList = new ArrayList<User>();
    }

    @RequestMapping(value = "/register", method = GET)
    public String registerForm() {
        // 调到注册页面
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = POST)
    public String register(@RequestParam("loginname") String loginname,
                           @RequestParam("password") String password,
                           @RequestParam("username") String username) {
        User user = new User();
        user.setLoginname(loginname);
        user.setPassword(password);
        user.setUsername(username);
        userList.add(user);
        // 跳到登录界面
        return "loginForm";
    }

    @RequestMapping("/login")
    public String login(@RequestParam("loginname") String loginname,
                        @RequestParam("password") String passowrd,
                        Model model) {
        for (User user : userList) {
            if (user.getLoginname().equals(loginname) &&
                    user.getPassword().equals(passowrd)) {
                model.addAttribute("user", user);
                return "welcome";
            }
        }
        return "loginForm";
    }
}
