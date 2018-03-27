package com.example.demo.mapper;


import org.apache.ibatis.annotations.Select;
import com.example.demo.web.model.User;

import java.util.List;

public interface UserMapper {

    @Select("SELECT * FROM test")
    List<User> getUser();
}