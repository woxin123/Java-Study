package com.example.oauthjwt.web.service;

import com.example.oauthjwt.dao.UserMapper;
import com.example.oauthjwt.model.domain.MyUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author: mengchen
 * Create by 18-4-23
 */
@Component
public class MyUserDetialService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        MyUser user = userMapper.getUserByAccount(account);
        // 根据查找到的用户信息判断用户是否被冻结
        boolean isNonLock = true;
        String userRole = "ROLE_USER";
        if (user == null) {
            throw new UsernameNotFoundException("账号错误");
        }
        if (user.getUserStatus() == 1) {
            isNonLock = false;
        }
        if (user.getUserType() == 1) {
            userRole += ", ROLE_VIP";
        }

        logger.info("登录用户名：" + account);

        return new User(account, passwordEncoder.encode(user.getPassword()),
                true, true, true, isNonLock,
                AuthorityUtils.commaSeparatedStringToAuthorityList(userRole));

    }
}
