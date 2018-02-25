package com.example.domain;

import java.io.Serializable;

public class User implements Serializable {
    private String usernmam;
    private String loginname;
    private String password;

    public User() {
    }

    public User(String usernmam, String loginname, String password) {
        this.usernmam = usernmam;
        this.loginname = loginname;
        this.password = password;
    }

    public String getUsernmam() {
        return usernmam;
    }

    public void setUsernmam(String usernmam) {
        this.usernmam = usernmam;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "usernmam='" + usernmam + '\'' +
                ", loginname='" + loginname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
