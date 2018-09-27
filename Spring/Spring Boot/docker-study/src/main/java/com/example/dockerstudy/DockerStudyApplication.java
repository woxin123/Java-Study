package com.example.dockerstudy;

import com.example.dockerstudy.support.CustomRepositoryFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomRepositoryFactoryBean.class)
public class DockerStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockerStudyApplication.class, args);
    }
}
