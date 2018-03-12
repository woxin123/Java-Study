package com.example.config;

import com.example.interceptor.TimeInterceptor;
import com.example.web.filter.TimeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

//@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{


    @Autowired
    private TimeInterceptor timeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeInterceptor);
    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
//        // 异步拦截器
//        configurer.registerCallableInterceptors();
//
//        // 超时时间
//        configurer.setDefaultTimeout();
//        // 线程池的设置
//        configurer.setTaskExecutor();
        super.configureAsyncSupport(configurer);
    }

    @Bean
    public FilterRegistrationBean timeFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        TimeFilter timeFilter = new TimeFilter();
        registrationBean.setFilter(timeFilter);
        List<String> urls = new ArrayList<>();
        urls.add("/*");
        registrationBean.setUrlPatterns(urls);
        return registrationBean;
    }
}
