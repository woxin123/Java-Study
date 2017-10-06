package com.example.Intent;

import net.sf.json.JSONObject;

public class Test {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userName", "孟晨");
        JSONObject jsonObject1 = JSONObject.fromObject(jsonObject.toString());
        String userName = (String) jsonObject1.get("userName");
        System.out.println(userName);
    }
}
