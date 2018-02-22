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
public class FormatterController {

    private Logger logger = Logger.getLogger(FormatterController.class);
    @RequestMapping("/{formName}")
    public String loginForm(@PathVariable String formName) {
        return formName;
    }

    @RequestMapping(value = "/test", method = POST)
    public String test(@ModelAttribute User user, Model model) {
        logger.info(user);
        model.addAttribute("user", user);
        return "success";
    }
}
