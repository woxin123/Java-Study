package mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;

import java.io.IOException;
import java.io.Reader;
import java.util.Collection;

/**
 * @author mengchen
 * @time 18-12-24 下午8:30
 */
public class BaseMapperTest {

    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void init() {
        try (Reader reader = Resources.getResourceAsReader("mybatis-config.xml")) {
            sqlSessionFactory = new SqlSessionFactoryBuilder()
                    .build(reader);
        } catch (IOException ignore) {
            ignore.printStackTrace();
        }
    }

    public SqlSession getSqlSession() {
        Thread.currentThread().getContextClassLoader();
        getClass().getClassLoader();
        ClassLoader.getSystemClassLoader();
        return sqlSessionFactory.openSession();
    }

}
