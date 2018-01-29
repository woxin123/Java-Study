package com.example.domain;

import java.io.Serializable;

public class Student implements Serializable{
    private int id;
    private String name;
    private String sex;
    private int age;
    private Clazz clazz;


    public Student() {
    }

    public Student(String name, String sex, int age, Clazz clazz) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.clazz = clazz;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "StudentMapper [id=" + id + ", name=" + name + ", sex=" + sex
                + ", age=" + age + "]";
    }
}
