package com.example.branch.dao;

import com.example.branch.model.domain.User;
import org.apache.ibatis.annotations.*;

/**
 * @author: mengchen
 * Create by 18-4-23
 */
public interface UserMapper {
    @Select("SELECT * FROM user WHERE user_id = #{userId}")
    @Results(id = "userMap", value = {
            @Result(id = true, column = "user_id", property = "userId"),
            @Result(column = "username", property = "username"),
            @Result(column = "account", property = "account"),
            @Result(column = "password", property = "password"),
            @Result(column = "user_type", property = "userType"),
            @Result(column = "user_time ", property = "userTime"),
            @Result(column = "user_status", property = "userStatus")
    })
    User getUserById(int userId);


    @Select("SELECT * FROM user WHERE account = #{account}")
    @ResultMap("userMap")
    public User getUserByAccount(String account);

    @Insert("INSERT INTO user(username, password, user_type, user_time, user_status)" +
            " VALUES(#{username}, #{password}, #{userType}, #{userTime}, #{userStatus})")
    User addUser(User user);

    @Update("UPDATE FROM user SET username = #{username}, password = #{password}, " +
            "user_type = #{userType}, userStatus = #{userStatus} WHERE user_id = #{userId}")
    User updateUser(User user);

    @Delete("DELETE FROM user WHERE user_id = #{userId}")
    boolean deleteUser(int userId);
}
