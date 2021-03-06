package com.example.thymleatstudy.repository;

import com.example.thymleatstudy.model.domain.User;

import java.util.List;

public interface UserReposity {
    /**
     * 创建或者修改用户
     *
     * @param user
     * @return
     */
    User saveOrUpdateUser(User user);

    /**
     * 删除用户
     *
     * @param id
     */
    void deleteUser(Long id);

    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    User getUserById(Long id);

    /**
     * 用户列表
     *
     * @return
     */
    List<User> listUsers();
}
