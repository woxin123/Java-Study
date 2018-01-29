package com.example.mapper;

import com.example.domain.Student;

public interface StudentMapper {

    Student selectStudentById(int id);
    Student selectStudentByClazzId(int id);
}
