package com.example.oauthjwt.web.service.impl;

import com.example.oauthjwt.dao.UserMapper;
import com.example.oauthjwt.model.domain.MyUser;
import com.example.oauthjwt.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: mengchen
 * Create by 18-4-25
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean saveUser(MyUser user) {
        boolean isSuccessAdd =  userMapper.addUser(user);
        return isSuccessAdd;
    }
}
