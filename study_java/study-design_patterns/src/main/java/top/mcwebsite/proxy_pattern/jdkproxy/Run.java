package top.mcwebsite.proxy_pattern.jdkproxy;

import top.mcwebsite.proxy_pattern.UserService;
import top.mcwebsite.proxy_pattern.UserServiceImpl;

/**
 * @author mengchen
 * @time 18-10-13 下午4:15
 */
public class Run {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        UserServiceInvocationHandler proxy = new UserServiceInvocationHandler();
        UserService userService = proxy.bind(new UserServiceImpl());
        userService.login(1);
        userService.login(5);
    }
}
