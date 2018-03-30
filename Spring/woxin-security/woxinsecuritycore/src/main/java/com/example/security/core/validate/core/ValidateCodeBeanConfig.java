package com.example.security.core.validate.core;

import com.example.security.core.properties.SecurityProperties;
import com.example.security.core.validate.core.image.ImageCodeGenerator;
import com.example.security.core.validate.core.sms.DefaultSmsCodeSender;
import com.example.security.core.validate.core.sms.SmsCodeGenerator;
import com.example.security.core.validate.core.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidateCodeBeanConfig {

    @Autowired
    private SecurityProperties securityProperties;

    // 如果有名字为imageCodeGenerator的bean 那么就不使用这个bean了
    @Bean
    @ConditionalOnMissingBean(name = "imageCodeGenerator")
    public ValidateCodeGenerator imageCodeGenerator() {
        ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
        codeGenerator.setSecurityProperties(securityProperties);
        return codeGenerator;
    }

    // 如果有实现SmsCodeSender的类就不使用这个bean了
    @Bean
    @ConditionalOnMissingBean(SmsCodeSender.class)
    public SmsCodeSender smsCodeSender() {
        return new DefaultSmsCodeSender();
    }


}
