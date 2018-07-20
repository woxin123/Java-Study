package top.mcwebsite.httpclient;

import org.apache.http.*;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.message.BasicHttpResponse;

/**
 * 设置 Headers
 */
public class HttpClientDemoTest4 {

    public static void main(String[] args) {
        HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1,
                HttpStatus.SC_OK, "OK");
        response.addHeader("Set-Cookie",
                "c1=a; path=/; domain=localhost");
        response.addHeader("Set-Cookie",
                "c2=b; path=\"/\", c3=c; domain=\"localhost\"");
        Header h1 = response.getFirstHeader("Set-Cookie");
        System.out.println(h1);
        Header h2 = response.getLastHeader("Set-Cookie");
        System.out.println(h2);
        Header[] hs = response.getHeaders("Set-Cookie");
        HeaderIterator it = response.headerIterator();
        while (it.hasNext()) {
            System.out.println(it.nextHeader());
        }
        HeaderElementIterator itElem = new BasicHeaderElementIterator(
                response.headerIterator("Set-Cookie"));
        while (itElem.hasNext()) {
            HeaderElement elem = itElem.nextElement();
            System.out.println(elem.getName() + " = " + elem.getValue());
            NameValuePair[] params = elem.getParameters();
            for (int i = 0; i < params.length; i++) {
                System.out.println(" " + params[i]);
            }
        }
        System.out.println(hs.length);
    }

}
