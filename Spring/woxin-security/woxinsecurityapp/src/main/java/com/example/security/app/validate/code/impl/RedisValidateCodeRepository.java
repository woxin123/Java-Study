package com.example.security.app.validate.code.impl;

import com.example.security.core.validate.core.ValidateCode;
import com.example.security.core.validate.core.ValidateCodeException;
import com.example.security.core.validate.core.ValidateCodeRepository;
import com.example.security.core.validate.core.ValidateCodeType;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.concurrent.TimeUnit;

/**
 * @author: mengchen
 * Create by 18-4-18
 */
@Component
public class RedisValidateCodeRepository implements ValidateCodeRepository {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;


    @Override
    public void save(ServletWebRequest request, ValidateCode code, ValidateCodeType validateCodeType) {
        redisTemplate.opsForValue().set(buildKey(request, validateCodeType),
                code,
                30,
                TimeUnit.MINUTES);
    }

    @Override
    public ValidateCode get(ServletWebRequest request, ValidateCodeType validateCodeType) {
        Object value = redisTemplate.opsForValue().get(buildKey(request, validateCodeType));
        if (value == null) {
            return null;
        }
        return (ValidateCode) value;
    }

    @Override
    public void remove(ServletWebRequest request, ValidateCodeType codeType) {
        redisTemplate.delete(buildKey(request, codeType));
    }

    private String buildKey(ServletWebRequest request, ValidateCodeType type) {
        String deviceId = request.getHeader("deviceId");
        if (StringUtils.isBlank(deviceId)) {
            throw new ValidateCodeException("请在请求头中携带deviceId参数");
        }
        return "code: " + type.toString().toLowerCase() + ":" + deviceId;
    }
}
