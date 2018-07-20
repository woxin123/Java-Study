package top.mcwebsite.httpclient;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * 使用URIBuilder构建uri
 */
public class HttpClientDemoTest2 {

    public static void main(String[] args) throws URISyntaxException {
        // 使用URIBuilder构建uri
        URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("www.zhihu.com")
                .setPath("/search")
                // 自动将中文转换为Base64编码
                .setParameter("q", "我不是药神")
                .setParameter("type", "content")
                .build();
        HttpGet httpGet = new HttpGet(uri);
        System.out.println(httpGet.getURI());
    }

}
