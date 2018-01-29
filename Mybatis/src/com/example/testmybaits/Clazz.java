package com.example.testmybaits;

import java.util.List;

public class Clazz {
    private Integer id;
    private String code;
    private List<Student> students;

    public Integer getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Clazz [id=" + id + ", code=" + code + "]";
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
