package com.example.demo.web.controller;

import com.example.demo.web.model.AuthorSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

/**
 * @author: mengchen
 * Create by 18-4-16
 */
@RestController
public class BookController {

    private Logger logger = LoggerFactory.getLogger(BookController.class);
//    @Value("${book.author}")
//    private String bookAuthor;
//
//    @Value("book.name")
//    private String bookName;

    @Autowired
    private AuthorSettings authorSettings;

    @RequestMapping("/book")
    public String book() {
        logger.debug(authorSettings.getName() + " " + authorSettings.getAge());
        return "author name is:" + authorSettings.getName() + " and  auther age is:" + authorSettings.getAge();
    }


}
