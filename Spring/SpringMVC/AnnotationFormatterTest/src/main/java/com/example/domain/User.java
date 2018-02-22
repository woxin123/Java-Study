package com.example.domain;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.io.Serializable;
import java.util.Date;

import static org.springframework.format.annotation.NumberFormat.Style.CURRENCY;
import static org.springframework.format.annotation.NumberFormat.Style.NUMBER;
import static org.springframework.format.annotation.NumberFormat.Style.PERCENT;

public class User implements Serializable {
    // 日期类型
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthday;
    // 正常数字类型
    @NumberFormat(style= NumberFormat.Style.NUMBER, pattern="#,###")
    private int total;
    // 百分数类型
    @NumberFormat(style= NumberFormat.Style.PERCENT)
    private double discount;
    // 货币类型
    @NumberFormat(style= NumberFormat.Style.CURRENCY)
    private double money;
    public User() {
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }


    @Override
    public String toString() {
        return "User{" +
                "birthday=" + birthday +
                ", total=" + total +
                ", money" + money +
                ", discount=" + discount +
                '}';
    }
}
