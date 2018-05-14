package org.example.heighlight_spring.ch1.di.javaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//@Service
public class UseFuncationService {
    //    @Autowired
    FuncationService funcationService;

    public void setFuncationService(FuncationService funcationService) {
        this.funcationService = funcationService;
    }

    public String SayHello(String word) {
        return funcationService.sayHello(word);
    }
}
