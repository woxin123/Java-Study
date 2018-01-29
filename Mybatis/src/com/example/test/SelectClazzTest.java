package com.example.test;

import com.example.factory.MyBaitsSqlSessionFactory;
import com.example.testmybaits.Clazz;
import com.example.testmybaits.Student;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class SelectClazzTest {
    public static void main(String[] args) {
        // 1. 得到Session
        SqlSession session = MyBaitsSqlSessionFactory.getSqlSession();
        // 2. 查询
        List<Clazz> clazzs = session.
                selectList("com.example.mapper.UserMapper.selectClazz");
        // 3. 操作
        for (Clazz clazz : clazzs) {
            System.out.println(clazz);
            List<Student> students = clazz.getStudents();
            for (Student student : students) {
                System.out.println(student);
            }
        }
        // 4. 提交事物
        session.commit();
        // 5. 关闭
        session.close();
    }
}
