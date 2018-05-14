package com.example.thymleatstudy.web.controller;

import com.example.thymleatstudy.model.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {

    private Book getBook() {
        Book book = new Book();
        book.setBookId(1);
        book.setBookName("三国演义");
        book.setBookAuthor("罗贯中");
        book.setPrice(100);
        return book;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        Book book = getBook();
        model.addAttribute("book", book);
        return "index";
    }
}
