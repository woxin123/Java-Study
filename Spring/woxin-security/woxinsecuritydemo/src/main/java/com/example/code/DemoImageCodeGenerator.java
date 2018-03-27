package com.example.code;

import com.example.security.core.validate.core.ImageCode;
import com.example.security.core.validate.core.ValidateCoreGenerate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

//@Component("imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCoreGenerate{


    @Override
    public ImageCode generate(ServletWebRequest request) {
        System.out.println("更高级的图形验证码");
        return null;
    }
}
