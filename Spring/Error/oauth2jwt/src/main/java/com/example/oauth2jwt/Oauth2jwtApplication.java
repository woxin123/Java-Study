package com.example.oauth2jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Oauth2jwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2jwtApplication.class, args);
    }

    @GetMapping
    public String index() {
        return "Hello Spring Security";
    }
}
