package com.example.dockerstudy.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * @Entity 注解表明这是一个和数据库表映射的实体类。
 * @Id 注解表明这个属性映射为数据库表的主键。
 * @GeneratedValue 注解默认使用主键生成方式为自增，hibernate会自动为生成一个名为HIBERNATE_SEQUENCE的序列
 * @author mengchen
 * @time 18-9-27 上午10:42
 */
@Entity
@NamedQuery(name= "Person.withNameAndAddressNameQuery",
query = "SELECT p FROM Person p WHERE p.name = ?1 AND p.address = ?2")
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Integer age;

    private String address;

    public Person() {
    }

    public Person(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
