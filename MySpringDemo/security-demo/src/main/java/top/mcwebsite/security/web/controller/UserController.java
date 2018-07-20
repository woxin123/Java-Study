package top.mcwebsite.security.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import top.mcwebsite.security.dto.User;
import top.mcwebsite.security.dto.UserQueryCondition;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import static top.mcwebsite.security.dto.User.*;


/**
 * mengchen
 * 18-7-17 下午11:10
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    @JsonView(UserSimpleView.class)
    public List<User> query(UserQueryCondition userQueryCondition,
                            @PageableDefault(size = 17, page = 2, sort = "username,asc")  Pageable pageable) {
        System.out.println(userQueryCondition);
        System.out.println(pageable.getPageSize() + " " + pageable.getPageNumber()
            + pageable.getSort());
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    @GetMapping("/{id:\\d+}")
    @JsonView(UserDetialView.class)
    public User getInfo(@PathVariable String id) {
        User user = new User();
        user.setUsername("tom");

        return user;
    }

    @PostMapping
    public User createUser(@Valid @RequestBody User user,
                           BindingResult errors) {

        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
        }

        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());
        user.setId("1");
        return user;
    }

    @PutMapping("{id:\\d+}")
    public User update(@Valid @RequestBody User user,
                           BindingResult errors) {
        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
        }

        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());
        user.setId("1");
        return user;
    }
}
