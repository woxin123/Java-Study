package com.example.controller;

import com.example.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class User3Controller {
    // @ModelAttribute修饰的方法回想先于login()执行，该方法用于接受前台JSP页面传入的参数
    @ModelAttribute
    public void userModel(String loginname, String password, ModelAndView mv) {
        // 创建一个User对象存储jsp页面传入的参数
        User user = new User();
        user.setLoginname(loginname);
        user.setPassword(password);
        // 把User添加到Model中
        mv.addObject("user", user);
    }
    @RequestMapping(value = "/login3", method = POST)
    public ModelAndView login(ModelAndView mv) {
        // 从model中取出之前存入的user对象
        User user = (User)mv.getModel().get("user");
        user.setUsername("天神");
        mv.setViewName("return3");
        return mv;
    }
}
