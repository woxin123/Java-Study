package com.example.gmall.service.impl;

import com.example.gmall.bean.UserAddress;
import com.example.gmall.service.OrderService;
import com.example.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 1. 将服务提供者注册到注册中心
 *  1). 导入dubbo依赖
 * 2. 让服务消费者去注册中心订阅服务提供者的服务地址
 * @author mengchen
 * @time 18-12-16 下午8:51
 */
@Service
public class OrderServiceImpl implements OrderService {

    private final UserService userService;

    @Autowired
    public OrderServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<UserAddress> initOrder(String userId) {
        System.out.println("用户id" + userId);
        // 需要查询用户的收货地址
        List<UserAddress> userAddressList = userService.getUserAddressList(userId);
        userAddressList.forEach((userAddress -> {
            System.out.println(userAddress.getUserAddress());
        }));

        return userAddressList;
    }
}
