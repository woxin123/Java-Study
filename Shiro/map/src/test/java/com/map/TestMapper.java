package com.map;

import com.map.domain.User;
import com.map.mapper.UserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration("classpath:applicationContext.xml")
public class TestMapper {

    @Autowired
    UserMapper userMapper;

    @Test
    public void testUserMapper() {
        System.out.println(userMapper);
        User user = userMapper.findUserByAccountAndPassword("13572011907", "mengchen");
        System.out.println(user);
    }
}
