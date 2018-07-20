package top.mcwebsite.start_webmagic;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.utils.HttpConstant;

import java.util.HashMap;
import java.util.Map;

public class MyWebMagicTest05 implements PageProcessor {
    private Site site = Site
            .me()
            .addHeader("Referer", "http://222.24.62.120/xskbcx.aspx?xh=04161031&xm=%C3%CF%B3%BF&gnmkdm=N121603")
            .addHeader("Host", "222.24.62.120")
            .addCookie("ASP.NET_SessionId","nmtp5455ou5nkh3x2ascobid");


    @Override
    public void process(Page page) {
        // 打印网页源码查看和登录之前有何区别，下面就可以进行页面解析了。
        System.out.println(page.toString());
//        String name = page.getHtml().xpath("//div[@class='info']/ul/li/em/span/text()").get();
//        System.out.println(name);
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {

        Spider.create(new MyWebMagicTest05())
                .addUrl("http://222.24.62.120/xs_main.aspx?xh=04161031").run();
    }

}
