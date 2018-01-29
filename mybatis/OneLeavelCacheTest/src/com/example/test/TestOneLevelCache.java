package com.example.test;

import com.example.domain.User;
import com.example.factory.MyBatisSqlSessionFactory;
import com.example.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;

public class TestOneLevelCache {
    public static void main(String[] args) {
        TestOneLevelCache t = new TestOneLevelCache();
        t.test1();
        t.test2();
    }

    public void test1() {
        SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();

        UserMapper um = sqlSession.getMapper(UserMapper.class);
        User user1 = um.selectUserById(2);
        System.out.println(user1);
        sqlSession.commit();
        User user2 = um.selectUserById(2);
        System.out.println(user2);
        sqlSession.close();
    }

    public void test2() {
        SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();

        UserMapper um = sqlSession.getMapper(UserMapper.class);
        User user1 = um.selectUserById(2);
        System.out.println(user1);
        sqlSession.close();
    }
}
