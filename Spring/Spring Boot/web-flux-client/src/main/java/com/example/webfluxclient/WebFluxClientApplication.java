package com.example.webfluxclient;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import top.mcwebsite.client.interfaces.ProxyCreator;
import top.mcwebsite.client.proxy.JdkProxyCreator;

/**
 * @author mengchen
 */
@SpringBootApplication
public class WebFluxClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebFluxClientApplication.class, args);
    }

    /**
     * 创建JDK动态代理类
     * @return
     */
    @Bean
    ProxyCreator jdkProxyCreator() {
        return new JdkProxyCreator();
    }

    @Bean
    FactoryBean<IUserApi> userApi(ProxyCreator proxyCreator) {
        return new FactoryBean<IUserApi>() {
            /**
             * 返回一个代理对象
             * @return
             * @throws Exception
             */
            @Override
            public IUserApi getObject() throws Exception {
                return (IUserApi) proxyCreator.createProxy(this.getObjectType());
            }

            @Override
            public Class<?> getObjectType() {
                return IUserApi.class;
            }
        };
    }
}
