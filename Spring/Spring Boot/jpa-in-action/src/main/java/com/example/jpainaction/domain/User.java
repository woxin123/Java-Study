package com.example.jpainaction.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * User实体
 */
@Entity
public class User {
    @Id // 主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增策咯
    private Long id; // 实体的唯一标识

    private String username;
    private String emial;

    protected User() { // 无参构造器; 设置protect,防止直接使用
    }

    public User(Long id, String username, String emial) {
        this.id = id;
        this.username = username;
        this.emial = emial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmial() {
        return emial;
    }

    public void setEmial(String emial) {
        this.emial = emial;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", emial='" + emial + '\'' +
                '}';
    }
}
