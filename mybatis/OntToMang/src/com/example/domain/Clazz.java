package com.example.domain;

import java.util.List;

public class Clazz {
    private int id;
    private String code;
    private String name;
    private List<Student> students;


    public Clazz() {
    }

    public Clazz(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getId() {

        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }
    @Override
    public String toString() {
        return "Clazz [id=" + id + ", code=" + code + ", name=" + name + "]";
    }
}
