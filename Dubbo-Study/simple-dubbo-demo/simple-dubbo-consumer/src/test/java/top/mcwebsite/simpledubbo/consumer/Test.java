package top.mcwebsite.simpledubbo.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.mcwebsite.simpledubbo.api.DemoService;

import java.io.IOException;

/**
 * @author mengchen
 * @time 18-12-13 下午2:46
 */
public class Test {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:springmvc.xml");
        context.start();
        DemoService demoService = (DemoService) context.getBean("demoService");

        System.out.println(demoService.sayHello("mc"));

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
