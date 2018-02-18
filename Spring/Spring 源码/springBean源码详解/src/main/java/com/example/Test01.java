package com.example;

import com.example.domain.Book;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Test01 {
    public static void main(String[] args) {
        ClassPathResource resource = new ClassPathResource("mySpringConfig");
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(resource);
        Book book = (Book) factory.getBean("book");
        System.out.println(book);
    }
}
