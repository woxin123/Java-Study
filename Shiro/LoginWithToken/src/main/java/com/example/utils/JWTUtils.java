package com.example.utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class JWTUtils {
    /**
     * 公钥
     */
    private static String SECRET = "woxin";
    public static String createToken(String username, String password) throws Exception {
        // 签发时间
        Date iatDate = new Date();

        // 过期时间，一分钟过期
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE, 10);
        Date experiesDate = nowTime.getTime();

        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        String token = JWT.create()
                .withHeader(map)
                .withClaim("username", username)
                .withClaim("password", password)
                .withExpiresAt(experiesDate) // 设置过期的日期
                .withIssuedAt(iatDate) // 签发时间
                .sign(Algorithm.HMAC256(SECRET)); // 加密
        return token;
    }

    /**
     * 解密
     */

    public static Map<String, Claim> verifyToken(String token) throws UnsupportedEncodingException {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        DecodedJWT jwt = null;
        try {
            jwt = verifier.verify(token);
        } catch (Exception e) {
            throw new RuntimeException("登录过期");
        }
        return jwt.getClaims();
    }
}
