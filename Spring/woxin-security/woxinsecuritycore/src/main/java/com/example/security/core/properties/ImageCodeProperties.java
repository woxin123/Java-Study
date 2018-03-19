package com.example.security.core.properties;

public class ImageCodeProperties {

    private int wiidth = 67;
    private int height = 23;
    private int length = 4;
    private int expireIn = 60;
    private String url;



    public int getWiidth() {
        return wiidth;
    }

    public void setWiidth(int wiidth) {
        this.wiidth = wiidth;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
