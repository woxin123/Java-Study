package com.example.mapper;

import com.example.domain.User;

import java.util.List;

public interface UserMapper {
    User selectUserById(Integer id);
    List<User> selectAllUser();
    void deleteUserById(int id);
}
