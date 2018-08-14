package top.mcwebsite.security.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.mcwebsite.security.web.filter.TimeFilter;
import top.mcwebsite.security.web.interceptor.TimeInterceptor;

import java.util.ArrayList;
import java.util.List;

/**
 * @time 18-7-25 下午2:43
 * @author mengchen
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

//    @Autowired
//    private TimeInterceptor timeInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(timeInterceptor);
//    }


    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        // 注册异步Callable拦截器
//        configurer.registerCallableInterceptors()
        // 注册DeferredResult拦截器
//        configurer.registerDeferredResultInterceptors()
        // 设置线程池
//        configurer.setTaskExecutor()
    }

    //    @Bean
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
