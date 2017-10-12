package com.example.Intent;

import net.sf.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class LoginTest {

    public static void sendPost(String url, String param) {
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoInput(true);
            conn.setDoOutput(true);
            try (
                    PrintWriter out = new PrintWriter(conn.getOutputStream())
                    ) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("account", "1293141942");
                jsonObject.put("password", "abcdefg");
                System.out.println(jsonObject.toString());
                out.println(jsonObject.toString());
            }
            try (
                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))
                    ) {
                System.out.println(in.readLine());
            }
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        sendPost("http://localhost:8080/Login", null);
    }
}
