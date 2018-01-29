package com.example.domain;

import java.io.Serializable;

public class Card implements Serializable {
    private int id;
    private String code;

    public Card(){
    }

    public Card(String code) {
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "[Card id=" + id + ", code=" + code + "]";asd
    }
}
