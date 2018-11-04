package top.mcwebsite.dao;

import org.apache.ibatis.annotations.Param;
import top.mcwebsite.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int checkUsername(String username);

    int checkEmail(String email);

    User selectLogin(@Param("username") String username, @Param("password") String password);

    String selectQuestionUsername(String username);

    int checkAnswer(@Param("username") String username, @Param("question") String question, @Param("answer") String answer);
}