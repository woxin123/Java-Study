package top.mcwebsite;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.mcwebsite.bean.Student;
import top.mcwebsite.test.ApplicationConfig;

/**
 * @author mengchen
 * @time 18-11-6 下午3:19
 */
public class TestApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Student student = (Student) context.getBean("student");
        System.out.println(student);
    }

}
