package com.example.security.core.validate.core;

import com.example.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidateCodeBeanConfig {

    @Autowired
    private SecurityProperties securityProperties;

    @Bean
    public ValidateCoreGenerate imageCodeGenerator() {
        ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
    }
}
