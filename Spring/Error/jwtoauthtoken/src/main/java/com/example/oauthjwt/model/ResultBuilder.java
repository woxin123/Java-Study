package com.example.oauthjwt.model;

/**
 * @author: mengchen
 * Create by 18-4-20
 */
public class ResultBuilder extends BaseModel {

    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static Result genSuccessResult() {
        return new Result()
                .setStatus(0)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    public static Result genSuccessResult(Object data) {
        return new Result()
                .setStatus(0)
                .setData(data);
    }

    public static Result genSuccessResult(String message) {
        return new Result()
                .setStatus(0)
                .setMessage(message);
    }

    public static Result genFailResult(String message) {
        return new Result()
                .setStatus(-1)
                .setMessage(message);
    }
}
