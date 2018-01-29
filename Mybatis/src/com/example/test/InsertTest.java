package com.example.test;

import com.example.factory.MyBaitsSqlSessionFactory;
import com.example.testmybaits.User;
import org.apache.ibatis.session.SqlSession;

public class InsertTest {
    public static void main(String[] args) {
        // 1. 得到Session
        SqlSession session = MyBaitsSqlSessionFactory.getSqlSession();
        // 2. 创建要插入的对象
        User user = new User("张三", "女", 18);
        // 3. 插入
        session.insert("com.example.mapper.UserMapper.saveUser", user);
        // 4. 提交
        session.commit();
        // 5. 关闭
        session.close();
    }
}
