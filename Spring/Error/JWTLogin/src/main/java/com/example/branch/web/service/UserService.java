package com.example.branch.web.service;

import com.example.branch.model.domain.User;

/**
 * @author: mengchen
 * Create by 18-4-23
 */
public interface UserService {

    User findUserByAccount(String account);
}
