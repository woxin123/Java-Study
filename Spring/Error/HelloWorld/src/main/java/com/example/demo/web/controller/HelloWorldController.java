package com.example.demo.web.controller;

import com.example.demo.web.exception.MyException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * @author: mengchen
 * Create by 18-4-14
 */
@Controller
public class HelloWorldController {


    @RequestMapping("/1")
    public String index(ModelMap map) {
        map.addAttribute("host", "http://blog.didispace.com");

        return "index";
    }


    @RequestMapping("/")
    public String index1() {
        return "index1";
    }

    @RequestMapping("/hello")
    public String hello() throws Exception {
//        int a = 1 / 0;
//        throw new Exception("发生错误");
        return "hello";
    }

    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("发生错误");
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
    @RequestMapping(value = "/jsonView", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String json(Model model) {
        model.addAttribute("name", "woxin");
        return "jsonView";
    }
}
