package top.mcwebsite.javaproxy;

/**
 * Java 静态代理
 */

interface BookService {
    void saveBook();
}

class BookServiceImpl implements BookService {

    public void saveBook() {
        System.out.println("保存成功！");
    }
}

/**
 * 代理类，静态代理
 */
class StaticBookServiceProxy {

    // 代理的对象
    private BookService target;

    public StaticBookServiceProxy(BookService target) {
        this.target = target;
    }

    public void saveBook() {
        System.out.println("在目标对象方法执行前，格式的修正等");
        target.saveBook();  // 执行目标对象的方法
        System.out.println("在代理对象方法执行后，记录日志等");
    }
}

public class StaticProxyTest {
    public static void main(String[] args) {
        BookService bookService = new BookServiceImpl();
        StaticBookServiceProxy staticProxy = new StaticBookServiceProxy(bookService);
        staticProxy.saveBook();
    }
}
