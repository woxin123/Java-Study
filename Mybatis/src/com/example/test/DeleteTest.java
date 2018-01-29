package com.example.test;

import com.example.factory.MyBaitsSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;

public class DeleteTest {
    public static void main(String[] args) {
        // 1. 得到Session
        SqlSession session = MyBaitsSqlSessionFactory.getSqlSession();
        // 2. 删除
        session.delete("com.example.mapper.UserMapper.removeUser", 1);
        // 3. 提交
        session.commit();
        // 4. 关闭
        session.close();
    }
}
