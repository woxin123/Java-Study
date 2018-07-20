package top.mcwebsite.security;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// 过滤Security的自动配置
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@RestController
public class MyDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyDemoApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}
