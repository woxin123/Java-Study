package com.example.controller;

import com.example.domain.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);

    @RequestMapping("/{formName}")
    public String loginForm (@PathVariable String formName) {
        return formName;
    }

    @RequestMapping(value = "/register", method = POST)
    public String register (@ModelAttribute  User user, Model model) {
        logger.info(user.getBirthday());
        model.addAttribute("user", user);
        return "success";
    }
}
