package com.example.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class User extends BaseDomain {
    // 锁定用户对应的状态值
    public static final int USER_LOCK = 1;
    // 用户解锁对应的状态值
    public static final int USER_UNLOCK = 0;
    // 管理源类型
    public static final int FORUME_ADMIN = 2;
    // 普通用户类型
    public static final int NORMAL_USER = 1;

    private int userId;

    private String userName;

    private int userType = NORMAL_USER;

    private String lastIp;

    private Date lastVisit;

    private String password;

    private String lockId;

    private int credit;

    private Set<Board> manBoards = new HashSet<>();

    public Set<Board> getManBoards() {
        return manBoards;
    }

    public void setManBoards(Set<Board> manBoards) {
        this.manBoards = manBoards;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public Date getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLockId() {
        return lockId;
    }

    public void setLockId(String lockId) {
        this.lockId = lockId;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
}
