package com.example.domain;

import java.io.Serializable;

public class Person implements Serializable {
    private Integer id;
    private String name;
    private String sex;

    public Person() {

    }
    public Person(Integer id, String name, String sex) {
        super();
        this.id = id;
        this.name = name;
        this.sex = sex;
    }
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", name=" + name + ", sex=" + sex + "]";
    }
}
