package top.mcwebsite;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import top.mcwebsite.bean.Student;

/**
 * @author mengchen
 * @time 19-1-29 下午5:29
 */
public class StuBeanPostProcessor implements BeanPostProcessor {

    /**
     * 在bean初始化之前调用
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("student2")) {
            Student student = (Student) bean;
            student.setClazz("大炮一班");
        }
        return bean;
    }

    /**
     * 在bean初始化之后调用
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }
}
