package top.mcwebsite.study_hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.internal.SessionFactoryServiceRegistryImpl;
import top.mcwebsite.study_hibernate.domain.News;

/**
 * @author mengchen
 * @time 18-9-30 下午5:17
 */
public class NewsManager {

    public static void main(String[] args) {
        // 实例化Configuration
        // 不带参数的configure()方法默认加载hibernate.cfg.xml文件
        Configuration configuration = new Configuration()
                .configure();
        // 创建一个Session工厂
        SessionFactory factory = configuration.buildSessionFactory();

        // 得到一个Session对象
        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();
        // 创建一个消息对象
        News news = new News();
        news.setTitle("你好，Hibernate");
        news.setContent("Hibernate已经过时了");
        // 保存
        session.save(news);
        // 提交事务
        tx.commit();
        // 关闭session
        session.close();
        factory.close();

    }
}
