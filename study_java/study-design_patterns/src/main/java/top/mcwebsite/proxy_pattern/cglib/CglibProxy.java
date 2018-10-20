package top.mcwebsite.proxy_pattern.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author mengchen
 * @time 18-10-13 下午7:58
 */
public class CglibProxy implements MethodInterceptor {

    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (method.getName().equals("login")) {
            before(objects);
            boolean result = (boolean) methodProxy.invokeSuper(o, objects);
            after(result, objects);
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
