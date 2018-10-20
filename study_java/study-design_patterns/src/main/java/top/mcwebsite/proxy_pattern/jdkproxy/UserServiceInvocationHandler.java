package top.mcwebsite.proxy_pattern.jdkproxy;

import top.mcwebsite.proxy_pattern.UserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author mengchen
 * @time 18-10-13 下午4:03
 */
public class UserServiceInvocationHandler implements InvocationHandler {

    private UserService userService;

    public UserService bind(UserService userService) {
        this.userService = userService;
        return (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader()
                , userService.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("login")) {
            before(args);
            boolean result = (boolean) method.invoke(userService, args);
            after(result, args);
            return result;
        }
        return null;
    }

    private void before(Object[] args) {
        System.out.println("id为" + args[0] + "的用户尝试登录");
    }

    private void after(boolean result, Object[] args) {
        if (result) {
            System.out.println("id为" + args[0] + "的用户登录成功");
        } else {
            System.out.println("id为" + args[0] + "的用户登录失败");
        }
    }

}
