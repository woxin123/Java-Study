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
            .addHeader("Cookie", "uuid_tt_dd=10_19650868290-1531473331811-634250; __yadk_uid=XSRW2tIHoAyXUFoFjWTas1lcIzbkElJY; ADHOC_MEMBERSHIP_CLIENT_ID1.0=8be64aae-39ff-4fa9-3af8-68ce9d29e0c7; smidV2=20180716005918c07d0f9e2b6d40f8d5c3f126d1741ee600c56d47b57cc7630; UN=starexplode; Hm_ct_6bcd52f51e9b3dce32bec4a3997715ac=1788*1*PC_VC; UM_distinctid=164b2b8055d5b7-09ee2560f5d7cb-3a760e5d-100200-164b2b8055ea4e; CNZZDATA1259587897=1701924511-1532001486-https%253A%252F%252Fwww.baidu.com%252F%7C1532001486; dc_session_id=10_1539767032992.927863; TY_SESSION_ID=094aa1ba-4798-49d9-a45c-e0c85e3c41be; Hm_lvt_6bcd52f51e9b3dce32bec4a3997715ac=1539073403,1539073532,1539767034,1541123668; UserName=starexplode; UserInfo=XNwW4YBjhihGSNf9BXv0Tv2Zb9vCCEghxkEy0PAn%2F8XKz8fXEsJ%2FV9kZXfC67VdW0Q9qv%2F44Wd5R%2FLmte5tksDNy13eXTavwY9lUEjmHDi5a9histpoLzCxPJo9iXKTG; UserNick=%E6%98%9F%E6%AD%A6%E8%80%85; AU=460; BT=1541123673185; UserToken=XNwW4YBjhihGSNf9BXv0Tv2Zb9vCCEghxkEy0PAn%2F8XKz8fXEsJ%2FV9kZXfC67VdW0Q9qv%2F44Wd5R%2FLmte5tksDNy13eXTavwY9lUEjmHDi6S9mwoGaGbzfCnZDlLcSaRc3xb4lVUoKnS84hGbgEKXA1zKofiZbgfESxHjA5qTyg%3D; dc_tos=phjmqr; Hm_lpvt_6bcd52f51e9b3dce32bec4a3997715ac=1541123812");

    @Override
    public void process(Page page) {
        Html html = page.getHtml();
        System.out.println(html.xpath("//*[@id=\"mainBox\"]/main/div[1]/div/div/div[2]/div[1]/span[2]/text()"));
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        while (true) {

            Spider.create(new AddHitsCSDN()).addUrl("https://blog.csdn.net/starexplode/article/details/82985388")
                    .addUrl("https://blog.csdn.net/starexplode/article/details/83216427")
                    .addUrl("https://blog.csdn.net/starexplode/article/details/83042760")
                    .run();
            try {
                TimeUnit.SECONDS.sleep(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
