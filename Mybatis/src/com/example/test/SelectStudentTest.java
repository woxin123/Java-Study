package com.example.test;

import com.example.factory.MyBaitsSqlSessionFactory;
import com.example.testmybaits.Student;
import com.example.testmybaits.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class SelectStudentTest {
    public static void main(String[] args) {
        // 1. 得到Session
        SqlSession session = MyBaitsSqlSessionFactory.getSqlSession();
        // 2. 查询
        List<Student> students = session.
                selectList("com.example.mapper.UserMapper.selectStudent");
        // 3. 操作
        for (Student student : students) {
//            System.out.println("id:" + student.getId());
//            System.out.println("class:" + student.getClazz().getCode());
            System.out.println(student);
        }
        // 4. 提交事物
        session.commit();
        // 5. 关闭
        session.close();
    }
}