package com.example.mapper;

import com.example.domain.Person;

// 对象名必须和Mapper的namespaces相同
public interface PersonMapper {

    /**
     * 根据id查询Person,属性名必须和XMl文件中的那个<select.../>元素的id相同
     * @param id id
     * @return  Person 对象
     */
    public Person selectPersonById(Integer id);
}
