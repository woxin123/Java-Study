package org.example.controller;

import org.example.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class User2Controller {

    @RequestMapping(value = "/regsiterForm", method = GET)
    public String registerForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = POST)
    public String register(@ModelAttribute @Validated User user, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "registerForm";
        }
        model.addAttribute("user", user);
        return "success";
    }
}
