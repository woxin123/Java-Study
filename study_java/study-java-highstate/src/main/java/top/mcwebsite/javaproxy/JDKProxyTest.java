package top.mcwebsite.javaproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理
 */

class JDKProxy {
    // 维护一个目标对象
    private Object target;

    public JDKProxy(Object target) {
        this.target = target;
    }

    // 给目标对象生成代理对象
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("在目标对象方法执行前，格式的修正等");
                        Object returnValue = method.invoke(target, args);
                        System.out.println("在代理对象方法执行后，记录日志等");
                        return returnValue;
                    }
                });
    }
}

public class JDKProxyTest {
    public static void main(String[] args) {
        JDKProxy jdkProxy = new JDKProxy(new BookServiceImpl());
        BookService bookServiceImpl = (BookService) jdkProxy.getProxyInstance();
        bookServiceImpl.saveBook();
    }
}
