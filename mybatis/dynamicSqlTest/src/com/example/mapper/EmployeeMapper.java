package com.example.mapper;

import com.example.domain.Employee;

import java.util.HashMap;
import java.util.List;

public interface EmployeeMapper {
    List<Employee> selectEmployeeByIdlike(HashMap<String, Object> param);

    List<Employee> selectEmployeeChoose(HashMap<String, Object> param);

    List<Employee> selectEmployeeLike(HashMap<String, Object> param);

    Employee selectEmployeeWithId(int id);

    void updateEmployee(Employee employee);

    List<Employee> selectEmployeeIn(List<Integer> ids);

    List<Employee> selectEmployeeLinkeName(Employee employee);
}
