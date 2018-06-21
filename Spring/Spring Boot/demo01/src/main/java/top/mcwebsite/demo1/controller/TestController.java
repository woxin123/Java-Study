package top.mcwebsite.demo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/login")
    public String login() {
        return "loginPage";
    }

    @GetMapping("/loginSuccess")
    public String success() {
        return "success";
    }

}
