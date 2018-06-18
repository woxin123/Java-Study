package top.mcwebsite.springsecurityinaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import top.mcwebsite.springsecurityinaction.domain.User;
import top.mcwebsite.springsecurityinaction.repository.UserReposity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * User Controller
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserReposity userReposity;


    /**
     * 查询所有用户
     *
     * @param model
     * @return
     */
    @GetMapping
    public ModelAndView listUsers(Model model) {
        Iterable<User> iterable = userReposity.findAll();
        List users = new ArrayList();
        Iterator<User> itertor = iterable.iterator();
        while (itertor.hasNext()) {
            users.add(itertor.next());
        }
        model.addAttribute("userList", users);
        model.addAttribute("title", "用户管理");
        return new ModelAndView("users/list", "userModel", model);
    }

    /**
     * 根据id查询用户
     *
     * @param model
     * @return
     */
    @GetMapping("/{id}")
    public ModelAndView view(@PathVariable Long id, Model model) {
        model.addAttribute("user", userReposity.findById(id).get());
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
        model.addAttribute("user", new User( null, null));
        model.addAttribute("title", "创建用户");
        return new ModelAndView("users/form", "userModel", model);
    }

    @PostMapping
    public ModelAndView saveOrUpdateUser(User user) {
        user = userReposity.save(user);
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
        userReposity.deleteById(id);
        model.addAttribute("userList", userReposity.findAll());
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
        User user = userReposity.findById(id).get();
        model.addAttribute("user", user);
        model.addAttribute("title", "修改用户");

        return new ModelAndView("users/form", "userModel", model);
    }

}
