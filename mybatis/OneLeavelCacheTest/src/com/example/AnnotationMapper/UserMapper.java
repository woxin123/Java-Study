package com.example.AnnotationMapper;

import com.example.domain.User;
import org.apache.ibatis.annotations.*;

import java.lang.reflect.GenericArrayType;
import java.util.List;

public interface UserMapper {
    @Insert("insert into tb_user(name, sex, age) values(#{name}, #{sex}, #{age})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int saveUser(User user);

    @Delete("delete from tb_user where id = #{id}")
    int removeUser(@Param("id") Integer id);

    @Update("update tb_user set name = #{name}, sex = #{sex}, age = #{age} where id = #{id}")
    void modifyUser(User user);

    @Select("select * from tb_user where id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "age", column = "age")
    })
    User selectUserById(int id);

    @Select("select * from tb_user")
    List<User> selectAllUser();
}
