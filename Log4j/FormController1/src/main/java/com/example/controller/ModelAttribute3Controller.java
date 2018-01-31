package com.example.controller;

import com.example.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedList;
import java.util.List;

@Controller
public class ModelAttribute3Controller {
    private static List<User> userList;

    public ModelAttribute3Controller() {
        userList = new LinkedList<User>();
        User user1 = new User("admin", "123456", "小三");
        User user2 = new User("admin", "123456", "小四");
        userList.add(user1);
        userList.add(user2);
    }

    public static User find(String loginname, String password) {
        for (User user : userList) {
            if (user.getLoginname().equals(loginname) &&
                    user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    // model属性的属性名没有被指定，由它返回类型隐含表示，如果这个方法返回的是User类型的话，那么model属性的名称就是user
    @ModelAttribute
    public User userModel3(@RequestParam("loginname") String loginname,
                           @RequestParam("password") String password) {
        return find(loginname, password);
    }

    @RequestMapping("/login3")
    public String login3() {
        return "return3";
    }
}
