package com.example.test;

import com.example.testmybaits.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class TestMybaits {
    public static void main(String[] args) throws FileNotFoundException {
        // 读取Mybaits-config.xml文件
        InputStream inputStream = new FileInputStream("/home/mengchen/IdeaProjects/Mybaits/src/mybaits-config");
        // 初始化Mybaits，创建SqlSessionFactory实例
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(inputStream);
        // 创建Session实例
        SqlSession session = sqlSessionFactory.openSession();
        // 创建User对象
        User user = new User("admin", "男", 21);
        // 插入数据
        session.insert("com.example.mapper.UserMapper.save", user);
        // 提交事物
        session.commit();
        // 关闭session
        session.close();
    }
}
