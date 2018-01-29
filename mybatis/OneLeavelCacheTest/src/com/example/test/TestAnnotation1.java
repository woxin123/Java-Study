package com.example.test;

import com.example.domain.User;
import com.example.factory.MyBatisSqlSessionFactory;
import com.example.AnnotationMapper.UserMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TestAnnotation1 {
    public static void main(String[] args) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
        UserMapper um = sqlSession.getMapper(UserMapper.class);
//        List<User> users = um.selectAllUser();
//        users.forEach(user-> System.out.println(user));
        User user1 = um.selectUserById(2);
        System.out.println(user1);
//        User user = new User();
//        user.setId(7);
//        user.setName("张三");
//        user.setSex("女");
//        user.setAge(10);
//        um.saveUser(user);
//        um.removeUser(7);
//        um.modifyUser(user);

        sqlSession.commit();
        List<User> users = um.selectAllUser();
        users.forEach(u-> System.out.println(u));
        sqlSession.close();
    }
}
