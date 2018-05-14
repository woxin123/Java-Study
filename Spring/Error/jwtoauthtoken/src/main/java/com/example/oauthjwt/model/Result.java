package com.example.oauthjwt.model;

/**
 * @author: mengchen
 * Create by 18-4-20
 */
public class Result extends BaseModel {

    private int status;
    private String message;
    private Object data;


    public int getStatus() {
        return status;
    }

    public Result setStatus(int status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {

        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public Result setData(Object data) {
        this.data = data;
        return this;
    }
}
