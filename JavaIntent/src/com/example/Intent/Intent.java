package com.example.Intent;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class Intent {

    public static String sendGet(String url, String param){
        String result = "";
        String urlName = url + "?" + param;
        try {
            URL realURL = new URL(urlName);
            // 打开和URL之间的连接
            URLConnection conn = realURL.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            // 建立实际的连接
            conn.connect();
            // 获取所有的响应头子段
//            Map<String, List<String>> map = conn.getHeaderFields();
//            // 遍历所有的响应头子段
//            for (String key : map.keySet()) {
//                System.out.println(key + "--->" + map.get(key));
//            }
            try (
                // 定义BufferedReader输入流来读取URL的响应
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        conn.getInputStream(), "UTF-8"))) {
                String line;
                while ((line = in.readLine()) != null) {
                    result += "\n" + line;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("发送GET请求出现异常");
        }
        return result;
    }
    public static void main(String[] args){
        // 发送GET请求
        String s = Intent.sendGet("http://localhost:8080/Test2", null);
        System.out.println(s);
    }
}