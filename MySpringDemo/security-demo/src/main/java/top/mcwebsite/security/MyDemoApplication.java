package top.mcwebsite.security;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mengchen
 */
@SpringBootApplication
@RestController
public class MyDemoApplication {

    @Autowired
    ObjectMapper objectMapper;

    public static void main(String[] args) {
        SpringApplication.run(MyDemoApplication.class, args);
    }
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}
