package top.mcwebsite.start_webmagic;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

import java.util.List;


/**
 * @author mengchen
 * @time 19-2-27 下午2:57
 */
public class HtmlParseTest01 {
    public static void main(String[] args) {
        String html = "<body>\n" +
                "  <p>昨天，小米9成功发布！</p >\n" +
                "  <p>好看又能打，小米9自身功不可没~</p >\n" +
                "  <p>现场沸腾的除了米粉，就连很多小米手机品牌代言人王源的汤圆粉也兴奋异常！</p >\n" +
                "  <p>特别是小米9王源独家定制主题，内置“王源同学”动态形象~</p >\n" +
                "  <p style=\"text-align: center;\">\n" +
                "    < img src=\"http://cdn.fds.api.xiaomi.com/b2c-bbs/cn/attachment/058d22a147d78f50779fc775fb4b4514.jpg\" width=\"914\" height=\"914\" /></p >\n" +
                "  <p>而现场播放王源出演的小米9广告片时，引得全场小汤圆们的疯狂尖叫Σ(っ °Д °;)っ</p >\n" +
                "  <p>如果还没看够，那么不妨再来看看呀~</p >\n" +
                "  <p style=\"text-align: center;\">\n" +
                "    <embed type=\"application/x-shockwave-flash\" class=\"edui-faked-video\" pluginspage=\"http://www.macromedia.com/go/getflashplayer\" src=\"https://imgcache.qq.com/tencentvideo_v1/playerv3/TPout.swf?max_age=86400&v=20161117&vid=m0840vb9vzp&auto=0\" width=\"560\" height=\"380\" wmode=\"transparent\" play=\"true\" loop=\"false\" menu=\"false\" allowaccess=\"never\" allowfullscreen=\"true\" /></p >\n" +
                "  <p style=\"text-align: center;\">一起再来回顾下</p >\n" +
                "  <p style=\"text-align: center;\">王源在小米9发布会PPT中</p >\n" +
                "  <p style=\"text-align: center;\">青春洋溢\n" +
                "    <span style=\"\">\n" +
                "      <span style=\"background-color: rgb(255, 255, 255);\">的模样</span></span>\n" +
                "  </p >\n" +
                "  <p style=\"text-align: center;\">\n" +
                "    <span style=\"\">\n" +
                "      <span style=\"background-color: rgb(255, 255, 255);\">\n" +
                "        <img src=\"http://cdn.fds.api.xiaomi.com/b2c-bbs/cn/attachment/ccd2d5862e0ca86a1a77458c5f9d5ff6.jpg\" width=\"1600\" height=\"640\" /></span>\n" +
                "    </span>\n" +
                "  </p >\n" +
                "  <p>\n" +
                "    <span style=\"\">\n" +
                "      <span style=\"background-color: rgb(255, 255, 255);\"></span>\n" +
                "    </span>\n" +
                "  </p >\n" +
                "  <p style=\"text-align: center\">\n" +
                "    <img src=\"http://cdn.fds.api.xiaomi.com/b2c-bbs/cn/attachment/bf1a7371416ca9553727f6d85b1859c5.jpg\" width=\"1600\" height=\"640\" />\n" +
                "    <img src=\"http://cdn.fds.api.xiaomi.com/b2c-bbs/cn/attachment/bc1c1be2695248a0fca70f691edc35ca.jpg\" width=\"1600\" height=\"640\" />\n" +
                "    <img src=\"http://cdn.fds.api.xiaomi.com/b2c-bbs/cn/attachment/892f41ad7a2a681c69f5fc2ab763c19b.jpg\" width=\"1024\" height=\"410\" /></p >\n" +
                "  <p style=\"text-align: center;\">\n" +
                "    <span style=\"\">\n" +
                "      <span style=\"background-color: rgb(255, 255, 255);\">\n" +
                "        <img src=\"http://cdn.fds.api.xiaomi.com/b2c-bbs/cn/attachment/11fd9c282be5bd6f3e40d3d55bd1a8dd.jpg\" width=\"1024\" height=\"410\" /></span>\n" +
                "    </span>\n" +
                "    <br/></p >\n" +
                "  <p style=\"text-align: center;\">\n" +
                "    <span style=\"\">\n" +
                "      <span style=\"background-color: rgb(255, 255, 255);\">\n" +
                "        <img src=\"http://cdn.fds.api.xiaomi.com/b2c-bbs/cn/attachment/701cdfac656bd621736e1fff2716030c.jpg\" width=\"3200\" height=\"1280\" /></span>\n" +
                "    </span>\n" +
                "  </p >\n" +
                "  <p style=\"text-align: center;\">\n" +
                "    <span style=\"\">\n" +
                "      <span style=\"background-color: rgb(255, 255, 255);\">只有PPT中的当然不能算什么惊喜</span></span>\n" +
                "  </p >\n" +
                "  <p style=\"text-align: center;\">\n" +
                "    <span style=\"\">\n" +
                "      <span style=\"background-color: rgb(255, 255, 255);\">本次特地整理了王源在小米9发布会现场和雷总的实拍图</span></span>\n" +
                "  </p >\n" +
                "  <p style=\"text-align: center;\">\n" +
                "    <span style=\"\">\n" +
                "      <span style=\"background-color: rgb(255, 255, 255);\">喜欢的小汤圆快把这个翩翩少年带走吧~</span></span>\n" +
                "  </p >\n" +
                "  <p style=\"text-align: center;\">\n" +
                "    <span style=\"\">\n" +
                "      <span style=\"background-color: rgb(255, 255, 255);\"></span>\n" +
                "    </span>\n" +
                "  </p >\n" +
                "  <p style=\"text-align: center\">\n" +
                "    <img src=\"http://cdn.fds.api.xiaomi.com/b2c-bbs/cn/attachment/850865351e25f08f3ef2795594b8fbfc.jpg\" width=\"1600\" height=\"1046\" /></p >\n" +
                "  <p style=\"text-align: center\">\n" +
                "    <img src=\"http://cdn.fds.api.xiaomi.com/b2c-bbs/cn/attachment/1cda913150cd66bb8d3e7f098c9bb89f.jpg\" width=\"1600\" height=\"950\" /></p >\n" +
                "  <p style=\"text-align: center\">\n" +
                "    <img src=\"http://cdn.fds.api.xiaomi.com/b2c-bbs/cn/attachment/5d18e51dfd97534e4d860116a8a2f791.jpg\" width=\"1600\" height=\"1066\" />\n" +
                "    <img src=\"http://cdn.fds.api.xiaomi.com/b2c-bbs/cn/attachment/3af02e74d333ea8e5d3bc14c29bb219e.jpg\" width=\"1600\" height=\"1066\" /></p >\n" +
                "  <p style=\"text-align: center\">\n" +
                "    <img src=\"http://cdn.fds.api.xiaomi.com/b2c-bbs/cn/attachment/d90ef8fbd586b00fc9d862c8452e630f.jpg\" width=\"1600\" height=\"1066\" />\n" +
                "    <img src=\"http://cdn.fds.api.xiaomi.com/b2c-bbs/cn/attachment/4aaa79392c56b4a6f28791d79147571d.jpg\" width=\"3520\" height=\"4874\" /></p >\n" +
                "  <p style=\"text-align: center;\">别着急，最好的当然在最好</p >\n" +
                "  <p style=\"text-align: center;\">回复可见王源壁纸级单人现场照！</p >\n" +
                "  <p style=\"text-align: center;\">\n" +
                "    <span style=\"text-align: center;\">心动就快来参与互动吧( •̀ ω •́ )y</span></p >\n" +
                "  <p style=\"text-align: center;\">\n" +
                "    <span style=\"text-align: center;\">\n" +
                "      <img src=\"http://cdn.fds.api.xiaomi.com/b2c-bbs/cn/attachment/c434a77cc9bddda3c1d4dcb253767d75.jpg\" width=\"4664\" height=\"3109\" /></span>\n" +
                "  </p >\n" +
                "  <p>[hide]</p >\n" +
                "  <p>壁纸级别单人现场照，送给愿意跟帖互动的小汤圆，原图哟~</p >\n" +
                "  <p>\n" +
                "    <span style=\"line-height: 22px; width: 500px; border-top: 1px solid rgb(223, 223, 223); border-right: 1px solid rgb(223, 223, 223); border-bottom: 1px solid rgb(223, 223, 223); border-image: initial; border-left: none; margin: 20px 0px; display: block; padding: 10px;\">\n" +
                "      <span style=\"display:block;font-style:normal\">下载附件</span>\n" +
                "      <a style=\"display: inline-block; color:#333;text-decoration: none; margin-top: 0px;\" href=\" \" title=\"小汤圆最想要的现场版.zip\">小汤圆最想要的现场版.zip</a >\n" +
                "      <span style=\"display: inline-block;color:#8c8c8c;margin-left:10px;\">( 15920.64MB )</span></span>\n" +
                "  </p >\n" +
                "  <p>\n" +
                "    <span style=\"text-align: center;\">[/hide]</span></p >\n" +
                "  <p>\n" +
                "    <span style=\"text-align: center;\">\n" +
                "      <br/></span>\n" +
                "  </p >\n" +
                "  <p style=\"text-align: center;\">\n" +
                "    <span style=\"text-align: center;\">跟帖留言：</span></p >\n" +
                "  <p style=\"text-align: center;\">\n" +
                "    <strong>\n" +
                "      <span style=\"text-align: center;\">“你对小米9长得好看超级能打的真实感受”</span></strong>\n" +
                "  </p >\n" +
                "  <p style=\"text-align: center;\">\n" +
                "    <span style=\"text-align: center;\">我们还将随机送出...</span></p >\n" +
                "  <p style=\"text-align: center;\">\n" +
                "    <strong>\n" +
                "      <span style=\"text-align: center; color: rgb(110, 169, 48);\">小米9王源定制手机壳5个!!!</span></strong>\n" +
                "  </p >\n" +
                "  <p style=\"text-align: center;\">\n" +
                "    <strong>\n" +
                "      <span style=\"text-align: center; color: rgb(110, 169, 48);\">王源定制款抱枕5个!!!</span></strong>\n" +
                "  </p >\n" +
                "  <p style=\"text-align: center;\">\n" +
                "    <strong>\n" +
                "      <span style=\"text-align: center; color: rgb(110, 169, 48);\">小米社区金币5个!!!</span></strong>\n" +
                "  </p >\n" +
                "  <p style=\"text-align: center;\">\n" +
                "    <span style=\"text-align: center;\">幸运之神的会青睐谁呢？</span></p >\n" +
                "</body>";
        Document doc = Jsoup.parse(html);
        Element body = doc.body();
        System.out.println(body.childNodes());
        diguiParse(body.childNodes());
    }

    private static void diguiParse(List<Node> nodes) {
        for (Node node : nodes) {
            System.out.println(node.nodeName());
            if (node.childNodeSize() == 0) {
                System.out.println(node.);
            }
            diguiParse(node.childNodes());
        }
    }
}
