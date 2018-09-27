package top.mcwebsite.start_webmagic;


import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.util.concurrent.TimeUnit;

/**
 * @author mengchen
 * @time 18-8-6 下午7:04
 */
public class AddHitsCSDN implements PageProcessor {

    private Site site = new Site()
            .addHeader("Host", "blog.csdn.net")
            .addHeader("User-Agent", "Mozilla/5.0(compatible;MSIE9.0;WindowsNT6.1;Trident/5.0)")
            .addHeader("Referer", "https://blog.csdn.net/starexplode/article/details/81058988")
            .addHeader("Cookie", "uuid_tt_dd=10_19650868290-1532396740717-486002; __yadk_uid=Q0cJiMfFTL8zEOXkfjg8CbXoQgRnmEOU; __utma=17226283.300040390.1532950731.1532950731.1532950731.1; __utmz=17226283.1532950731.1.1.utmcsr=baidu|utmccn=(organic)|utmcmd=organic; ADHOC_MEMBERSHIP_CLIENT_ID1.0=0dcf91cf-5372-de3d-d58d-ce85e50c6b9c; UN=starexplode; Hm_ct_6bcd52f51e9b3dce32bec4a3997715ac=1788*1*PC_VC; smidV2=201807241030064274a55de6b1ff4bcf750dd312e99caa00b4b95ec7b4b7ba0; ARK_ID=JSa51e7cd352e07ab4f8706e72ca788f6fa51e; UserName=starexplode; UserInfo=XNwW4YBjhihGSNf9BXv0Tv2Zb9vCCEghxkEy0PAn%2F8XKz8fXEsJ%2FV9kZXfC67VdW0Q9qv%2F44Wd5R%2FLmte5tksDNy13eXTavwY9lUEjmHDi5a9histpoLzCxPJo9iXKTG; UserNick=%E6%98%9F%E6%AD%A6%E8%80%85; AU=460; BT=1537870804123; UserToken=XNwW4YBjhihGSNf9BXv0Tv2Zb9vCCEghxkEy0PAn%2F8XKz8fXEsJ%2FV9kZXfC67VdW0Q9qv%2F44Wd5R%2FLmte5tksDNy13eXTavwY9lUEjmHDi6S9mwoGaGbzfCnZDlLcSaRc3xb4lVUoKnS84hGbgEKXA1zKofiZbgfESxHjA5qTyg%3D; dc_session_id=10_1537874391850.560678; TY_SESSION_ID=0f1e3d43-d61e-432e-82ae-f9aac8df3246; dc_tos=pfptd9; Hm_lvt_6bcd52f51e9b3dce32bec4a3997715ac=1538019554,1538038088,1538039038,1538053101; Hm_lpvt_6bcd52f51e9b3dce32bec4a3997715ac=1538053101");

    @Override
    public void process(Page page) {
        Html html = page.getHtml();
//        System.out.println(html);
        System.out.println(html.xpath("//*[@id=\"mainBox\"]/main/div[1]/div/div/div[2]/div[1]/span[2]/text()"));
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        while (true) {

            Spider.create(new AddHitsCSDN()).addUrl("https://blog.csdn.net/starexplode/article/details/81058988")
                    .addUrl("https://blog.csdn.net/starexplode/article/details/81584562")
                    .run();
            try {
                TimeUnit.SECONDS.sleep(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
