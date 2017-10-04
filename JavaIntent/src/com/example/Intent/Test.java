package com.example.Intent;

import com.google.gson.JsonObject;

public class Test {
    public static void main(String[] args) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("userName", "孟晨");
        System.out.println(jsonObject.toString());
    }
}
