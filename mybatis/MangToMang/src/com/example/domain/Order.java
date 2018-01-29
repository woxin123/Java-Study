package com.example.domain;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable {
    private int id;
    private String code;
    private double total;
    private User user;
    private List<Article> articles;

    public Order() {
    }

    public Order(String code, double total, User user, List<Article> articles) {
        this.code = code;
        this.total = total;
        this.user = user;
        this.articles = articles;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public double getTotal() {
        return total;
    }

    public User getUser() {
        return user;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
    @Override
    public String toString() {
        return "Order [id=" + id + ", code=" + code + ", total=" + total + "]";
    }
}
