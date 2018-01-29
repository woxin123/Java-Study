package com.example.domain;

import java.io.Serializable;

public class Person implements Serializable{
    private int id;
    private String name;
    private String sex;
    private int age;
    private Card card;

    public Person() {
    }

    public Person(String name, String sex, int age, Card card) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.card = card;
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

    public Card getCard() {
        return card;
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

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "[Person id=" + id + ", name=" + name + ", sex" + sex + ", age"
                + age + "card=" + card + "]";
    }
}
