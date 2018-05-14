package org.example.heighlight_spring.ch1.di.javaconfig;

import org.springframework.stereotype.Service;

//@Service
public class FuncationService {
    public String sayHello(String word) {
        return "Hello " + word + " !";
    }
}
