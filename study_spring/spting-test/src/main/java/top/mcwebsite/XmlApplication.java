package top.mcwebsite;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.DefaultResourceLoader;
import top.mcwebsite.bean.Student;
import top.mcwebsite.bean.StudentFactoryBean;

/**
 * @author mengchen
 * @time 18-11-7 下午4:51
 */
public class XmlApplication {

    public static void main(String[] args) throws Exception {

        BeanFactory factory = new XmlBeanFactory(new DefaultResourceLoader().getResource("classpath:applicationContext.xml"));
        Student student = (Student) factory.getBean("student2");
        System.out.println(student);

//        StudentFactoryBean factoryBean = (StudentFactoryBean) applicationContext.getBean("&student");
//        System.out.println(factoryBean.getObject());
    }

}
