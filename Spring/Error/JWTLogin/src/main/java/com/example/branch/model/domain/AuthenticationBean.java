package com.example.branch.model.domain;

/**
 * @author: mengchen
 * Create by 18-4-23
 */
public class AuthenticationBean {
    private String account;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
