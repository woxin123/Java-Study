package com.example.branch.model.domain;

/**
 * @author: mengchen
 * Create by 18-4-23
 */
public class User {

    private int userId;

    private String username;

    private String account;

    private String password;

    private int userType;

    private int userStatus;

    private int userTime;

    public static final int USER_TYPE_NORMAL = 0;

    public static final int USER_TYPE_ISLOCK = 1;


    public User() {
    }


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public int getUserTime() {
        return userTime;
    }

    public void setUserTime(int userTime) {
        this.userTime = userTime;
    }

}
