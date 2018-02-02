package com.example.controller;

import com.example.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/json")
public class PersonController {
    @RequestMapping("/TestGson")
    @ResponseBody
    public Object getJson() {
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person(1, "张三"));
        persons.add(new Person(2,"李四"));
        return persons;
    }
}
