package com.example.test;

import com.example.factory.MyBaitsSqlSessionFactory;
import com.example.testmybaits.User;
import org.apache.ibatis.session.SqlSession;

public class UpdateTest {
    public static void main(String[] args) {
        // 1. 得到SqlSession
        SqlSession session = MyBaitsSqlSessionFactory.getSqlSession();
        // 2. 根据id查询User对象
        User user = session.selectOne("com.example.mapper.UserMapper.selectUser", 1);
        // 3. 修改
        user.setName("李四");
        user.setAge(4);
        user.setSex("女");
        // 4. 修改User对象
        session.update("com.example.mapper.UserMapper.modifyUser", user);
        // 5. 提交事物
        session.commit();
        // 6. 关闭
        session.close();
    }
}
