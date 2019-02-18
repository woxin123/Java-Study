package top.mcwebsite.study_mybatis.config;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.util.List;
import java.util.Properties;

/**
 * @author mengchen
 * @time 18-12-27 下午9:49
 */
public class TestObjectFactory extends DefaultObjectFactory {
    @Override
    public Object create(Class type) {
        // 打印创建的对象名
        System.out.println(type.getName());
        return super.create(type);
    }

    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        return super.create(type, constructorArgTypes, constructorArgs);
    }

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
    }

    @Override
    public <T> boolean isCollection(Class<T> type) {
        return super.isCollection(type);
    }
}
