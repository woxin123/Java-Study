package com.example.domain;

import java.io.Serializable;
import java.util.List;

public class Article implements Serializable{
    private int id;
    private String name;
    private double price;
    private String remark;
    private List<Order> orders;

    public Article() {
    }

    public Article(String name, double privce, String remark, List<Order> orders) {
        this.name = name;
        this.price = privce;
        this.remark = remark;
        this.orders = orders;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getRemark() {
        return remark;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Article [id=" + id + ", name=" + name + ", price=" + price
                + ", remark=" + remark + "]";
    }
}
