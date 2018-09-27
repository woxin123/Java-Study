package top.mcwebsite.url_code;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author mengchen
 * @time 18-9-8 下午6:40
 */
public class URLCode {
    public static void main(String[] args) throws UnsupportedEncodingException {
//        https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&tn=91348340_hao_pg&wd=%E7%99%BD%E6%95%AC%E4%BA%AD&oq=%25E6%259C%2589%25E9%2581%2593%25E4%25BA%2591%25E7%25AC%2594%25E8%25AE%25B0%2520deppin&rsv_pq=de3e350900000683&rsv_t=2aa2Lv2ifGZ2Asc03xwBMzxEiC78fruzBv9CrrnI2SqFgcSiwUNbfuV%2BsODxI3PHDBHCie%2FV&rqlang=cn&rsv_enter=1&inputT=4909&rsv_sug3=120&rsv_sug1=75&rsv_sug7=001&rsv_n=2&bs=%E6%9C%89%E9%81%93%E4%BA%91%E7%AC%94%E8%AE%B0%20deppin
        String string = URLDecoder.decode("%E7%99%BD%E6%95%AC%E4%BA%AD", "UTF-8");
        System.out.println(string);
    }
}
