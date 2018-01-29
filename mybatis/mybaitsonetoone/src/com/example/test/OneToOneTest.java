package com.example.test;

import com.example.domain.Person;
import com.example.mapper.PersonMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class OneToOneTest {
    public static void main(String[] args) throws FileNotFoundException {
        BufferedInputStream config = new BufferedInputStream(new FileInputStream("/home/mengchen/IdeaProjects/mybaits/mybaitsonetoone/src/mybaits-config"));
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        // 获得session连接
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获得Mapper接口的代理对象
        PersonMapper pm = sqlSession.getMapper(PersonMapper.class);
        // 查询
        Person person = pm.selectPersonById(1);
        // 打印person对象
        System.out.println(person);
        // 提交事物
        sqlSession.commit();
        // 关闭
        sqlSession.close();
    }
}
