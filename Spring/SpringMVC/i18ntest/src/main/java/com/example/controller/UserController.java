package com.example.controller;

import com.example.domain.User;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class UserController {
    @RequestMapping("/{form}")
    public String loginForm(@PathVariable String form, Model model) {
        if (form.contains("Form")) {
            model.addAttribute("user", new User());
            return form;
        }
        else {
            return "Error Page!";
        }
    }
    @RequestMapping(value = "/login", method = POST)
    public String login(@ModelAttribute @Validated User user, Model model, HttpServletRequest request) {
        if (user.getLoginname().equals("woxin123") && user.getPassword().equals("mengchen")) {
            // 从后台获取国际化信息username
            RequestContext requestContext = new RequestContext(request);
            String username = requestContext.getMessage("username");
            user.setUsername(username);
            model.addAttribute("user", user);
            return "success";
        }
        return "error";
    }
}
