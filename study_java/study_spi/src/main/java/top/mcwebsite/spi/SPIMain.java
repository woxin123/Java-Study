package top.mcwebsite.spi;

import java.util.ServiceLoader;

/**
 * @author mengchen
 * @time 18-12-20 下午4:33
 */
public class SPIMain {

    public static void main(String[] args) {
        ServiceLoader<HelloInterface> loaders = ServiceLoader.load(HelloInterface.class);
        System.out.println("classpath:" + System.getProperty("java.class.path"));
        for (HelloInterface in : loaders) {
            in.sayHello();
        }
    }
}
