package com.example.controller;

import com.example.domain.Person;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/json")
public class PersonController {
    private static final Logger logger = Logger.getLogger(PersonController.class);
    @RequestMapping("/testResponseGson")
    @ResponseBody
    public Object getJson() {
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person(1, "张三"));
        persons.add(new Person(2,"李四"));
        return persons;
    }

    @RequestMapping(value = "testGson", consumes = "application/json")
    public void getAndSetGson(@RequestBody Person person, HttpServletResponse response) throws IOException {
        person.setName("王五");
        Gson gson = new Gson();
        String p = gson.toJson(person);
        logger.info(p);
        response.getWriter().println(p);
    }
}
