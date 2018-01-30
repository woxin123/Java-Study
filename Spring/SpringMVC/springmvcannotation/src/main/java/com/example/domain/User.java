package com.example.domain;

import java.io.Serializable;

public class User implements Serializable {
    private String loginname;
    private String password;
    private String username;

    public User() {
        super();
    }

    public User(String loginname, String password, String username) {
        this.loginname = loginname;
        this.password = password;
        this.username = username;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLoginname() {
        return loginname;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
