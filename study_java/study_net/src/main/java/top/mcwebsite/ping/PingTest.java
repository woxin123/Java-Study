package top.mcwebsite.ping;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author mengchen
 * @time 19-4-27 下午8:37
 */
public class PingTest {

    public static void main(String[] args) throws IOException {
        int timeout = 300;
        boolean status = InetAddress.getByName("www.baidu.com").isReachable(timeout);
        System.out.println(status);
    }

}
