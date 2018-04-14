package com.example.security.core;

import com.example.security.core.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(SecurityProperties.class)
@Configuration
public class SecurityCoreConfig {

}
