package top.mcwebsite.javaproxy;

/**
 * @author mengchen
 * @time 19-3-18 上午8:42
 */
public class BookServiceImpl2 implements BookService{
    @Override
    public void saveBook() {
        System.out.println("图书保存成功");
    }

    public static void main(String[] args) {
        BookServiceImpl2 bookService = new BookServiceImpl2();
        bookService.saveBook();
    }
}
