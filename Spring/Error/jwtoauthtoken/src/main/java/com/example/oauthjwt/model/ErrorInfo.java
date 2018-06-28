package com.example.oauthjwt.model;

/**
 * @author: mengchen
 * Create by 18-4-20
 */
public class ErrorInfo<T> {

    private Integer code;

    private String message;

    private String url;

    private T data;



    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}