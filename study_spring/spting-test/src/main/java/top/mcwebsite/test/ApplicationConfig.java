package top.mcwebsite.test;

import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import top.mcwebsite.bean.Student;

/**
 * @author mengchen
 * @time 18-11-6 下午3:29
 */
@Configuration
@ComponentScan("top.mcwebsite.bean")
public class ApplicationConfig {
    @Bean
    public Student student() {
        Student student = new Student();
        student.setSid("04161011");
        student.setClazz("网络1901");
        student.setName("张三");
        student.setSex('男');
        return student;
    }
}
