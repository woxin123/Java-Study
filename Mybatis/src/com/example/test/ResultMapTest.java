package com.example.test;

import com.example.factory.MyBaitsSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class ResultMapTest {
    public static void main(String[] args) {
        // 1. 得到Session
        SqlSession session = MyBaitsSqlSessionFactory.getSqlSession();
        // 2. 查询
        List<Map<String, Object>> users = session.
                selectList("com.example.mapper.UserMapper.selectAllUser");
        // 3. 操作
        for (Map<String, Object> row : users) {
            System.out.println(row);
        }
        // 4. 提交事物
        session.commit();
        // 5. 关闭
        session.close();
    }
}
