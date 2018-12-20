package top.mcwebsite.mcdiscoveryeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class McDiscoveryEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(McDiscoveryEurekaApplication.class, args);
    }
}
