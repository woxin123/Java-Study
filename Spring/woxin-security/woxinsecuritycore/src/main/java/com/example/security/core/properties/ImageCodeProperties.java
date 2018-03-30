package com.example.security.core.properties;

public class ImageCodeProperties extends SmsCodeProperties{

    private int wiidth = 67;
    private int height = 23;

    public ImageCodeProperties() {
        setLength(4);
    }
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

}
