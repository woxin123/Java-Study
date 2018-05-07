package com.example.springresttest.web.controller;

import com.example.springresttest.web.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloWorldRestController {

    @GetMapping("/user")
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.ACCEPTED);
    }

}
