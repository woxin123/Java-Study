package com.example;

import com.example.domain.Book;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Test01 {
    public static void main(String[] args) {

        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("E:\\project\\Java Study\\Spring\\Spring 源码\\springBean源码详解\\src\\main\\resources\\mySpringConfig");
        Book book = (Book) context.getBean("book");
        System.out.println(book);
    }
}
