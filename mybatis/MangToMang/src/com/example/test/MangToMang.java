package com.example.test;

import com.example.domain.Article;
import com.example.domain.Order;
import com.example.domain.User;
import com.example.mapper.OrderMapper;
import com.example.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class MangToMang {
    public static void main(String[] args) throws FileNotFoundException {
        BufferedInputStream config = new BufferedInputStream(new FileInputStream("src/mybaits-config"));
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        MangToMang m = new MangToMang();
        m.testSelectUserById(sqlSession);
        System.out.println("-----------------");
        m.testSelectOrderById(sqlSession);

        sqlSession.commit();
        sqlSession.close();
    }

    public void testSelectUserById(SqlSession sqlSession) {
        UserMapper um = sqlSession.getMapper(UserMapper.class);
        User user = um.selectUserById(1);
        System.out.println(user);
        List<Order> orders = user.getOrders();
        for (Order order : orders) {
            System.out.println(order);
        }
    }
    public void testSelectOrderById(SqlSession sqlSession) {
        OrderMapper om = sqlSession.getMapper(OrderMapper.class);
        Order order = om.selectOrderById(2);
        System.out.println(order);
        User user = order.getUser();
        System.out.println(user);
        List<Article> articles = order.getArticles();
        for (Article article : articles) {
            System.out.println(article);
        }
    }
}
