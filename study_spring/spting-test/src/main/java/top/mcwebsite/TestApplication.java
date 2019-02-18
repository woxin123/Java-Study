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
        // 使用到Supplier
        context.registerBean("stu", Student.class, () -> {
            Student stu = new Student();
            stu.setName("阿雷");
            stu.setSex('男');
            stu.setClazz("铁塔一班");
            stu.setSid("01010101");
            return stu;
        });
        Student stu = (Student) context.getBean("stu");
        System.out.println(stu);
    }

}
