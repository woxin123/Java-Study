package jvmtest;

import java.util.ArrayList;
import java.util.List;

/**
 * jdk8中去除了永久带，所以这个参数也就不起作用了
 * args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * @author mengchen
 * @time 18-10-23 下午4:22
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }

    }

}
