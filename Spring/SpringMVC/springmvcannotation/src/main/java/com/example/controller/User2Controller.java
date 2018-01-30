package com.example.controller;

import com.example.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class User2Controller {
    // @ModelAttribute修饰的方法回想先于login()执行，该方法用于接受前台JSP页面传入的参数
    @ModelAttribute
    public void userModel(String loginname, String password, ModelMap modelMap) {
        // 创建一个User对象存储jsp页面传入的参数
        User user = new User();
        user.setLoginname(loginname);
        user.setPassword(password);
        // 把User添加到Model中
        modelMap.addAttribute("user", user);
    }
    @RequestMapping(value = "/login2", method = POST)
    public String login(ModelMap modelMap) {
        // 从model中取出之前存入的user对象
        User user = (User)modelMap.get("user");
        user.setUsername("天神");
        return "return2";
    }
}
