package top.mcwebsite.proxy_pattern.cglib;

import top.mcwebsite.proxy_pattern.UserService;
import top.mcwebsite.proxy_pattern.UserServiceImpl;

/**
 * @author mengchen
 * @time 18-10-13 下午8:03
 */
public class RunCglib {

    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        UserService userService = (UserService) cglibProxy.getInstance(new UserServiceImpl());
        userService.login(1);
        userService.login(3);
    }
}
