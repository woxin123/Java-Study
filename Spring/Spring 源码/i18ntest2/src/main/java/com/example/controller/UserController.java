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
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class UserController {
    @RequestMapping("/{loginForm}")
    public String loginForm(@PathVariable String loginForm,
                            String request_locale, Model model,
                            HttpServletRequest request) {
        System.out.println("request_locale:" + request_locale);
        Locale locale;
        // 设置中文环境
        if (request_locale != null) {
            if (request_locale.equals("zh_CN")) {
                locale = new Locale("zh", "CN");
            }
            // 设置英文环境
            else if (request_locale.equals("en_US")) {
                locale = new Locale("en", "US");
            } else {
                locale = LocaleContextHolder.getLocale();
            }
        } else {
            locale = LocaleContextHolder.getLocale();
        }
        System.out.println("locale:" + locale.getLanguage() + "_" + locale.getCountry());
        request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locale);
        User user = new User();
        model.addAttribute("user", user);
        return loginForm;
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