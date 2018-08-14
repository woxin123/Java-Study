package top.mcwebsite.demo.web.controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.mcwebsite.demo.domain.Book;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @time 18-7-25 上午8:59
 * @auther mengchen
 */
@RestController
public class BookController {
    @PostMapping("/book")
    public Book getBook(@Valid Book book) {
        // ...
        return book;
    }
}
