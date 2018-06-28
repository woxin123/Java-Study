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

public class MyWebMagicTest04 implements PageProcessor {
    private Site site = Site
            .me()
            .addHeader("Referer", "http://222.24.62.120/xskbcx.aspx?xh=04161031&xm=%C3%CF%B3%BF&gnmkdm=N121603")
            .addHeader("Host", "222.24.62.120")
            .addCookie("ASP.NET_SessionId","lsvavb45kkbjyffcasncx255");


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
        Map<String, Object> map = new HashMap<>();
        NameValuePair[] values = new NameValuePair[4];
        values[0] = new BasicNameValuePair( "__EVENTTARGET", "");
        values[1] = new BasicNameValuePair("__EVENTARGUMENT", "");
        values[2] = new BasicNameValuePair("__VIEWSTATE", "dDwxNTM4MTc2MTcwO3Q8O2w8aTwxPjs+O2w8dDw7bDxpPDE+O2k8Mj47aTw0PjtpPDc+O2k8OT47aTwxMT47aTwxMz47aTwxNT47aTwyMj47aTwyNj47aTwyOD47aTwzMD47aTwzND47aTwzNj47aTw0MD47PjtsPHQ8cDxwPGw8VGV4dDs+O2w8XGU7Pj47Pjs7Pjt0PHQ8cDxwPGw8RGF0YVRleHRGaWVsZDtEYXRhVmFsdWVGaWVsZDs+O2w8eG47eG47Pj47Pjt0PGk8Mj47QDwyMDE3LTIwMTg7MjAxNi0yMDE3Oz47QDwyMDE3LTIwMTg7MjAxNi0yMDE3Oz4+O2w8aTwwPjs+Pjs7Pjt0PHQ8OztsPGk8MT47Pj47Oz47dDxwPHA8bDxUZXh0Oz47bDzlrablj7fvvJowNDE2MTAzMTs+Pjs+Ozs+O3Q8cDxwPGw8VGV4dDs+O2w85aeT5ZCN77ya5a2f5pmoOz4+Oz47Oz47dDxwPHA8bDxUZXh0Oz47bDzlrabpmaLvvJrorqHnrpfmnLrlrabpmaI7Pj47Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPOS4k+S4mu+8muiuoeeul+acuuenkeWtpuS4juaKgOacrzs+Pjs+Ozs+O3Q8cDxwPGw8VGV4dDs+O2w86KGM5pS/54+t77ya6K6h56eRMTYwMTs+Pjs+Ozs+O3Q8O2w8aTwxPjtpPDM+Oz47bDx0PDtsPGk8MD47PjtsPHQ8O2w8aTwwPjs+O2w8dDxAMDw7Ozs7Ozs7Ozs7Pjs7Pjs+Pjs+Pjt0PDtsPGk8MD47PjtsPHQ8O2w8aTwwPjs+O2w8dDxAMDw7Ozs7Ozs7Ozs7Pjs7Pjs+Pjs+Pjs+Pjt0PDtsPGk8MT47PjtsPHQ8QDA8Ozs7Ozs7Ozs7Oz47Oz47Pj47dDxwPGw8VmlzaWJsZTs+O2w8bzxmPjs+PjtsPGk8MT47PjtsPHQ8QDA8Ozs7Ozs7Ozs7Oz47Oz47Pj47dDxAMDxwPHA8bDxQYWdlQ291bnQ7XyFJdGVtQ291bnQ7XyFEYXRhU291cmNlSXRlbUNvdW50O0RhdGFLZXlzOz47bDxpPDE+O2k8MD47aTwwPjtsPD47Pj47Pjs7Ozs7Ozs7Ozs+Ozs+O3Q8O2w8aTwwPjs+O2w8dDw7bDxpPDA+Oz47bDx0PEAwPHA8cDxsPFBhZ2VDb3VudDtfIUl0ZW1Db3VudDtfIURhdGFTb3VyY2VJdGVtQ291bnQ7RGF0YUtleXM7PjtsPGk8MT47aTwxPjtpPDE+O2w8Pjs+Pjs+Ozs7Ozs7Ozs7Oz47bDxpPDA+Oz47bDx0PDtsPGk8MT47PjtsPHQ8O2w8aTwwPjtpPDE+O2k8Mj47aTwzPjtpPDQ+O2k8NT47aTw2Pjs+O2w8dDxwPHA8bDxUZXh0Oz47bDzmlbDlrZfpgLvovpHor77nqIvorr7orqE7Pj47Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPOavm+awuOavhTs+Pjs+Ozs+O3Q8cDxwPGw8VGV4dDs+O2w8Mi4wOz4+Oz47Oz47dDxwPHA8bDxUZXh0Oz47bDwwMS0xODs+Pjs+Ozs+O3Q8cDxwPGw8VGV4dDs+O2w8Jm5ic3BcOzs+Pjs+Ozs+O3Q8cDxwPGw8VGV4dDs+O2w8Jm5ic3BcOzs+Pjs+Ozs+O3Q8cDxwPGw8VGV4dDs+O2w8Jm5ic3BcOzs+Pjs+Ozs+Oz4+Oz4+Oz4+Oz4+Oz4+O3Q8QDA8cDxwPGw8UGFnZUNvdW50O18hSXRlbUNvdW50O18hRGF0YVNvdXJjZUl0ZW1Db3VudDtEYXRhS2V5czs+O2w8aTwxPjtpPDA+O2k8MD47bDw+Oz4+Oz47Ozs7Ozs7Ozs7Pjs7Pjt0PDtsPGk8MD47PjtsPHQ8O2w8aTwwPjs+O2w8dDxAMDxwPHA8bDxQYWdlQ291bnQ7XyFJdGVtQ291bnQ7XyFEYXRhU291cmNlSXRlbUNvdW50O0RhdGFLZXlzOz47bDxpPDE+O2k8MT47aTwxPjtsPD47Pj47Pjs7Ozs7Ozs7Ozs+O2w8aTwwPjs+O2w8dDw7bDxpPDE+Oz47bDx0PDtsPGk8MD47aTwxPjtpPDI+O2k8Mz47aTw0Pjs+O2w8dDxwPHA8bDxUZXh0Oz47bDwyMDE3LTIwMTg7Pj47Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPDI7Pj47Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPOaVsOWtl+mAu+i+keivvueoi+iuvuiuoTs+Pjs+Ozs+O3Q8cDxwPGw8VGV4dDs+O2w85q+b5rC45q+FOz4+Oz47Oz47dDxwPHA8bDxUZXh0Oz47bDwyLjA7Pj47Pjs7Pjs+Pjs+Pjs+Pjs+Pjs+Pjs+Pjs+Pjs+3qZy+zJYLdyllYBhCXXgItMwNWY=");
        values[3] = new BasicNameValuePair("xqd", "1");
        String url = "http://222.24.62.120/xskbcx.aspx?xh=04161031&xm=%C3%CF%B3%BF&gnmkdm=N121603";
        Request request = new Request(url);
        request.setExtras(map);
        request.setMethod(HttpConstant.Method.POST);
        Spider.create(new MyWebMagicTest04())
                .addUrl("http://222.24.62.120/xskbcx.aspx?xh=04161031&xm=%C3%CF%B3%BF&gnmkdm=N121603").run();
    }

}
