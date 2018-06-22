package top.mcwebsite.start_webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class MyWebMagicTest04 implements PageProcessor {
    private Site site = Site
            .me()
            .setDomain("blog.csdn.net")
            .setSleepTime(300)
            .setUserAgent(
                    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31")
            // 【重要】：以下信息可以模拟登陆，信息全部来自于浏览器
            .addCookie("AU", "CA9")
            .addCookie("BT", "1475675181189")
            .addCookie("UD", "self-control%2Cself-free")
            .addCookie("UE", "wgyscsf@163.com")
            .addCookie("UN", "wgyscsf")
            .addCookie(
                    "UserInfo",
                    "*****")
            .addCookie("UserName", "wgyscsf")
            .addCookie("UserNick", "%E5%89%A9%E8%8F%9C%E5%89%A9%E9%A5%AD")
            .addCookie("__message_cnel", "0")
            .addCookie("__message_district_code", "00000")
            .addCookie("__message_gu_msg_id", "0")
            .addCookie("__message_in_school", "0")
            .addCookie("__message_sys_msg_id", "0")
            .addCookie("access-token", "****")
            .addCookie("dc_session_id", "****")
            .addCookie("dc_tos", "oeku99")
            .addCookie("uuid", "****")
            .addCookie("uuid_tt_dd", "****");

    @Override
    public void process(Page page) {
        // 打印网页源码查看和登录之前有何区别，下面就可以进行页面解析了。
        System.out.println(page.toString());
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new MyWebMagicTest04()).addPipeline(null)
                .addUrl("http://blog.csdn.net/" + "wgyscsf").run();
    }

}
