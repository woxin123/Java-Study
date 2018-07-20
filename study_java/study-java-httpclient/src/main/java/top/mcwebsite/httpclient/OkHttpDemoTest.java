package top.mcwebsite.httpclient;

import okhttp3.*;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.file.Files;
import java.util.*;



/**
 * 模拟登录
 */
public class OkHttpDemoTest {
    // 设置OKHttpClient自动管理Cookie
    private static OkHttpClient mOkHttpClient = new OkHttpClient.Builder().cookieJar(new CookieJar() {
        private final HashMap<String, List<Cookie>> cookieStore = new HashMap<>();

        @Override
        public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
            cookieStore.put(url.host(), cookies);
        }

        @Override
        public List<Cookie> loadForRequest(HttpUrl url) {
            List<Cookie> cookies = cookieStore.get(url.host());
            return cookies != null ? cookies : new ArrayList<Cookie>();
        }
    }).build();

    public static final String BASEURL = "http://222.24.62.120/";
    public static final String LOGIN = "default2.aspx";
    public static final String HIDDEN_NAME = "__VIEWSTATE";
    public static final String HIDDEN_VALUE = "dDwxNTMxMDk5Mzc0Ozs+lYSKnsl/mKGQ7CKkWFJpv0btUa8=";
    public static final String LOGIN_USERNAME = "txtUserName";
    public static final String LOGIN_PASSWORD = "TextBox2";
    public static final String LOGIN_VALIDE_CODE = "txtSecretCode";
    public static final String URL_VALIDE_CODE = "CheckCode.aspx";

    public static void main(String[] args) throws IOException {


        Request request = new Request.Builder().url(BASEURL).build();
        Call call = mOkHttpClient.newCall(request);
        try {
            Response response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Request validateRequest = new Request.Builder()
                .url(BASEURL + URL_VALIDE_CODE).build();
        Call validateCall = mOkHttpClient.newCall(validateRequest);
        try {
            Response validateResponse = validateCall.execute();
            File file = new File("validateCode.png");
            if (file.exists())
                file.delete();
            InputStream inputStream = validateResponse.body().byteStream();
            Files.copy(inputStream, file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        FormBody.Builder formBodyBuilder = new FormBody.Builder();
        formBodyBuilder.add(HIDDEN_NAME, HIDDEN_VALUE);
        formBodyBuilder.add(LOGIN_USERNAME, "04161031");
        formBodyBuilder.add("TextBox1", "04161031");
        formBodyBuilder.add(LOGIN_PASSWORD, "1293141942qwer");
        formBodyBuilder.add("RadioButtonList1", "学生");
        formBodyBuilder.add("Button1", "");
        Scanner scanner = new Scanner(System.in);
        String code = scanner.nextLine();
        formBodyBuilder.add(LOGIN_VALIDE_CODE, code);
        RequestBody requestBody = formBodyBuilder.build();
        Request loginRequest = new Request.Builder().url(BASEURL + LOGIN)
                .post(requestBody)
                .build();
        // 不同于httpClient的是Okhttp会自动跳转
        Response response = mOkHttpClient.newCall(loginRequest).execute();
        try {
            byte[] bytes = new byte[1024];
            InputStream is = response.body().byteStream();
            while (is.read(bytes) != -1)
                System.out.println(new String(bytes, "GBK"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (response.code() == 302) {
            System.out.println("登录成功");
        }


    }

}
