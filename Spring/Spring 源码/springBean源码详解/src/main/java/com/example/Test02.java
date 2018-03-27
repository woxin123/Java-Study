package com.example;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class Test02 {

    public static void main(String[] args) throws IOException {
        Resource resource = new ClassPathResource("beanlearn.xml");
//        System.out.println(resource.getURI());
//        System.out.println(resource.getURL());
//        System.out.println(resource.isReadable());
//        System.out.println(resource.getDescription());
//        System.out.println(resource.isFile());
//        System.out.println(resource.contentLength());
//        System.out.println(new Date(resource.lastModified()).toString());
        Resource resource1 = resource.createRelative("mySpringConfig");
        File file = resource1.getFile();
        System.out.println(resource1.getDescription());
    }
}
