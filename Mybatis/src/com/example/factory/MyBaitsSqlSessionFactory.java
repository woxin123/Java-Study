package com.example.factory;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class MyBaitsSqlSessionFactory {
    private static SqlSessionFactory sqlSessionFactory = null;

    static {
        try {
            BufferedInputStream config = new BufferedInputStream(
                    new FileInputStream("/home/mengchen/IdeaProjects/Mybaits/src/mybaits-config"));
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}
