package com.example.test;

import com.example.factory.MyBaitsSqlSessionFactory;
import com.example.testmybaits.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class ResultMapToUser {
    public static void main(String[] args) {
        // 1. 得到Session
        SqlSession session = MyBaitsSqlSessionFactory.getSqlSession();
        // 2. 查询
        List<User> users = session.
                selectList("com.example.mapper.UserMapper.selectAllUser2");
        // 3. 操作
        for (User user : users) {
            System.out.println(user.getId());
        }
        // 4. 提交事物
        session.commit();
        // 5. 关闭
        session.close();
    }
}
