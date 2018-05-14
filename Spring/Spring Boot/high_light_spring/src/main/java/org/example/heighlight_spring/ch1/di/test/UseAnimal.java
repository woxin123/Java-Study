package org.example.heighlight_spring.ch1.di.test;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class UseAnimal {
    public static void main(String[] args) {
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("application.xml");
        Animal dog = (Animal) context.getBean("dog");
        dog.say();
    }
}
