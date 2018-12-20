package com.example.gmall.service.impl;

import com.example.gmall.bean.UserAddress;
import com.example.gmall.service.UserService;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author mengchen
 * @time 18-12-18 下午7:20
 */
public class UserServiceStub implements UserService {

    private final UserService userService;

    public UserServiceStub(UserService userService) {
        this.userService = userService;
    }

    /**
     * 传入userService远程代理对象
     * @param userId
     * @return
     */
    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("UserServiceStub......");
        if (!StringUtils.isEmpty(userId)) {
            return userService.getUserAddressList(userId);
        }
        return null;
    }
}
