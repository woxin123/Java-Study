package com.example.controller;

import com.example.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class UserController {
    @RequestMapping(value = "/login", method = POST)
    public String login(Model model, String loginname, String password,
                        HttpSession session) {
        if (loginname != null && loginname.equals("woxin123") && password != null
                && password.equals("123456")) {
            User user = new User();
            user.setLoginname(loginname);
            user.setPassword(password);
            user.setUsername("admin");
            // 登录成功，将user设置到session域中
            session.setAttribute("user", user);
            return "redirect:main";
        }
        else {
            model.addAttribute("message", "登录名或者密码错误，请重新输入！");
            return "loginForm";
        }

    }
}
