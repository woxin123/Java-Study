package com.example.mapper;

import org.apache.ibatis.annotations.Select;


public interface UserMapper {
    @Select("select count(id) from user where id = #{id}")
    public boolean isExist(int id);
}
