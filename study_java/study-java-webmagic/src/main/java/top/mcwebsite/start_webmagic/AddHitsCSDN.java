package top.mcwebsite.start_webmagic;


import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author mengchen
 * @time 18-8-6 下午7:04
 */
public class AddHitsCSDN implements PageProcessor {

    private Site site = new Site();

    @Override
    public void process(Page page) {
        Html html = page.getHtml();
        System.out.println(html);
        Document document = html.getDocument();
        Element body = document.body();
        body.childNodes();
        test(body.childNodes());

    }

    private void test(List<Node> nodes) {
        for (Node node : nodes) {
            System.out.println(node.nodeName());
            List<Node> nodeList = node.childNodes();
            if (nodeList.isEmpty()) {
                System.out.println(node.unwrap());
                System.out.println(node.toString());
            }
            test(nodeList);
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        while (true) {

            Spider.create(new AddHitsCSDN()).addUrl("http://www.xiyou.edu.cn/")
                    .run();
            try {
                TimeUnit.SECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
