package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * @author: mengchen
 * Create by 18-4-16
 */
@Configuration
public class WebApplicationConfig extends WebMvcConfigurerAdapter {


    @Bean
    public BeanNameViewResolver beanNameViewResolver() {
        BeanNameViewResolver resolver = new BeanNameViewResolver();
        return resolver;
    }

    @Bean
    public MappingJackson2JsonView jsonView() {
        MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
        return jsonView;
    }


}
