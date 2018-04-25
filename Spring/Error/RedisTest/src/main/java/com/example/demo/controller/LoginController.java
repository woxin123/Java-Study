package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: mengchen
 * Create by 18-4-23
 */
@RestController
public class LoginController {

    @GetMapping("/loginPage")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String loginPage() {
        return "暂不提供表单登录！";
    }
}
