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
            .addHeader("Cookie", "TY_SESSION_ID=99cd964a-e540-4d27-b37b-8ea2b4cada16; BAIDU_SSP_lcr=https://www.baidu.com/link?url=LHbMdCmtiBPfYcZzjza8oBC0O7Dbx47bBkyhDNCJcIJ-t7xtwWzCvsTEgvPfSVnSm-eUMkPYAnIIztvwH3IuNK&wd=&eqid=f7bf6ed600089684000000035b682a3e; uuid_tt_dd=10_19650868290-1532396740717-486002; __yadk_uid=Q0cJiMfFTL8zEOXkfjg8CbXoQgRnmEOU; __utma=17226283.300040390.1532950731.1532950731.1532950731.1; __utmz=17226283.1532950731.1.1.utmcsr=baidu|utmccn=(organic)|utmcmd=organic; Hm_ct_6bcd52f51e9b3dce32bec4a3997715ac=1788*1*PC_VC; dc_session_id=10_1533517761559.763254; UserName=starexplode; UserInfo=XNwW4YBjhihGSNf9BXv0Tv2Zb9vCCEghxkEy0PAn%2F8XKz8fXEsJ%2FV9kZXfC67VdW0Q9qv%2F44Wd5R%2FLmte5tksDNy13eXTavwY9lUEjmHDi5a9histpoLzCxPJo9iXKTG; UserNick=%E6%98%9F%E6%AD%A6%E8%80%85; UN=starexplode; AU=460; BT=1533554194851; UserToken=XNwW4YBjhihGSNf9BXv0Tv2Zb9vCCEghxkEy0PAn%2F8XKz8fXEsJ%2FV9kZXfC67VdW0Q9qv%2F44Wd5R%2FLmte5tksDNy13eXTavwY9lUEjmHDi6S9mwoGaGbzfCnZDlLcSaRc3xb4lVUoKnS84hGbgEKXA1zKofiZbgfESxHjA5qTyg%3D; smidV2=201807241030064274a55de6b1ff4bcf750dd312e99caa00b4b95ec7b4b7ba0; dc_tos=pd1e6h; Hm_lvt_6bcd52f51e9b3dce32bec4a3997715ac=1533542800,1533546118,1533553219,1533554095; Hm_lpvt_6bcd52f51e9b3dce32bec4a3997715ac=1533554442");

    @Override
    public void process(Page page) {
        Html html = page.getHtml();
        System.out.println(html.xpath("//*[@id=\"mainBox\"]/main/div[1]/div[2]/div/div/span/text()"));
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Spider.create(new AddHitsCSDN()).addUrl("https://blog.csdn.net/starexplode/article/details/81058988")
                    .run();
        }
    }
}
