package com.example.Intent;

import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

public class Register {

    public static void sendPost(String url, String param) {
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
                    // 获取URLConnection对象对应的输出流
                    PrintWriter out = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(), "UTF-8"))
            ) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("account", "13572011907");
                jsonObject.put("password", "abcdefg");
                out.println(jsonObject.toString());
                out.flush();
            }
            try (
                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(),
                            "UTF-8"))
            ) {
                System.out.println(in.readLine());
            }
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        sendPost("http://localhost:8080/Register", null);
    }
}
