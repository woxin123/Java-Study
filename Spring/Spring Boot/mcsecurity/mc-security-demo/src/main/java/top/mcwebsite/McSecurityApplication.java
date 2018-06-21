package top.mcwebsite;


import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mcwebsite.config.AutherSetting;
import top.mcwebsite.domain.Person;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@RestController
public class McSecurityApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(McSecurityApplication.class);
        // 设置不使用banner
//        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello Spring Security";
    }

    @Value("${book.name}")
    private String bookName;

    @Value("${book.auther}")
    private String bookAuther;

    @GetMapping("/")
    public String index() {
        return "book name is " + bookName + " and book auther is " + bookAuther;
    }

    @Autowired
    private AutherSetting autherSetting;

    @GetMapping("/auther")
    public String auther() {
        return "auther name is " + autherSetting.getName() +
                " , age is " + autherSetting.getAge();
    }

    @Controller
    class TestController {
        @RequestMapping("/person")
        public String index(Model model) {
            Person single = new Person("aa", 11);
            List<Person> people = new ArrayList<>();
            Person p1 = new Person("xx", 11);
            Person p2 = new Person("yy", 22);
            Person p3 = new Person("zz", 33);
            people.add(p1);
            people.add(p2);
            people.add(p3);
            model.addAttribute("singlePerson", single);
            model.addAttribute("people", people);

            return "index";
        }

    }

    // 配置从http转向https
    @Bean
    public Connector connector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        connector.setPort(8080);
        connector.setSecure(false);
        connector.setRedirectPort(8443);
        return connector;
    }

    @Bean
    public TomcatServletWebServerFactory tomcatServletWebServerFactory() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint securityConstraint = new SecurityConstraint();
                securityConstraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/");
                securityConstraint.addCollection(collection);
                context.addConstraint(securityConstraint);
            }
        };
        tomcat.addAdditionalTomcatConnectors(connector());

        return tomcat;
    }


}
