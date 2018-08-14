package top.mcwebsite.httpclient;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author mengchen
 */
public class HttpClientDemoTest {
    public static void main(String[] args) throws IOException {
        // 创建一个HttpClient，相当于浏览器
        HttpClient httpClient = HttpClients.createDefault();
        // 创建一个HttpGet用于发送GET请求
        HttpGet httpGet = new HttpGet("https://home.firefoxchina.cn/");
        // 使用HttpClient将HttpClient发送出去
        HttpResponse response = httpClient.execute(httpGet);
        // 获得httpEntity
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            InputStream ips = entity.getContent();
            int i;
            byte[] bytes = new byte[2048];
            while ((i = ips.read(bytes)) != -1) {
                System.out.println(new String(bytes, "UTF-8"));
            }
        }
    }
}
