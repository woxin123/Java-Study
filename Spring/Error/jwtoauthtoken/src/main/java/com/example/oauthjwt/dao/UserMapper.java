package com.example.oauthjwt.dao;

import com.example.oauthjwt.model.domain.MyUser;
import org.apache.ibatis.annotations.*;

/**
 * @author: mengchen
 * Create by 18-4-25
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
    MyUser getUserById(int userId);


    @Select("SELECT * FROM user WHERE account = #{account}")
    @ResultMap("userMap")
    public MyUser getUserByAccount(String account);

    @Insert("INSERT INTO user(username, account,password, user_type, user_time, user_status)" +
            " VALUES(#{username}, #{account},#{password}, #{userType}, #{userTime}, #{userStatus})")
    boolean addUser(MyUser user);

    @Update("UPDATE FROM user SET username = #{username}, password = #{password}, " +
            "user_type = #{userType}, userStatus = #{userStatus} WHERE user_id = #{userId}")
    MyUser updateUser(MyUser user);

    @Delete("DELETE FROM user WHERE user_id = #{userId}")
    boolean deleteUser(int userId);
}
