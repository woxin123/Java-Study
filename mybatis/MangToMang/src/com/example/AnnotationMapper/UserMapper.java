package com.example.AnnotationMapper;

import com.example.domain.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from tb_user2 where id = #{id}")
    User selectUserById(int id);
}
