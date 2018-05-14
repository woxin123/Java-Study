package com.example.thymleatstudy.model.domain;

/**
 * User实体
 */
public class User {
    private Long id; // 实体的唯一标识
    private String username;
    private String emial;

    public User() { // 无参构造器
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
}
