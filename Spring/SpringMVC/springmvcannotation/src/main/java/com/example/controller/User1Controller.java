package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.example.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class User1Controller {
    // @ModelAttribute修饰的方法回想先于login()执行，该方法用于接受前台JSP页面传入的参数
    @ModelAttribute
    public void userModel(String loginname, String password, Model model) {
        // 创建一个User对象存储jsp页面传入的参数
        User user = new User();
        user.setLoginname(loginname);
        user.setPassword(password);
        // 把User添加到Model中
        model.addAttribute("user", user);
    }
    @RequestMapping(value = "/login1", method = POST)
    public String login(Model model) {
        // 从model中取出之前存入的user对象
        User user = (User)model.asMap().get("user");
        user.setUsername("天神");
        return "return1";
    }
}
