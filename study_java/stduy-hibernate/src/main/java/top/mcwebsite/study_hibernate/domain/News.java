package top.mcwebsite.study_hibernate.domain;

import javax.persistence.*;

/**
 * @Entity 标注该类是Hibernate的实体类
 * @Table 指的映射数据库的表明
 * @author mengchen
 * @time 18-9-29 下午10:45
 */
@Entity
@Table(name = "news_inf")
public class News {

    /**
     * @Id 用于指定该类的标识属性。所谓的标识属性，就是可以唯一标识该对象的属性。也就是主键
     * @GeneratedValue 用于指定主键生成的策略，其中的strategy属性指定了主键生成的策略。
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
