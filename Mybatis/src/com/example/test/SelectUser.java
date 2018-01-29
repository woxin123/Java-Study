package com.example.test;

import com.example.factory.MyBaitsSqlSessionFactory;
import com.example.testmybaits.User;
import org.apache.ibatis.session.SqlSession;

public class SelectUser {
    public static void main(String[] args) {
        // 1. 得到SQLSession
        SqlSession session = MyBaitsSqlSessionFactory.getSqlSession();
        // 2. 查询
        User user = session.selectOne("com.example.mapper.UserMapper.selectUser", 1);
        // 3. 操作
        System.out.println("name:" + user.getName());
        System.out.println("sex:" + user.getSex());
        System.out.println("age:" + user.getAge());
        // 4. 提交事物
        session.commit();
        // 5. 关闭
        session.close();
    }
}
