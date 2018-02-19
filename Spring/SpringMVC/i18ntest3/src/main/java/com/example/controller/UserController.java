package com.example.controller;

import com.example.domain.User;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Locale;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class UserController {
    @RequestMapping(value = "/{formName}", method = GET)
    public String loginForm(@PathVariable String formName, String request_locale,
                            Model model, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("request_locale:" + request_locale);
        Locale locale;
        if (request_locale != null) {
            if (request_locale.equals("zh_CN")) {
                locale = new Locale("zh", "CN");
            } else if (request_locale.equals("en_US")) {
                locale = new Locale("en", "US");
            } else {
                locale = LocaleContextHolder.getLocale();
            }
        } else {
            locale = LocaleContextHolder.getLocale();
        }
        (new CookieLocaleResolver()).setLocale(request, response, locale);
        User user = new User();
        model.addAttribute("user", user);
        return formName;
    }

    @RequestMapping(value = "/login", method = POST)
    public String login(@ModelAttribute @Validated User user, Model model, HttpServletRequest request) {
        if (user.getLoginname().equals("woxin123") && user.getPassword().equals("mengchen")) {
            RequestContext requestContext = new RequestContext(request);
            String username = requestContext.getMessage("username");
            user.setUsername(username);
            model.addAttribute("user", user);
            return "success";
        }
        return "error";
    }
}