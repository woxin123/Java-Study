package com.example.branch.web.service.impl;

import com.example.branch.dao.UserMapper;
import com.example.branch.model.domain.User;
import com.example.branch.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: mengchen
 * Create by 18-4-23
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByAccount(String account) {
        return userMapper.getUserByAccount(account);
    }
}
