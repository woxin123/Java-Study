package org.example.heighlight_spring.ch1.di.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

    @Bean
    public FuncationService funcationService() {
        return new FuncationService();
    }

    @Bean
    public UseFuncationService useFuncationService() {
        UseFuncationService useFuncationService = new UseFuncationService();
        useFuncationService.setFuncationService(funcationService());
        return useFuncationService;
    }

    // 只要容器中存在
//    @Bean
//    public UseFuncationService useFuncationService(FuncationService funcationService) {
//        UseFuncationService useFuncationService = new UseFuncationService();
//        useFuncationService.setFuncationService(funcationService);
//        return useFuncationService;
//    }
}
