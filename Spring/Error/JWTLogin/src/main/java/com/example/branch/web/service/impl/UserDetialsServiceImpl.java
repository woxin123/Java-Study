package com.example.branch.web.service.impl;

import com.example.branch.model.domain.User;
import com.example.branch.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author: mengchen
 * Create by 18-4-23
 */
@Service
public class UserDetialsServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {

        User user = userService.findUserByAccount(account);
        if (user == null) {
            throw new UsernameNotFoundException("没有找到该用户");
        }
        boolean isNonLock = user.getUserStatus() == 0 ? true : false;
        return new org.springframework.
                security.core.userdetails
                .User(account, passwordEncoder.encode(user.getPassword()), true, true, true, isNonLock,
                AuthorityUtils.commaSeparatedStringToAuthorityList("ADMIN"));
    }


}
