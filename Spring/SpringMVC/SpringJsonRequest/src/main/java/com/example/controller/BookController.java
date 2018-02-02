package com.example.controller;

import com.example.domain.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/json")
public class BookController {

    private static final Logger logger = Logger.getLogger(BookController.class);

    @RequestMapping(value = "/testRequestBody", method = POST,consumes = "application/json")
    public void setJson(@RequestBody Person person, HttpServletResponse response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        person.setName("李四");
        person.setSex("男");
        System.out.println(mapper.writeValueAsString(person));
        response.getWriter().println(mapper.writeValueAsString(person));
    }
}
