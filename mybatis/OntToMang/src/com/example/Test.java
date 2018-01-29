package com.example;

import com.example.domain.Clazz;
import com.example.domain.Student;
import com.example.mapper.ClazzMapper;
import com.example.mapper.StudentMapper;
import jdk.internal.util.xml.impl.Input;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
import java.util.List;

public class Test {

    public static void main(String[] args) throws IOException {
        BufferedInputStream config = new BufferedInputStream(new FileInputStream("src/mybaits-config"));
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Test test = new Test();
//        test.testSelectClazzById(sqlSession);
//        test.testSelectStudentById(sqlSession);
        test.testSelectStudentByClazzId(sqlSession);
        sqlSession.commit();
        sqlSession.close();
    }

    public void testSelectClazzById(SqlSession sqlSession) {
        ClazzMapper cm = sqlSession.getMapper(ClazzMapper.class);
        Clazz clazz = cm.selectClazzById(1);
        System.out.println(clazz);
        List<Student> students = clazz.getStudents();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void testSelectStudentById(SqlSession sqlSession) {
        StudentMapper sm = sqlSession.getMapper(StudentMapper.class);
        Student student = sm.selectStudentById(1);
        System.out.println(student);
        System.out.println(student.getClazz());
    }

    public void testSelectStudentByClazzId(SqlSession sqlSession) {
        com.example.AnnotationMapper.ClazzMapper cm =
                sqlSession.getMapper(com.example.AnnotationMapper.ClazzMapper.class);
        Clazz clazz = cm.selectById(1);
        System.out.println(clazz);
        List<Student> students = clazz.getStudents();
        students.forEach(student-> System.out.println(student));
    }
}
