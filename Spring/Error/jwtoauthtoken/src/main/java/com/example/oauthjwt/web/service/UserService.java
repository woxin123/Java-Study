package com.example.oauthjwt.web.service;

import com.example.oauthjwt.model.domain.MyUser;

/**
 * @author: mengchen
 * Create by 18-4-25
 */
public interface UserService {
    boolean saveUser(MyUser user);
}
