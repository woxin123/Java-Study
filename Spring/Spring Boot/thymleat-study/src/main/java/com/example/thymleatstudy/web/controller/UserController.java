package com.example.thymleatstudy.web.controller;

import com.example.thymleatstudy.model.domain.User;
import com.example.thymleatstudy.repository.UserReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * User Controller
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserReposity userReposity;

    private List<User> getUserList() {
        return userReposity.listUsers();
    }

    /**
     * 查询所有用户
     *
     * @param model
     * @return
     */
    @GetMapping
    public ModelAndView listUsers(Model model) {
        model.addAttribute("userList", userReposity.listUsers());
        model.addAttribute("title", "用户管理");
        return new ModelAndView("users/list", "userModel", model);
    }

    /**
     * 根据id查询用户
     *
     * @param model
     * @return
     */
    @GetMapping("{id}")
    public ModelAndView view(@PathVariable Long id, Model model) {
        model.addAttribute("user", userReposity.getUserById(id));
        model.addAttribute("title", "查看用户");
        return new ModelAndView("users/view", "userModel", model);
    }

    /**
     * 获取创建表单页面
     *
     * @param model
     * @return
     */
    @GetMapping("/form")
    public ModelAndView createForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("title", "创建用户");
        return new ModelAndView("users/form", "userModel", model);
    }

    @PostMapping
    public ModelAndView saveOrUpdateUser(User user) {
        user = userReposity.saveOrUpdateUser(user);
        return new ModelAndView("redirect:/users");
    }

    /**
     * 删除用户
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping(value = "delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id, Model model) {
        userReposity.deleteUser(id);
        model.addAttribute("userList", getUserList());
        model.addAttribute("title", "删除用户");

        return new ModelAndView("users/list", "userModel", model);
    }

    /**
     * 修改用户
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping(value = "modify/{id}")
    public ModelAndView modfiyForm(@PathVariable("id") Long id, Model model) {
        User user = userReposity.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("title", "修改用户");

        return new ModelAndView("users/form", "userModel", model);
    }

}
