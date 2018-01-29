package com.example.test;

import com.example.domain.Employee;
import com.example.mapper.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class DynamicSqlTest {
    public static void main(String[] args) throws FileNotFoundException {
        BufferedInputStream config = new BufferedInputStream(new FileInputStream("src/mybaits-config"));
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DynamicSqlTest test = new DynamicSqlTest();
        test.testselectEmployeeLinkeName(sqlSession);
        sqlSession.commit();
        sqlSession.close();
    }

    public void testselectEmployeeByIdlike(SqlSession sqlSession) {
        EmployeeMapper em = sqlSession.getMapper(EmployeeMapper.class);
        HashMap<String, Object> param = new HashMap<>();
//        param.put("id", 1);
        param.put("loginname", "小三");
        List<Employee> employees = em.selectEmployeeByIdlike(param);
        employees.forEach(employee-> System.out.println(employee));
    }
    public void testSelectEmployeeChoose(SqlSession sqlSession) {
        EmployeeMapper em = sqlSession.getMapper(EmployeeMapper.class);
        HashMap<String, Object> param = new HashMap<>();
//        param.put("id", 2);
//        param.put("loginname", "Jack");
//        param.put("password", "123456");
        List<Employee> employees = em.selectEmployeeChoose(param);
        employees.forEach(employee-> System.out.println(employee));
    }
    public void testSelectEmployeeLike(SqlSession sqlSession) {
        EmployeeMapper em = sqlSession.getMapper(EmployeeMapper.class);
        HashMap<String, Object> param = new HashMap<>();
//        param.put("id", 2);
        param.put("state", "active");
        List<Employee> employees = em.selectEmployeeLike(param);
        employees.forEach(employee-> System.out.println(employee));
    }

    public void testUpdateEmployee(SqlSession sqlSession) {
        EmployeeMapper em = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = em.selectEmployeeWithId(2);
        employee.setAge(18);
        employee.setName("露丝");
        employee.setLoginname("rose");
        em.updateEmployee(employee);
    }

    public void testselectEmployeeIn(SqlSession sqlSession) {
        EmployeeMapper em = sqlSession.getMapper(EmployeeMapper.class);
        List<Integer> ids = new LinkedList<>();
        ids.add(1);
        ids.add(2);
        List<Employee> employees = em.selectEmployeeIn(ids);
        employees.forEach(employee-> System.out.println(employee));
    }
    public void testselectEmployeeLinkeName(SqlSession sqlSession) {
        EmployeeMapper em = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setName("露");
        List<Employee> employees = em.selectEmployeeLinkeName(employee);
        employees.forEach(e-> System.out.println(e));
    }
}
