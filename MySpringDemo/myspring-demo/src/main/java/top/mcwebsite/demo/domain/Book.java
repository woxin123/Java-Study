package top.mcwebsite.demo.domain;

import javax.validation.constraints.NotBlank;

/**
 * @author mengchen
 * @time 18-7-25 上午8:48
 */
public class Book {
    private Integer id;
    @NotBlank(message = "书名不能为空")
    private String bookName;
    @NotBlank(message = "作者不能为空")
    private String bookAuthor;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }
}
