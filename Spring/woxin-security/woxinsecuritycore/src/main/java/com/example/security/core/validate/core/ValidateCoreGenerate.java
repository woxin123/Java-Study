package com.example.security.core.validate.core;

import org.springframework.web.context.request.ServletWebRequest;

public interface ValidateCoreGenerate {

    ImageCode generate(ServletWebRequest request);
}
