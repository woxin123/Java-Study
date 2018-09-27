package com.example.dockerstudy.web.controller;

import com.example.dockerstudy.dao.PersonRepository;
import com.example.dockerstudy.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author mengchen
 * @time 18-9-27 上午11:02
 */
@RestController
public class DataController {

    @Autowired
    PersonRepository personRepository;

    /**
     * @param name
     * @param address
     * @param age
     * @return
     */
    @RequestMapping("/save")
    public Person save(String name, String address, Integer age) {
        Person person = personRepository.save(new Person(name, age, address));

        return person;
    }

    @RequestMapping("/q1")
    public List<Person> q1(String address) {
        List<Person> people = personRepository.findByAddress(address);

        return people;
    }

    @RequestMapping("/q2")
    public Person q2(String name, String address) {
        Person person = personRepository.findByNameAndAddress(name, address);

        return person;
    }

    @RequestMapping("/q3")
    public Person q3(String name, String address) {
        Person person = personRepository.withNameAndAddressQuery(name, address);

        return person;
    }

    @RequestMapping("/q4")
    public Person q4(String name, String address) {
        Person person = personRepository.withNameAndAddressNameQuery(name, address);

        return person;
    }

    @RequestMapping("/sort")
    public List<Person> sort() {
        List<Person> people = personRepository.findAll(new Sort(Sort.Direction.ASC, "age"));

        return people;
    }

    @RequestMapping("/page")
    public Page<Person> page() {
        Page<Person> pagePeople = personRepository.findAll(PageRequest.of(1, 2));

        return pagePeople;
    }

    @RequestMapping("/auto")
    public Page<Person> auto(Person person) {
        Page<Person> pagePeople = personRepository.findByAuto(person, new PageRequest(0, 10));
        return pagePeople;
    }
}
