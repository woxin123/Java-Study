package com.example.oauthjwt.web.controller;

import com.example.oauthjwt.model.Result;
import com.example.oauthjwt.model.ResultBuilder;
import com.example.oauthjwt.model.domain.MyUser;
import com.example.oauthjwt.web.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author: mengchen
 * Create by 18-4-25
 */
@RestController
public class UserController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Result> register(@RequestBody MyUser user) {
        user.setUserStatus(0);
        user.setUserTime(new Date());
        user.setUserType(0);
        logger.info(user.toString());
        if (userService.saveUser(user)) {
            return ResponseEntity.ok(ResultBuilder.genSuccessResult("注册成功"));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ResultBuilder.genFailResult("服务器内部错误"));
        }
    }


}
