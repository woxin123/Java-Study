package top.mcwebsite.start_webmagic;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import top.mcwebsite.start_webmagic.util.HttpUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyWebMagicTest03 {

    static boolean result = false;

    public static void main(String[] args) {
        // 登陆页面，获取以及服务器传递必要的信息
        loginCsdnPager();
        // 登录后既可以进入登录后的页面
        try {
            loginedCsdnPager();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loginedCsdnPager() throws IOException {
        // 构造需要访问的页面
        HttpUriRequest httpUriRequest = new HttpPost("https://blog.csdn.net/starexplode");
        // 添加必要的信息
        httpUriRequest
                .setHeader("Accept",
                        "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        httpUriRequest.setHeader("Accept-Encoding", "gzip,deflate,sdch");
        httpUriRequest.setHeader("Accept-Language", "zh-CN,zh;q=0.8");
        httpUriRequest.setHeader("Connection", "keep-alive");
        // 模拟浏览器，否则CSDN服务器限制访问
        httpUriRequest
                .setHeader(
                        "User-Agent",
                        "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/35.0.1916.153 Safari/537.36");
        // 【特别注意】：这个一定需要和登录用同一个“httpClient”，不然会失败。登陆信息全部在“httpClient”中保存
        HttpResponse response = HttpUtils.httpClient.execute(httpUriRequest);
        InputStream is = response.getEntity().getContent();
        // 将InputStream转换成reader
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = "";
        String result = "";
        while ((line = br.readLine()) != null) {
            result += line;
        }
        br.close();
        // 这里获取了页面，然会进行解析处理
        System.out.println(result);
    }

    private static void loginCsdnPager() {
        String html = HttpUtils.sendGet("https://passport.csdn.net/account/login?ref=toolbar"); // 登录页面
        Document doc = Jsoup.parse(html);
        // 获取表单数据所在的节点
        Element form = doc.select(".user-pass").get(0);
        // 以下三个是服务器给的信息标记，必须具有该信息登录才有效
        String lt = form.select("input[name=lt]").get(0).val();
        String execution = form.select("input[name=execution]").get(0).val();
        String _eventId = form.select("input[name=_eventId]").get(0).val();

        // 开始构造登录信息：账号、密码、以及三个标记信息
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("username", "13572011907"));
        nameValuePairs.add(new BasicNameValuePair("password", "mengchen129314"));
        nameValuePairs.add(new BasicNameValuePair("lt", lt));
        nameValuePairs.add(new BasicNameValuePair("execution", execution));
        nameValuePairs.add(new BasicNameValuePair("_eventId", _eventId));

        // 开始请求CSDN服务器进行登录操作。一个简单的封装，直接获取返回结果
        String ret = HttpUtils.sendPost("https://passport.csdn.net/account/login?ref=toolbar", nameValuePairs);
        System.out.println(ret);
        // ret中会包含以下的信息，进行判断即可
        if (ret.indexOf("redirect_back") > -1) {
            System.out.println("登陆成功");
            result = true;
        } else if (ret.indexOf("登录太频繁") > -1){
            System.out.println("登录太频繁");
            return;
        } else {
            System.out.println("登录失败");
            return;
        }
    }

}
