package top.mcwebsite.Internet;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * @author mengchen
 * @time 19-4-27 下午9:26
 */
public class InetAddressTest {

    public static void main(String[] args) {
        try {
            // 通过这个类可以将域名转换为ip
            InetAddress address = InetAddress.getByName("www.baidu.com");
            System.out.println(address);

            // 反向查询，如果能查询到就返回查询的结果
            InetAddress address1 = InetAddress.getByName("220.181.111.37");
            System.out.println(address1);

            // 获取一个域名的所有IP地址
            InetAddress[] addresses = InetAddress.getAllByName("baidu.com");
            System.out.println(Arrays.toString(addresses));

            // 获取本地的IP地址
            InetAddress localhostAddress = InetAddress.getLocalHost();
            System.out.println(localhostAddress);
        } catch (UnknownHostException e) {
            System.out.println("Could not find www,baidu.com");
        }
    }

}
