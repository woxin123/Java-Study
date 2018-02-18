package com.example.util;

import com.auth0.jwt.interfaces.Claim;
import com.example.utils.JWTUtils;

import java.util.HashMap;
import java.util.Map;

public class JwtTokenTest {
    public static void main(String[] args) throws Exception {
        String token = JWTUtils.createToken();
        System.out.println(token);
        Thread.sleep(Long.parseLong("60001"));
        Map <String, Claim> claims = JWTUtils.verifyToken(token);
        System.out.println(claims.get("name").asString());
        System.out.println(claims.get("age").asString());


    }
}
