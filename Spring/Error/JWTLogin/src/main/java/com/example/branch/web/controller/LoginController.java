package com.example.branch.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: mengchen
 * Create by 18-4-23
 */
@RestController
public class LoginController {
    @RequestMapping(value = "/loginNot")
    public String loginNot() {
        return "未登录";
    }

    @RequestMapping(value = "/loginExpire")
    public String loginExpired() {
        return "登陆过期";
    }

    @RequestMapping(value = "/loginException")
    public String loginException() {
        return "登陆异常";
    }
}
