package top.mcwebsite.start_webmagic.util;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * mengchen
 * 18-7-24 上午9:59
 */
public class JwUtils {
    private static CloseableHttpClient httpClient = null;
    public final static String BASE_URL = "http://jw1.hustwenhua.net/";

    public static CloseableHttpClient getHttpClient() {
        if (httpClient == null){
            httpClient = HttpClients.createDefault();
            return httpClient;
        }
        return httpClient;
    }
}
