package top.mcwebsite.dubboproviderdemo.config;

import com.alibaba.dubbo.config.*;
import com.example.gmall.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mengchen
 * @time 18-12-18 下午4:13
 */
//@Configuration
public class MyDubboConfig {

    /**
     *     <dubbo:application name="user-service-provider" />
     * @return
     */
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("user-service-provider");
        return applicationConfig;
    }

    /**
     *     <dubbo:registry protocol="zookeeper" address="127.0.0.1" port="2181" />
     * @return
     */
    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setProtocol("zookeeper");
        registryConfig.setAddress("127.0.0.1");
        registryConfig.setPort(2181);
        return registryConfig;
    }

    //     <dubbo:protocol name="dubbo" port="20082" />
    @Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20882);
        return protocolConfig;
    }

    /**
     *  <dubbo:service interface="com.example.gmall.service.UserService"
     *                    ref="userServiceImpl" timeout="1000" version="1.0.0">
     *         <dubbo:method name="getUserAddressList" timeout="1000" />
     *     </dubbo:service>
     * @return
     */
    @Bean
    public ServiceConfig<UserService> userServiceServiceConfig(UserService userService) {
        ServiceConfig<UserService> serviceConfig = new ServiceConfig<>();
        serviceConfig.setInterface(UserService.class);
        serviceConfig.setRef(userService);
        serviceConfig.setValidation("1.0.0");

        // 配置method信息
        MethodConfig methodConfig = new MethodConfig();
        methodConfig.setName("getUserAddressList");
        methodConfig.setTimeout(1000);

        // 将method的设置配置到service配置中
        List<MethodConfig> methods = new ArrayList<>();
        methods.add(methodConfig);
        serviceConfig.setMethods(methods);
        return serviceConfig;
    }

}
