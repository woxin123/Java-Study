package com.example.security.core.validate.core.impl;

import com.example.security.core.properties.SecurityProperties;
import com.example.security.core.validate.core.ValidateCode;
import com.example.security.core.validate.core.ValidateCodeGenerator;
import com.example.security.core.validate.core.ValidateCodeProcessor;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Map;

@Component
public abstract class AbstractValidateCodeProcessor<C extends ValidateCode> implements ValidateCodeProcessor {

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Autowired
    private Map<String, ValidateCodeGenerator> validateCodeGenerators;




    @Override
    public void create(ServletWebRequest request) throws Exception {
        C validatCode = generator(request);
        save(request, validatCode);
        send(request, validatCode);
    }

    @SuppressWarnings("unchecked")
    private C generator(ServletWebRequest request) {
        String type = getProcessorType(request);
        for (int i = 0; i < validateCodeGenerators.size(); i++) {
            System.out.println(validateCodeGenerators.keySet().toString());
        }
        System.out.println(type + getProcessorType(request));
        ValidateCodeGenerator validateCodeGenerator = validateCodeGenerators.get(type + "CodeGenerator");
        return (C) validateCodeGenerator.generate(request);
    }

    /**
     * 保存校验码
     * @param request
     * @param validateCode
     */
    private void save(ServletWebRequest request, C validateCode) {
        sessionStrategy.setAttribute(request, SESSION_KEY_PREFIX + getProcessorType(request).toUpperCase(),
                validateCode);
    }


    /**
     * 发送校验码，由子类实现
     * @param request
     * @throws Exception
     */
    protected abstract void send(ServletWebRequest request, C validate) throws Exception;


    private String getProcessorType(ServletWebRequest request) {
        return StringUtils.substringAfter(request.getRequest().getRequestURI(), "/code/");
    }
}
