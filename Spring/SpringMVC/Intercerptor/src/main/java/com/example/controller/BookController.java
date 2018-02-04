package com.example.controller;

import com.example.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    @RequestMapping("/main")
    public String main(Model model) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("西游记", "吴承恩", 100));
        books.add(new Book("三国演义", "罗贯中", 100));
        books.add(new Book("水浒传", "施耐庵", 100));
        books.add(new Book("红楼梦", "曹雪芹", 100));
        model.addAttribute("books", books);

        return "main";
    }
}
