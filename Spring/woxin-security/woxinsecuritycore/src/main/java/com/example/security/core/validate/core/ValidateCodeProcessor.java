package com.example.security.core.validate.core;

import org.springframework.web.context.request.ServletWebRequest;

public interface ValidateCodeProcessor {
    /**
     * 验证码放入session时的前缀
     */
    String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";

    /**
     * 创建校验码
     * @param request
     * @throws Exception
     */
    void create(ServletWebRequest request) throws Exception;

    /**
     * 教研验证码
     * @param servletWebRequest
     */
    void validate(ServletWebRequest servletWebRequest);
}
