package com.example.Intent;

import sun.net.www.protocol.http.HttpURLConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HTML4399 {
    public static String getCharset(String strurl) throws IOException {
        // 定义URL对象
        URL url = new URL(strurl);
        // 获取http连接对象
        HttpURLConnection urlConnection = (HttpURLConnection) url
                .openConnection();
        urlConnection.connect();
        // 网页编码
        String strencoding = null;

        /**
         * 首先根据header信息，判断页面编码
         */
        // map存放的是header信息(url页面的头信息)
        Map<String, List<String>> map = urlConnection.getHeaderFields();
        Set<String> keys = map.keySet();
        Iterator<String> iterator = keys.iterator();

        // 遍历,查找字符编码
        String key = null;
        String tmp = null;
        while (iterator.hasNext()) {
            key = iterator.next();
            tmp = map.get(key).toString().toLowerCase();
            // 获取content-type charset
            if (key != null && key.equals("Content-Type")) {
                int m = tmp.indexOf("charset=");
                if (m != -1) {
                    strencoding = tmp.substring(m + 8).replace("]", "");
                    return strencoding;
                }
            }
        }
        return "出错";
    }
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.4399.com");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        // 获取响应服务器的代码
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

    }
}
