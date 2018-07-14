package top.mcwebsite.javaproxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Cglib 代理
 */

class BookServiceWithoutInterface {
    public void saveBook() {
        System.out.println("保存成功！");
    }
}

class CglibProxyFactory<T> implements MethodInterceptor {
    private T target;

    public CglibProxyFactory(T target) {
        this.target = target;
    }

    public T getProxyInstance() {
        // 1. 工具类
        Enhancer en = new Enhancer();
        // 2. 设置父类
        en.setSuperclass(target.getClass());
        // 3. 设置回调方法
        en.setCallback(this);
        // 4. 创建子类对象
        return (T) en.create();
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("在目标对象方法执行前，格式的修正等");
        Object returnValue = method.invoke(target, objects);
        System.out.println("在代理对象方法执行后，记录日志等");
        return returnValue;
    }
}

public class CGlibProxyTest {
    public static void main(String[] args) {
        CglibProxyFactory<BookServiceWithoutInterface> proxyTest =
                new CglibProxyFactory<>(new BookServiceWithoutInterface());
        BookServiceWithoutInterface bookServiceImpl = proxyTest.getProxyInstance();
        bookServiceImpl.saveBook();
    }
}
